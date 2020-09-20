package br.com.b2w.starwars.planets.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import br.com.b2w.starwars.planets.model.PlanetEntity;
import br.com.b2w.starwars.planets.model.PlanetRequestDTO;
import br.com.b2w.starwars.planets.model.PlanetResponseDTO;

@Mapper(componentModel="spring")
public interface PlanetMapper {
	
	PlanetEntity toEntity(PlanetRequestDTO planetRequestDTO);
	PlanetResponseDTO toResponseDTO(PlanetEntity planetEntity);
	List<PlanetResponseDTO> toResponseDTOList(List<PlanetEntity> planetEntity);
	@Mapping(target = "id", ignore = true)
	void updateFromDTO(PlanetRequestDTO planetRequestDTO, @MappingTarget PlanetEntity planetEntity);

}
