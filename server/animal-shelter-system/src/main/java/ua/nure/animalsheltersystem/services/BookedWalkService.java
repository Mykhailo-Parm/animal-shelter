package ua.nure.animalsheltersystem.services;

import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;

import java.util.List;
import java.util.Optional;

public interface BookedWalkService {
    public BookedWalkEntity createBookedWalk(BookedWalkEntity bookedWalkEntity);

    List<BookedWalkEntity> findAll();

    Optional<BookedWalkEntity> findById(Long userId, Long animalId);
}
