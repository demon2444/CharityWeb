package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
    void saveAdmin(User user);
    void updateUser(User user);
    List<User> findAll();

}
