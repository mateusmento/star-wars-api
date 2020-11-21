package starwarsapi.model;

import lombok.*;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Planet {
    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer totalFilmAppearances;
}
