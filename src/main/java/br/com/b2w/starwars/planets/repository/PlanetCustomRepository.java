package br.com.b2w.starwars.planets.repository;

import br.com.b2w.starwars.planets.model.PlanetEntity;

public interface PlanetCustomRepository {
	
	public PlanetEntity findOneByName(String name);
	public PlanetEntity findOne(String id);

}
