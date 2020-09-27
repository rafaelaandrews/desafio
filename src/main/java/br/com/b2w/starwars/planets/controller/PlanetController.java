package br.com.b2w.starwars.planets.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/")
	public List<PlanetResponseDTO> getAll() {
		List<PlanetResponseDTO> planetList = planetService.findAll();
		return planetList;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlanetResponseDTO> getById(
			@PathVariable String id) {
		PlanetResponseDTO planetResponseDTO = planetService.findById(id);
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<PlanetResponseDTO> getByName(
			@RequestParam String name) {
		PlanetResponseDTO planetResponseDTO = planetService.findByName(name);
		return new ResponseEntity<PlanetResponseDTO>(planetResponseDTO, HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(
			@Valid
			@RequestBody PlanetRequestDTO planetRequestDTO) {
		planetService.create(planetRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(
			@PathVariable String id) {
		planetService.delete(id);
	}
}
