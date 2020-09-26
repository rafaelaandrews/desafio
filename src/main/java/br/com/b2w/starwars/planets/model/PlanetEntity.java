package br.com.b2w.starwars.planets.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class PlanetEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Indexed(unique = true)
	String name;
	
	String climate;
	String terrain;
	Integer films;

}
