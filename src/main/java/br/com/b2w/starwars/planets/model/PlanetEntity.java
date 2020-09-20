package br.com.b2w.starwars.planets.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class PlanetEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String nome;
	private String clima;
	private String terreno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	@Override
	public String toString() {
		return String.format(
				"Planet[nome='%s, clima='%s', terreno='%s']", nome, clima, terreno);
	}

}
