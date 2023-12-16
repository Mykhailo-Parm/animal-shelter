package ua.nure.animalsheltersystem.user;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserDAOImpl userDAO;

    public UserService(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(Long id) throws SQLException {
        return userDAO.get(id);
    }

    public List<User> getUsers() throws SQLException {
        return userDAO.getAll();
    }

    public void addNewUser(User user) throws SQLException  {
        userDAO.insert(user);
    }

    public void deleteUser(Long id) throws SQLException  {
        userDAO.delete(id);
    }

    public void updateUser(Long id, String name, LocalDate dob, String email, String address, String phoneNumber) throws SQLException  {
        User user = new User(id, name, dob, email, address, phoneNumber);
        userDAO.update(user);
    }
}
