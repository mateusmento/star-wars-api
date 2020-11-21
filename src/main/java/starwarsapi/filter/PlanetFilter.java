package starwarsapi.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class PlanetFilter extends Pagination {
    private String name;
}
