package Pharmachain.service.impl;

import Pharmachain.entity.User;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> loginUser(String email, String password);
}