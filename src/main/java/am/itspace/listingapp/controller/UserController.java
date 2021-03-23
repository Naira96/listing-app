package am.itspace.listingapp.controller;


import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.User;
import am.itspace.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        if (user.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return userService.getById(id);
    }

    @PutMapping("{id}")
    public User update(@RequestBody User user, @PathVariable("id") int id) throws ResourceNotFoundException {
        User byId = userService.getById(id);
        byId.setName(user.getName());
        byId.setSurname(user.getSurname());
        byId.setEmail(user.getEmail());
        byId.setPassword(user.getPassword());
        byId.setRole(user.getRole());

        return userService.addUser(byId);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }
}



