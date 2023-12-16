package ua.nure.animalsheltersystem.user;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserCollectionDAOImpl implements UserDAO {
    private static final List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1L,
                "John",
                LocalDate.parse("2000-10-10"),
                "jjohn@gmail.com",
                "Main str. 10",
                "+123123123"));

        users.add(new User(2L,
                "Marry",
                LocalDate.parse("2001-04-20"),
                "marry@gmail.com",
                "Little str. 10A",
                "+452341234"));
    }
    @Override
    public User get(Long id) throws SQLException {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
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
        users.add(user);
    }

    @Override
    public void update(User updatedUser) throws SQLException {
        for (User user : users) {
            if (Objects.equals(user.getId(), updatedUser.getId())) {
                user.setName(updatedUser.getName());
                user.setDob(updatedUser.getDob());
                user.setEmail(updatedUser.getEmail());
                user.setAddress(updatedUser.getAddress());
                user.setPhone_number(updatedUser.getPhone_number());
            }
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        users.removeIf(user -> Objects.equals(user.getId(), id));
    }
}
