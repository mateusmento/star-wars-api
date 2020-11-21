package starwarsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import starwarsapi.exception.PlanetNotFoundException;
import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;
import starwarsapi.repository.PlanetRepository;
import starwarsapi.swapi.SwPlanetService;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private SwPlanetService swPlanetService;

    @Autowired
    private PlanetRepository planetRepo;

    public Page<Planet> list(PlanetFilter filter) {
        var pageable = filter.pageable();
        if (filter.getName() != null)
            return planetRepo.findByNameIgnoreCaseContaining(filter.getName(), pageable);
        return planetRepo.findAll(pageable);
    }

    public Planet findById(String id) {
        return planetRepo.findById(id).orElseThrow(PlanetNotFoundException::new);
    }

    public Planet create(Planet planet) {
        var swPlanet = swPlanetService.findOneByName(planet.getName());
        var appearances = swPlanet.map(p -> p.getFilms().size()).orElse(0);
        Planet insertable = planet.withTotalFilmAppearances(appearances);
        return planetRepo.insert(insertable);
    }

    public void delete(String id) {
        if (planetRepo.existsById(id))
            throw new PlanetNotFoundException();
        planetRepo.deleteById(id);
    }
}
