package am.itspace.listingapp.service.impl;

import am.itspace.listingapp.repository.UserRepository;
import am.itspace.listingapp.service.UserService;
import am.itspace.listingapp.exception.ResourceNotFoundException;
import am.itspace.listingapp.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with" + id + " does not exist"));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
