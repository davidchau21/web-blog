package vn.com.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.edu.iuh.fit.backend.model.User;
import vn.com.edu.iuh.fit.backend.repositories.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void insert(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public Optional<User> findByEmail(String mail) {
        return userRepository.findByEmail(mail);
    }


    public boolean login(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPasswordHash().equals(password);
    }
}
