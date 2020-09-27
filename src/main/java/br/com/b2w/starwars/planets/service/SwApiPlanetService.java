package br.com.b2w.starwars.planets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.starwars.planets.model.SwApiPlanet;

@Component
public class SwApiPlanetService {

	@Value("${swapi.url.base}")
	private String swapiUrlBase;
	@Value("${swapi.planets.resource}")
	private String swapiPlanetsResource;

	@Autowired
	private RestTemplate restTemplate;

	public List<SwApiPlanet> getSwApiPlanetName(String name) {
		
		restTemplate.getForObject(swapiUrlBase, SwApiPlanet.class, name);

		return null;

	}

}
