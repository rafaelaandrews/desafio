package br.com.b2w.starwars.planets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.starwars.planets.model.PlanetRequestDTO;
import br.com.b2w.starwars.planets.model.PlanetResponseDTO;

@RestController
@RequestMapping("/planets")
public class PlanetController {
	
	@GetMapping
	public List<PlanetResponseDTO> getAll() {
		List<PlanetResponseDTO> planetList = new ArrayList<>();
		return planetList;
	}
	
	@GetMapping("/planetId")
	public ResponseEntity<PlanetResponseDTO> getById(
			@PathVariable final Long planetId) {
		PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlanetResponseDTO> create(
			@RequestBody PlanetRequestDTO planetRequestDTO) {
		PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/planetId")
	public ResponseEntity<PlanetResponseDTO> update(
			@RequestBody PlanetRequestDTO planetRequestDTO,
			@PathVariable final Long planetId) {
		PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/planetId")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(
			@PathVariable final Long planetId) {
		
	}
}
