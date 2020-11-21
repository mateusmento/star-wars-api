package starwarsapi.unittest.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;
import starwarsapi.repository.PlanetRepository;
import starwarsapi.service.PlanetServiceImpl;
import starwarsapi.swapi.SwPlanet;
import starwarsapi.swapi.SwPlanetService;

@SpringBootTest
public class PlanetServiceImplTests {
 
    @Mock
    private PlanetRepository planetRepo;

    @Mock
    private SwPlanetService swPlanetService;

    @InjectMocks
    private PlanetServiceImpl planetService;

    @Test
    private void listByName() {
        var filter = new PlanetFilter();
        filter.setName("Planet 1");

        Page<Planet> expected = Page.empty();

        when(planetRepo.findByNameIgnoreCaseContaining(filter.getName(), filter.pageable()))
            .thenReturn(expected);

        Page<Planet> actual = planetService.list(filter);

        assertSame(expected, actual);
    }

    @Test
    private void testListAll() {
        var filter = new PlanetFilter();

        Page<Planet> expected = Page.empty();

        when(planetRepo.findAll(filter.pageable())).thenReturn(expected);

        Page<Planet> actual = planetService.list(filter);

        assertSame(expected, actual);
    }

    @Test
    private void testCreate() {
        Planet planet = new Planet().withName("Mars").withClimate("Cold").withTerrain("Desert");
        SwPlanet swPlanet = new SwPlanet()
            .withName(planet.getName())
            .withFilms(List.of("The Martian"));

        when(swPlanetService.findOneByName(planet.getName())).thenReturn(Optional.of(swPlanet));
        when(planetRepo.insert(planet.withTotalFilmAppearances(swPlanet.getFilms().size())));

        Planet actual = planetService.create(planet);
    }
}
