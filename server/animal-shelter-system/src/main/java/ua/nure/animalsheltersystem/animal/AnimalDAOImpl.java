package ua.nure.animalsheltersystem.animal;

import org.springframework.stereotype.Component;
import ua.nure.animalsheltersystem.connector.Connector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalDAOImpl implements AnimalDAO{
    @Override
    public Animal get(Long id) throws SQLException {
        Connection connection = Connector.getConnection();
        Animal animal = null;
        String sql = "SELECT species, breed, name, dob, gender, description, color FROM pzdb.animals WHERE id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String species = resultSet.getString("species");
            String breed = resultSet.getString("breed");
            String name = resultSet.getString("name");
            LocalDate date_of_birth = resultSet.getDate("dob").toLocalDate();
            String gender = resultSet.getString("gender");
            String description = resultSet.getString("description");
            String color = resultSet.getString("color");
            animal = new Animal(id, species, breed, name, date_of_birth, gender, description, color);
        }
        Connector.closeResultSet(resultSet);
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
        AnimalFactory af = new AnimalFactory();
        return af.createAnimal(animal);
    }

    @Override
    public List<Animal> getAll() throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "SELECT id, species, breed, name, dob, gender, description, color FROM pzdb.animals";
        List<Animal> animals = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Long id = resultSet.getLong("id");
            String species = resultSet.getString("species");
            String breed = resultSet.getString("breed");
            String name = resultSet.getString("name");
            LocalDate date_of_birth = resultSet.getDate("dob").toLocalDate();
            String gender = resultSet.getString("gender");
            String description = resultSet.getString("description");
            String color = resultSet.getString("color");
            Animal animal = new Animal(id, species, breed, name, date_of_birth, gender, description, color);
            AnimalFactory af = new AnimalFactory();
            animals.add(af.createAnimal(animal));
        }
        Connector.closeResultSet(resultSet);
        Connector.closeConnection(connection);
        return animals;
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "DELETE FROM pzdb.animals WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }
    @Override
    public void update(Animal animal) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql = "UPDATE pzdb.animals SET " +
                "species = ?," +
                "breed = ?," +
                "name = ?," +
                "dob = ?," +
                "gender = ?," +
                "description = ?," +
                "color =? " +
                "WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, animal.getSpecies());
        preparedStatement.setString(2, animal.getBreed());
        preparedStatement.setString(3, animal.getName());
        preparedStatement.setDate(4, Date.valueOf(animal.getDate_of_birth()));
        preparedStatement.setString(5, animal.getGender());
        preparedStatement.setString(6, animal.getDescription());
        preparedStatement.setString(7, animal.getColor());
        preparedStatement.setLong(8, animal.getId());
        int result = preparedStatement.executeUpdate();
        Connector.closePreparedStatement(preparedStatement);
        Connector.closeConnection(connection);
    }
    @Override
    public void insert(Animal animal) throws SQLException {
        Connection connection = Connector.getConnection();
        String sql1 = "SELECT MAX(id) AS max_id FROM pzdb.animals;";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        ResultSet resultSet = preparedStatement1.executeQuery();

        Long highestId = 0L;
        if (resultSet.next()) {
            highestId = resultSet.getLong("max_id");
        }
        String sql2 = "INSERT INTO pzdb.animals (id, species, breed, name, dob, gender, description, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        preparedStatement2.setLong(1, highestId+1);
        preparedStatement2.setString(2, animal.getSpecies());
        preparedStatement2.setString(3, animal.getBreed());
        preparedStatement2.setString(4, animal.getName());
        preparedStatement2.setDate(5, Date.valueOf(animal.getDate_of_birth()));
        preparedStatement2.setString(6, animal.getGender());
        preparedStatement2.setString(7, animal.getDescription());
        preparedStatement2.setString(8, animal.getColor());
        int result = preparedStatement2.executeUpdate();
        Connector.closePreparedStatement(preparedStatement2);
        Connector.closeConnection(connection);
    }
    @Override
    public int save(Animal animal) throws SQLException {
        if (animal.getId()!=null && get(animal.getId()) != null) {
            update(animal);
        } else {
            insert(animal);
        }
        return 0;
    }
}
