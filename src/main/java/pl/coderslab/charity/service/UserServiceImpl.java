package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {

        Role userRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
        Role userRoleUser = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRoleAdmin, userRoleUser)));
        userRepository.save(user);
    }

    @Override
    public void revokeAdmin(User user) {

        Set<Role> roles = user.getRoles();

        Role userRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
        Role userRoleUser = roleRepository.findByName("ROLE_USER");

        roles.remove(userRoleAdmin);
        roles.add(userRoleUser);
        user.setRoles(roles);
        userRepository.save(user);
    }
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updatePassword(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public List<String> getAllUsersNames() {
        List<User> users = userRepository.findAll();
        List<String> usersNames = new ArrayList<>();
        for (User u : users
             ) { usersNames.add(u.getUsername());

        }
        return usersNames;
    }
}
