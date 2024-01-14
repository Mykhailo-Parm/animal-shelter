package ua.nure.animalsheltersystem.services.impl;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.repositories.BookedWalksRepository;
import ua.nure.animalsheltersystem.services.BookedWalkService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookedWalkServiceImpl implements BookedWalkService {

    private BookedWalksRepository bookedWalksRepository;

    public BookedWalkServiceImpl(BookedWalksRepository bookedWalksRepository) {
        this.bookedWalksRepository = bookedWalksRepository;
    }

    @Override
    public BookedWalkEntity createBookedWalk(BookedWalkEntity bookedWalkEntity) {
        return bookedWalksRepository.save(bookedWalkEntity);
    }

    @Override
    public List<BookedWalkEntity> findAll() {
        return StreamSupport
                .stream(
                        bookedWalksRepository
                                .findAll()
                                .spliterator()
                , false)
                .collect(Collectors.toList());
    }
}
