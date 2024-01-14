package ua.nure.animalsheltersystem.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.domain.DTO.AnimalDTO;
import ua.nure.animalsheltersystem.domain.DTO.UserDTO;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;

@Component
public class AnimalMapperImpl implements Mapper<AnimalEntity, AnimalDTO> {

    private ModelMapper modelMapper;

    public AnimalMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AnimalDTO mapTo(AnimalEntity animalEntity) {
        return modelMapper.map(animalEntity, AnimalDTO.class);
    }

    @Override
    public AnimalEntity mapFrom(AnimalDTO animalDTO) {
        return modelMapper.map(animalDTO, AnimalEntity.class);
    }
}
