package ua.nure.animalsheltersystem.user;


import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.connector.Connector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @Override
    public User get(Long id) throws SQLException {
        Connection connection = Connector.getConnection();
        User user = null;
        String sql = "SELECT name, dob, email, address, phone_number FROM pzdb.users WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String name = resultSet.getString("name");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phone_number = resultSet.getString("phone_number");
            user = new User(id, name, dob, email, address, phone_number);
        }
        Connector.closeResultSet(resultSet);
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);

        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "SELECT id, name, dob, email, address, phone_number FROM pzdb.users";
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Long Id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            LocalDate dob = resultSet.getDate("dob").toLocalDate();
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phone_number = resultSet.getString("phone_number");
            User user = new User(Id, name, dob, email, address, phone_number);
            users.add(user);
        }
        Connector.closeResultSet(resultSet);
        Connector.closeStatement(statement);
        Connector.closeConnection(connection);

        return users;
    }

    @Override
    public int save(User user) throws SQLException {
        if (user.getId()!=null && get(user.getId()) != null) {
            update(user);
        } else {
            insert(user);
        }
        return 0;
    }

    @Override
    public void insert(User user) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql1 = "SELECT MAX(id) AS max_id FROM pzdb.users;";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement1.executeQuery();

        Long highestId = 0L;
        if (resultSet.next()) {
            highestId = resultSet.getLong("max_id");
        }

        String sql2 = "INSERT INTO pzdb.users (id, name, dob, email, address, phone_number)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);

        preparedStatement2.setLong(1, highestId + 1);
        preparedStatement2.setString(2, user.getName());
        preparedStatement2.setDate(3, Date.valueOf(user.getDob()));
        preparedStatement2.setString(4, user.getEmail());
        preparedStatement2.setString(5, user.getAddress());
        preparedStatement2.setString(6, user.getPhone_number());

        int result = preparedStatement2.executeUpdate();

        Connector.closeResultSet(resultSet);
        Connector.closePreparedStatement(preparedStatement1);
        Connector.closePreparedStatement(preparedStatement2);
        Connector.closeConnection(connection);
    }

    @Override
    public void update(User user) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "UPDATE pzdb.users SET name = ?, dob = ?, email = ?, address = ?, phone_number = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setDate(2, Date.valueOf(user.getDob()));
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getAddress());
        preparedStatement.setString(5, user.getPhone_number());
        preparedStatement.setLong(6, user.getId());
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "DELETE FROM pzdb.users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }

}
