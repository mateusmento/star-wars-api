package starwarsapi.unittest.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;
import starwarsapi.repository.PlanetRepository;
import starwarsapi.service.PlanetServiceImpl;

@SpringBootTest
public class PlanetServiceImplTests {
 
    @Mock
    private PlanetRepository planetRepo;

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

}
