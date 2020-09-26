package br.com.b2w.starwars.planets.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.b2w.starwars.planets.exception.ServiceException;
import br.com.b2w.starwars.planets.mapper.PlanetMapper;
import br.com.b2w.starwars.planets.model.PlanetEntity;
import br.com.b2w.starwars.planets.model.PlanetRequestDTO;
import br.com.b2w.starwars.planets.model.PlanetResponseDTO;
import br.com.b2w.starwars.planets.repository.PlanetRepository;

@Service
public class PlanetService {

	private final Logger logger = LoggerFactory.getLogger(PlanetService.class);

	@Autowired
	PlanetRepository planetRepository;

	@Autowired
	PlanetMapper planetMapper;

	public List<PlanetResponseDTO> findAll() {
		List<PlanetEntity> planetEntityList = planetRepository.findAll();
		List<PlanetResponseDTO> planetResponseDTOList = planetMapper.toResponseDTOList(planetEntityList);

		return planetResponseDTOList;
	}

	public PlanetResponseDTO findById(String planetId) {
		PlanetEntity planetEntity = findPlanetById(planetId);
		PlanetResponseDTO planetResponseDTO = planetMapper.toResponseDTO(planetEntity);

		return planetResponseDTO;
	}

	public PlanetResponseDTO create(PlanetRequestDTO planetRequestDTO) {
		validatePlanetRequestDTO(planetRequestDTO);

		PlanetEntity planetEntity = planetMapper.toEntity(planetRequestDTO);
		planetEntity = planetRepository.save(planetEntity);

		return planetMapper.toResponseDTO(planetEntity);
	}

	public PlanetResponseDTO update(PlanetRequestDTO planetRequestDTO, String planetId) {
		validatePlanetRequestDTO(planetRequestDTO);

		PlanetEntity planetEntity = findPlanetById(planetId);
		planetMapper.updateFromDTO(planetRequestDTO, planetEntity);
		planetEntity = planetRepository.save(planetEntity);

		return planetMapper.toResponseDTO(planetEntity);
	}

	public void delete(String planetId) {
		PlanetEntity planetEntity = findPlanetById(planetId);
		
		planetRepository.delete(planetEntity);
	}

	private PlanetEntity findPlanetById(String planetId) {
		validatePlanetId(planetId);

		return planetRepository.findOne(planetId);
	}

	private void validatePlanetRequestDTO(PlanetRequestDTO planetRequestDTO) {
		if (planetRequestDTO == null) {
			logger.error("planet is null");
			throw new ServiceException("PLANET_IS_NULL", "planet is null", HttpStatus.PRECONDITION_FAILED.value());
		}
	}

	private void validatePlanetId(String planetId) {
		if (planetId == null) {
			logger.error("planetId is null");
			throw new ServiceException("PLANET_ID_IS_NULL", "planetId is null", HttpStatus.PRECONDITION_FAILED.value());
		}
	}

}
