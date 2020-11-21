package starwarsapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import starwarsapi.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {
    Page<Planet> findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
