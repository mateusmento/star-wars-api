package starwarsapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
@PropertySource("classpath:application.properties")
public class SwapiWebClientConfiguration {

    @Value("${swapi.baseUrl}")
    private String swapiBaseUrl;

    @Value("${userAgent}")
    private String userAgent;

    @Bean(name="swapi")
    public WebClient swapi() {
        return WebClient.builder()
            .baseUrl(swapiBaseUrl)
            .defaultHeader(HttpHeaders.USER_AGENT, userAgent)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .build();
    }
}
