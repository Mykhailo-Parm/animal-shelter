package ua.nure.animalsheltersystem.bookedWalk;


import ua.nure.animalsheltersystem.connector.Connector;
import ua.nure.animalsheltersystem.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookedWalkCollectionDAOImpl implements BookedWalkDAO{

    private static final List<BookedWalk> bookedWalks = new ArrayList<BookedWalk>();

    static {
        bookedWalks.add(new BookedWalk(1L , 2L, LocalDate.parse("2023-12-15"), 120));
        bookedWalks.add(new BookedWalk(1L , 3L, LocalDate.parse("2023-12-30"), 120));
        bookedWalks.add(new BookedWalk(2L, 2L, LocalDate.parse("2023-12-26"), 45));
    }

    @Override
    public BookedWalk get(Long id) throws SQLException {
        System.out.println("UNSUPPORTED");
        return null;
    }

    public BookedWalk get(Long userId, Long animalId) throws SQLException {
        for (BookedWalk bookedWalk : bookedWalks) {
            if (Objects.equals(bookedWalk.getIdUser(), userId) &&
                    Objects.equals(bookedWalk.getIdAnimal(), animalId)) {
                return bookedWalk;
            }
        }
        return null;
    }

    @Override
    public List<BookedWalk> getAll() throws SQLException {
        return bookedWalks;
    }

    @Override
    public int save(BookedWalk bookedWalk) throws SQLException {
        if(bookedWalk.getIdUser() !=null
                && bookedWalk.getIdAnimal()!=null
                && get(bookedWalk.getIdUser(), bookedWalk.getIdAnimal())!=null) {
            update(bookedWalk);
        } else {
            insert(bookedWalk);
        }
        return 0;
    }

    @Override
    public void insert(BookedWalk bookedWalk) throws SQLException {
        bookedWalks.add(bookedWalk);
    }

    @Override
    public void update(BookedWalk updatedBookedWalk) throws SQLException {
        for (BookedWalk bookedWalk : bookedWalks) {
            if (Objects.equals(bookedWalk.getIdUser(), updatedBookedWalk.getIdUser()) &&
                    Objects.equals(bookedWalk.getIdAnimal(), updatedBookedWalk.getIdAnimal())) {
                bookedWalk.setDate_of_walk(updatedBookedWalk.getDate_of_walk());
                bookedWalk.setDuration(updatedBookedWalk.getDuration());
            }
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        System.out.println("UNSUPPORTED");
    }

    public void delete(Long userId, Long animalId) throws SQLException {
        if (userId == 0) {
            bookedWalks.removeIf(bookedWalk -> bookedWalk.getIdAnimal().equals(animalId));
        } else if (animalId == 0) {
            bookedWalks.removeIf(bookedWalk -> bookedWalk.getIdUser().equals(userId));
        } else {
            bookedWalks.removeIf(bookedWalk -> Objects.equals(bookedWalk.getIdUser(), userId) &&
                    Objects.equals(bookedWalk.getIdAnimal(), animalId));
        }
    }
}
