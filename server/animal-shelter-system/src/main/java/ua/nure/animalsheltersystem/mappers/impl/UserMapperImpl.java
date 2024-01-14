package ua.nure.animalsheltersystem.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.domain.DTO.UserDTO;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;

@Component
public class UserMapperImpl implements Mapper<UserEntity, UserDTO> {

    private ModelMapper modelMapper;

    public UserMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserEntity mapFrom(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
