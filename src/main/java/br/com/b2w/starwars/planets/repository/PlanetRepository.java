package br.com.b2w.starwars.planets.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.starwars.planets.model.PlanetEntity;

public interface PlanetRepository extends MongoRepository<PlanetEntity, String>, PlanetCustomRepository {
	
	public Page<PlanetEntity> findByNameContainingFilm(String name, Pageable pageable);

}
