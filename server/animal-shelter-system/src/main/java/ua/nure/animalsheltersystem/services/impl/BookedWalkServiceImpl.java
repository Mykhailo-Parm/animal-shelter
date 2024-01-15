package ua.nure.animalsheltersystem.services.impl;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.repositories.BookedWalkRepository;
import ua.nure.animalsheltersystem.services.BookedWalkService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookedWalkServiceImpl implements BookedWalkService {

    private BookedWalkRepository bookedWalkRepository;

    public BookedWalkServiceImpl(BookedWalkRepository bookedWalkRepository) {
        this.bookedWalkRepository = bookedWalkRepository;
    }

    @Override
    public BookedWalkEntity createBookedWalk(BookedWalkEntity bookedWalkEntity) {
        return bookedWalkRepository.save(bookedWalkEntity);
    }

    @Override
    public List<BookedWalkEntity> findAll() {
        return StreamSupport
                .stream(
                        bookedWalkRepository
                                .findAll()
                                .spliterator()
                , false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookedWalkEntity> findById(Long userId, Long animalId) {
        return bookedWalkRepository.findOneByUser_IdAndAnimal_Id(userId, animalId);
    }
}
