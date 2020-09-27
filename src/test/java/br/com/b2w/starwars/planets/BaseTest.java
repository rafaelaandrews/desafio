package br.com.b2w.starwars.planets;

import br.com.b2w.starwars.planets.dto.PlanetResponseDTO;
import br.com.b2w.starwars.planets.model.PlanetEntity;

public class BaseTest {

    protected PlanetEntity getPlanetEntity() {
    	PlanetEntity planetEntity = new PlanetEntity();

    	planetEntity.setName("Alderaan");
    	planetEntity.setTerrain("temperate");
    	planetEntity.setClimate("grasslands, mountains");

        return planetEntity;
    }
    
    protected PlanetResponseDTO getPlanetResponse(PlanetEntity planetEntity) {
    	PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();
    	planetResponseDTO.setName(planetEntity.getName());
    	planetResponseDTO.setTerrain(planetEntity.getTerrain());
    	planetResponseDTO.setClimate(planetEntity.getClimate());
    	planetResponseDTO.setNumberOfFilmAppearances(5);
    	
        return planetResponseDTO;
    }
    
}
