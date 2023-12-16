package ua.nure.animalsheltersystem.bookedWalk;

import org.springframework.stereotype.Service;
import ua.nure.animalsheltersystem.animal.Animal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookedWalkService {

    private final BookedWalkDAOImpl bookedWalkDAO;

    public BookedWalkService(BookedWalkDAOImpl bookedWalkDAO) {
        this.bookedWalkDAO = bookedWalkDAO;
    }

    public BookedWalk getBookedWalk(Long userId, Long animalId) throws SQLException {
        return bookedWalkDAO.get(userId, animalId);
    }

    public List<BookedWalk> getBookedWalks() throws SQLException {
        return bookedWalkDAO.getAll();
    }

    public void addNewBookedWalk(BookedWalk bookedWalk) throws SQLException {
        bookedWalkDAO.insert(bookedWalk);
    }

    public void deleteBookedWalk(Long userId, Long animalId) throws SQLException {
        bookedWalkDAO.delete(userId, animalId);
    }

    public void updateBookedWalk(Long userId, Long animalId, LocalDate dateOfWalk, int duration) throws SQLException {
        BookedWalk bookedWalk = new BookedWalk(userId, animalId, dateOfWalk, duration);
        bookedWalkDAO.update(bookedWalk);
    }
}
