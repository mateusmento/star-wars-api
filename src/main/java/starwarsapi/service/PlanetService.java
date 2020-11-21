package starwarsapi.service;

import org.springframework.data.domain.Page;

import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;

public interface PlanetService {
    Page<Planet> list(PlanetFilter filter);
    Planet findById(String id);
    Planet create(Planet planet);
    void delete(String id);
}
