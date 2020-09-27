package br.com.b2w.starwars.planets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.starwars.planets.model.PlanetEntity;

public interface PlanetRepository extends MongoRepository<PlanetEntity, String>, PlanetCustomRepository {
	

}
