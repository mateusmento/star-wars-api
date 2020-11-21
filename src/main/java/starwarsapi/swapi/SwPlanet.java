package starwarsapi.swapi;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SwPlanet {
    private String name;
    private List<String> films;
}
