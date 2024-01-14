package ua.nure.animalsheltersystem.services;

import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;

import java.util.List;

public interface BookedWalkService {
    public BookedWalkEntity createBookedWalk(BookedWalkEntity bookedWalkEntity);

    List<BookedWalkEntity> findAll();
}
