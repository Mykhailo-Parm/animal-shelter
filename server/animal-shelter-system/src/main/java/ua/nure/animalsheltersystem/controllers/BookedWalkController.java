package ua.nure.animalsheltersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.animalsheltersystem.domain.DTO.BookedWalkDTO;
import ua.nure.animalsheltersystem.domain.entities.BookedWalkEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;
import ua.nure.animalsheltersystem.services.BookedWalkService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/bookedWalks")
public class BookedWalkController {
    private BookedWalkService bookedWalkService;
    private Mapper<BookedWalkEntity, BookedWalkDTO> bookedWalkMapper;
    @Autowired
    public BookedWalkController(BookedWalkService bookedWalkService, Mapper<BookedWalkEntity, BookedWalkDTO> bookedWalkMapper) {
        this.bookedWalkService = bookedWalkService;
        this.bookedWalkMapper = bookedWalkMapper;
    }

//    @GetMapping(path = "{userId}/{animalId}")
//    public BookedWalkDTO getBookedWalk(@PathVariable("userId") Long userId, @PathVariable("animalId") Long animalId) throws SQLException {
//        return bookedWalkService.getBookedWalk(userId, animalId);
//    }

    @GetMapping
    public List<BookedWalkDTO> getBookedWalks() {
        List<BookedWalkEntity> bookedWalks = bookedWalkService.findAll();
        return bookedWalks
                .stream()
                .map(bookedWalkMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookedWalkDTO> createNewBookedWalk(@RequestBody BookedWalkDTO bookedWalkDTO) {
        BookedWalkEntity bookedWalkEntity = bookedWalkMapper.mapFrom(bookedWalkDTO);
        BookedWalkEntity savebookedWalkEntity = bookedWalkService.createBookedWalk(bookedWalkEntity);

        return new ResponseEntity<>(bookedWalkMapper.mapTo(savebookedWalkEntity), HttpStatus.CREATED);
    }

//    @DeleteMapping(path = "{userId}/{animalId}")
//    public void deleteBookedWalk(@PathVariable("userId") Long userId, @PathVariable("animalId") Long animalId) throws SQLException {
//        bookedWalkService.deleteBookedWalk(userId, animalId);
//    }
//
//    @PutMapping(path = "{userId}/{animalId}")
//    public void updateBookedWalk(@PathVariable("userId") Long userId,
//                                 @PathVariable("animalId") Long animalId,
//                                 @RequestParam(required = false) LocalDate date_of_walk,
//                                 @RequestParam(required = false) int duration) throws SQLException  {
//        bookedWalkService.updateBookedWalk(userId, animalId, date_of_walk, duration);
//    }
}
