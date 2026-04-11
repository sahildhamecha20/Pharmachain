package Pharmachain.service.impl;

import Pharmachain.entity.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
}