package pl.coderslab.charity.service;

import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    User findByUsername(String username);
    void saveUser(User user);
    void saveAdmin(User user);
    void updateUser(User user);
    void updatePassword(User user);
    List<User> findAll();
    void deleteUser(Long id);
    void revokeAdmin(User user);
    List<String> getAllUsersNames();
    String generateUUID();

}
