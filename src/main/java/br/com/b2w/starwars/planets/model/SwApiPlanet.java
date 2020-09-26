package br.com.b2w.starwars.planets.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwApiPlanet {

	private String name;
	private List<String> films;

	public String getName() {
		return name;
	}

	public List<String> getFilms() {
		return films;
	}

}
