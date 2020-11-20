package starwarsapi.swapi;

import java.util.List;

import lombok.Data;

@Data
public class SwPlanet {
    private String name;
    private List<String> films;
}
