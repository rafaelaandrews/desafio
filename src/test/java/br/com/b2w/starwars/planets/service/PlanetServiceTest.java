package br.com.b2w.starwars.planets.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.b2w.starwars.planets.BaseTest;
import br.com.b2w.starwars.planets.dto.PlanetResponseDTO;
import br.com.b2w.starwars.planets.model.PlanetEntity;
import br.com.b2w.starwars.planets.repository.PlanetRepository;

@RunWith(MockitoJUnitRunner.class)
public class PlanetServiceTest extends BaseTest{

	@Mock
	PlanetRepository planetRepository;
	
	@InjectMocks
	PlanetService planetService;
	
	@Mock
	SwApiPlanetService swApiPlanetService;
	
	@Test
	public void createTest() {
		
		PlanetEntity planetEntity = getPlanetEntity();
		PlanetResponseDTO planetResponseDTO = getPlanetResponse(planetEntity);
		
		
		
	}

}
