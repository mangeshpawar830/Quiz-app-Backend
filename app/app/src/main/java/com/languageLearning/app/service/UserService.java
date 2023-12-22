package com.languageLearning.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.languageLearning.app.model.Role;
import com.languageLearning.app.model.User;
import com.languageLearning.app.repo.UserRepository;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public User registerUser(User user) {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new RuntimeException("Username already exists");
        }

        user.setPassword(hashPassword(user.getPassword()));

        Role defaultRole = roleService.findRoleByName("USER");
        user.setRole(defaultRole);

        return userRepository.save(user);
    }
    
   

    public User loginUser(String userName, String password) {
        User user = userRepository.findByUserName(userName);

        if (user != null && hashPassword(password).equals(user.getPassword())) {
            return user;
        }

        return null; 
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password");
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1) hexStringBuilder.append('0');
            hexStringBuilder.append(hex);
        }
        return hexStringBuilder.toString();
    }


}
