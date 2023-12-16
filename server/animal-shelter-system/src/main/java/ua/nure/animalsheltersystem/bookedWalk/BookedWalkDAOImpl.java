package ua.nure.animalsheltersystem.bookedWalk;

import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.connector.Connector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookedWalkDAOImpl implements BookedWalkDAO{

    public BookedWalk get(Long userId, Long animalId) throws SQLException {
        Connection connection = Connector.getConnection();
        BookedWalk bookedWalk = null;
        String sql = "SELECT id_user, id_animal, dow, duration FROM pzdb.booked_walks WHERE id_user = ? AND id_animal = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, userId);
        preparedStatement.setLong(2, animalId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            LocalDate date_of_walk = resultSet.getDate("dow").toLocalDate();
            int duration = resultSet.getInt("duration");
            bookedWalk = new BookedWalk(userId, animalId, date_of_walk, duration);
        }

        return bookedWalk;
    }

    @Override
    public BookedWalk get(Long id) throws SQLException {
        System.out.println("UNSUPPORTED");
        return null;
    }

    @Override
    public List<BookedWalk> getAll() throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "SELECT id_user, id_animal, dow, duration FROM pzdb.booked_walks";
        List<BookedWalk> bookedWalks = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Long UserId = resultSet.getLong("id_user");
            Long AnimalId = resultSet.getLong("id_animal");
            LocalDate date_of_walk = resultSet.getDate("dow").toLocalDate();
            int duration = resultSet.getInt("duration");
            BookedWalk bookedWalk = new BookedWalk(UserId, AnimalId, date_of_walk, duration);
            bookedWalks.add(bookedWalk);
        }
        Connector.closeResultSet(resultSet);
        Connector.closeConnection(connection);
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
        Connection connection = Connector.getConnection();
        String sql = "INSERT INTO pzdb.booked_walks (id_user, id_animal, dow, duration) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, bookedWalk.getIdUser());
        preparedStatement.setLong(2, bookedWalk.getIdAnimal());
        preparedStatement.setDate(3, Date.valueOf(bookedWalk.getDate_of_walk()));
        preparedStatement.setInt(4, bookedWalk.getDuration());
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }

    @Override
    public void update(BookedWalk bookedWalk) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "UPDATE pzdb.booked_walks SET dow = ?, duration = ? WHERE id_user = ? AND id_animal = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, Date.valueOf(bookedWalk.getDate_of_walk()));
        preparedStatement.setInt(2, bookedWalk.getDuration());
        preparedStatement.setLong(3, bookedWalk.getIdUser());
        preparedStatement.setLong(4, bookedWalk.getIdAnimal());
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }

    @Override
    public void delete(Long id) throws SQLException {
        System.out.println("UNSUPPORTED");
    }

    public void delete(Long userId, Long animalId) throws SQLException {
        Connection connection = Connector.getConnection();
        if (userId == 0) {
            String sql = "DELETE FROM pzdb.booked_walks WHERE id_animal = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, animalId);
            int result = preparedStatement.executeUpdate();
            Connector.closePreparedStatement(preparedStatement);
        } else if (animalId == 0) {
            String sql = "DELETE FROM pzdb.booked_walks WHERE id_user = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            int result = preparedStatement.executeUpdate();
            Connector.closePreparedStatement(preparedStatement);
        } else {
            String sql = "DELETE FROM pzdb.booked_walks WHERE id_user = ? AND id_animal = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, animalId);
            int result = preparedStatement.executeUpdate();
            Connector.closePreparedStatement(preparedStatement);
        }
        Connector.closeConnection(connection);
    }
}
