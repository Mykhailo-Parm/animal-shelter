package ua.nure.animalsheltersystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.animalsheltersystem.domain.DTO.UserDTO;
import ua.nure.animalsheltersystem.domain.entities.UserEntity;
import ua.nure.animalsheltersystem.mappers.Mapper;
import ua.nure.animalsheltersystem.mappers.impl.UserMapperImpl;
import ua.nure.animalsheltersystem.services.UserService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private UserService userService;
    private Mapper<UserEntity, UserDTO> userMapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDTO> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//    @GetMapping(path = "{userID}")
//    public UserDTO getUser(@PathVariable("userID") Long id) {
//        return userService.getUser(id);
//    }

    @GetMapping
    public List<UserDTO> getUsers() {
        List<UserEntity> users = userService.findAll();
        return users
                .stream()
                .map(userMapper::mapTo)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userMapper.mapFrom(userDTO);
        UserEntity savedUserEntity = userService.createUser(userEntity);

        return new ResponseEntity<>(userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);
    }

//    @DeleteMapping(path = "{userId}")
//    public void deleteUser(@PathVariable("userId") Long id) {
//        System.out.println(id);
//        userService.deleteUser(id);
//    }
//
//    @PutMapping(path = "{userId}")
//    public void updateUser(@PathVariable("userId") Long id,
//                           @RequestParam(required = false) String name,
//                           @RequestParam(required = false) LocalDate dob,
//                           @RequestParam(required = false) String email,
//                           @RequestParam(required = false) String address,
//                           @RequestParam(required = false) String phone_number)  {
//        userService.updateUser(id, name, dob, email, address, phone_number);
//    }
}
