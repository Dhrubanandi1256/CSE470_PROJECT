package com.example.demo4.Service;

import com.example.demo4.Model.User;
import com.example.demo4.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {
    final UserRepository userRepository;
    public void addUser(User user){
        userRepository.save(user);
    }
    public void removeUser(User user){
        userRepository.delete(user);
    }
    public void editUser(User user){


    }

    public boolean loginValidate(User user){
        User user1 = null;
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            user1 = userRepository.findByEmail(user.getEmail()).get();
        }

        if (user1 != null){
            return user.getPassword().equals(user1.getPassword());
        }
        return false;
    }
}