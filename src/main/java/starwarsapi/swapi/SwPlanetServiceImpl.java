package starwarsapi.swapi;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class SwPlanetServiceImpl implements SwPlanetService {

    private WebClient http;

    public SwPlanetServiceImpl() {
        http = WebClient.create("https://swapi.dev/api");
    }

    public Flux<Optional<SwPlanet>> findOneByName(String name) {
        var res = http.get()
            .uri(builder -> builder.path("/planets").queryParam("search", name).build())
            .retrieve();

        var flux = res.bodyToFlux(SwPlanetPage.class)
            .map(page -> {
                var res1 = page.getResults().stream()
                    .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
                    .findAny();
                return res1;
            });

        return flux;
    }
}
