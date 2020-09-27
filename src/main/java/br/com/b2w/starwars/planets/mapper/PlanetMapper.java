package br.com.b2w.starwars.planets.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.b2w.starwars.planets.dto.PlanetRequestDTO;
import br.com.b2w.starwars.planets.dto.PlanetResponseDTO;
import br.com.b2w.starwars.planets.model.PlanetEntity;

@Mapper
public interface PlanetMapper {
	
	PlanetEntity toEntity(PlanetRequestDTO planetRequestDTO);
	PlanetResponseDTO toResponseDTO(PlanetEntity planetEntity);
	List<PlanetResponseDTO> toResponseDTOList(List<PlanetEntity> planetEntity);
	
}
