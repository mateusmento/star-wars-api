package starwarsapi.model;

import lombok.*;

@Data
public class Planet {
    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer filmAppearances;
}
