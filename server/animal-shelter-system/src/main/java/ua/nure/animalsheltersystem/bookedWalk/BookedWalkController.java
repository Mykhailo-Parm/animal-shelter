package ua.nure.animalsheltersystem.bookedWalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookedWalks")
public class BookedWalkController {
    private final BookedWalkService bookedWalkService;
    @Autowired
    public BookedWalkController(BookedWalkService bookedWalkService) {
        this.bookedWalkService = bookedWalkService;
    }

    @GetMapping(path = "{userId}/{animalId}")
    public BookedWalk getBookedWalk(@PathVariable("userId") Long userId, @PathVariable("animalId") Long animalId) throws SQLException {
        return bookedWalkService.getBookedWalk(userId, animalId);
    }

    @GetMapping
    public List<BookedWalk> getBookedWalks() throws SQLException {
        return bookedWalkService.getBookedWalks();
    }

    @PostMapping
    public void registerNewBookedWalk(@RequestBody BookedWalk bookedWalk) throws SQLException {
        System.out.println(bookedWalk);
        bookedWalkService.addNewBookedWalk(bookedWalk);

    }

    @DeleteMapping(path = "{userId}/{animalId}")
    public void deleteBookedWalk(@PathVariable("userId") Long userId, @PathVariable("animalId") Long animalId) throws SQLException {
        bookedWalkService.deleteBookedWalk(userId, animalId);
    }

    @PutMapping(path = "{userId}/{animalId}")
    public void updateBookedWalk(@PathVariable("userId") Long userId,
                                 @PathVariable("animalId") Long animalId,
                                 @RequestParam(required = false) LocalDate date_of_walk,
                                 @RequestParam(required = false) int duration) throws SQLException  {
        bookedWalkService.updateBookedWalk(userId, animalId, date_of_walk, duration);
    }
}
