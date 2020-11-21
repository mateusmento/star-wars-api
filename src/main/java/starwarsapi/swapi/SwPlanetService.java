package starwarsapi.swapi;

import java.util.Optional;

public interface SwPlanetService {
    Optional<SwPlanet> findOneByName(String name);
    SwPlanetPage findByName(String name);
}
