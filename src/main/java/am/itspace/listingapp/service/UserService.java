package am.itspace.listingapp.service;

import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User addUser(User user);

    List<User> getUsers();

    User getById(int id) throws ResourceNotFoundException;

    void delete(int id);
}
