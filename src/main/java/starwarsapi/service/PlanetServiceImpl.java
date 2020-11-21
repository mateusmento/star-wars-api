package starwarsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import starwarsapi.filter.PlanetFilter;
import starwarsapi.model.Planet;
import starwarsapi.repository.PlanetRepository;
@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepo;

    public Page<Planet> list(PlanetFilter filter) {
        var pageable = filter.pageable();
        if (filter.getName() != null)
            return planetRepo.findByNameIgnoreCaseContaining(filter.getName(), pageable);
        return planetRepo.findAll(pageable);
    }
}
