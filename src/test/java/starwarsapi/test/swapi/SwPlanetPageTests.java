package starwarsapi.test.swapi;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import starwarsapi.swapi.SwPlanet;
import starwarsapi.swapi.SwPlanetPage;

@SpringBootTest
public class SwPlanetPageTests {

    @Test
    public void search() {
        var expected = new SwPlanet().withName("Planet 1");
        List<SwPlanet> planets = List.of(expected, new SwPlanet().withName("Planet 2"));

        SwPlanetPage page = SwPlanetPage.builder().results(planets).build();

        Optional<SwPlanet> actual = page.search("Planet 1");

        assertTrue(actual.isPresent());
        assertSame(expected, actual.get());
    }
}
