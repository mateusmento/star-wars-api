package starwarsapi.swapi;

import java.util.List;

import lombok.Data;

@Data
public class SwPlanetPage {
    private Integer count;
    private List<SwPlanet> results;
}
