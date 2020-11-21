package starwarsapi.swapi;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class SwPlanetServiceImpl implements SwPlanetService {

    @Resource
    @Qualifier("swapi")
    private WebClient http;

    public Optional<SwPlanet> findOneByName(String name) {
        return findByName(name).search(name);
    }

    public SwPlanetPage findByName(String name) {
        try {
            return http.get().uri("/planets?search=" + name)
                .retrieve()
                .bodyToMono(SwPlanetPage.class)
                .block();
        } catch (WebClientResponseException ex) {
            System.err.println(ex);
            return new SwPlanetPage();
        }
    }
}
