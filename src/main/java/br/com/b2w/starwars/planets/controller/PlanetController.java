package br.com.b2w.starwars.planets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.starwars.planets.model.PlanetRequestDTO;
import br.com.b2w.starwars.planets.model.PlanetResponseDTO;
import br.com.b2w.starwars.planets.service.PlanetService;

@RestController
@RequestMapping("/planet")
public class PlanetController {
	
	@Autowired
	PlanetService planetService;
	
	@GetMapping
	public List<PlanetResponseDTO> getAll() {
		List<PlanetResponseDTO> planetList = planetService.findAll();
		return planetList;
	}
	
	@GetMapping("/planetId")
	public ResponseEntity<PlanetResponseDTO> getById(
			@PathVariable String planetId) {
		PlanetResponseDTO planetResponseDTO = planetService.findById(planetId);
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/planetName")
	public ResponseEntity<PlanetResponseDTO> getByName(
			@PathVariable String planetName) {
		PlanetResponseDTO planetResponseDTO = planetService.findByName(planetName);
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlanetResponseDTO> create(
			@RequestBody PlanetRequestDTO planetRequestDTO) {
		PlanetResponseDTO planetResponseDTO = planetService.create(planetRequestDTO);
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/planetId")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(
			@PathVariable String planetId) {
		planetService.delete(planetId);
	}
}
