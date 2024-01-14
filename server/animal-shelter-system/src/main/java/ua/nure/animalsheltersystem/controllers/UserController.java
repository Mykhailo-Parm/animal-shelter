package ua.nure.animalsheltersystem.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{userID}")
    public User getUser(@PathVariable("userID") Long id) throws SQLException {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() throws SQLException {
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user) throws SQLException {
        System.out.println(user);
        userService.addNewUser(user);

    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long id) throws SQLException {
        System.out.println(id);
        userService.deleteUser(id);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) LocalDate dob,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String address,
                           @RequestParam(required = false) String phone_number) throws SQLException  {
        userService.updateUser(id, name, dob, email, address, phone_number);
    }
}
