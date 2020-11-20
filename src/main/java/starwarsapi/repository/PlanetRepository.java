package starwarsapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import starwarsapi.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {
}
