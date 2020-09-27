package br.com.b2w.starwars.planets.model;

public class PlanetResponseDTO {

	private String name;
	private String climate;
	private String terrain;
	private Integer numberOfFilmAppearances;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public Integer getNumberOfFilmAppearances() {
		return numberOfFilmAppearances;
	}

	public void setNumberOfFilmAppearances(Integer numberOfFilmAppearances) {
		this.numberOfFilmAppearances = numberOfFilmAppearances;
	}
	
}
