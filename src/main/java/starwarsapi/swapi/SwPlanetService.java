package starwarsapi.swapi;

import java.util.Optional;
import reactor.core.publisher.Flux;

public interface SwPlanetService {
    Flux<Optional<SwPlanet>> findOneByName(String name);
}
