package starwarsapi.swapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SwPlanetPage {
    private Integer count = 0;
    private List<SwPlanet> results = new ArrayList<>();

    public Optional<SwPlanet> search(String name) {
        return results.stream()
            .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
            .findAny();
    }
}
