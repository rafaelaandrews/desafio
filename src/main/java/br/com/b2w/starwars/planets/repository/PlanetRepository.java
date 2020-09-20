package br.com.b2w.starwars.planets.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.starwars.planets.model.PlanetEntity;

public interface PlanetRepository extends MongoRepository<PlanetEntity, String> {
	
	public List<PlanetEntity> findAll();
	public PlanetEntity findById(Long planetId);

}
