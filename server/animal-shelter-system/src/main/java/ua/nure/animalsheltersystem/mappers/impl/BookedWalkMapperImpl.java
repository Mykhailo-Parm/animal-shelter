package ua.nure.animalsheltersystem.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.domain.DTO.AnimalDTO;
import ua.nure.animalsheltersystem.domain.DTO.BookedWalkDTO;
import ua.nure.animalsheltersystem.domain.entities.AnimalEntity;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;

@Component
public class BookedWalkMapperImpl implements Mapper<BookedWalkEntity, BookedWalkDTO> {

    private ModelMapper modelMapper;

    public BookedWalkMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BookedWalkDTO mapTo(BookedWalkEntity bookedWalkEntity) {
        return modelMapper.map(bookedWalkEntity, BookedWalkDTO.class);
    }

    @Override
    public BookedWalkEntity mapFrom(BookedWalkDTO bookedWalkDTO) {
        return modelMapper.map(bookedWalkDTO, BookedWalkEntity.class);
    }
}
