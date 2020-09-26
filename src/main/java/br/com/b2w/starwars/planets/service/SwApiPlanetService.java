package br.com.b2w.starwars.planets.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.starwars.planets.model.SwApiPlanet;

@Service
public class SwApiPlanetService {
	
	@Value("${swapi.url.base}")
	private String swapiUrlBase;
	@Value("${swapi.planets.resource}")
	private String swapiPlanetsResource;

	@Autowired
	private RestTemplate restTemplate;
	
    public List<SwApiPlanet> getSwApiPlanet(String name) {
        
    	return null;

    }

}
