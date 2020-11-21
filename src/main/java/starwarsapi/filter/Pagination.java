package starwarsapi.filter;

import org.springframework.data.domain.*;

import lombok.Data;

@Data
public class Pagination {
    private int page = 0;
    private int pageSize = 10;
    private String sortBy = "id";

    public Pageable pageable() {
        return PageRequest.of(page, pageSize, Sort.by("id"));
    }
}
