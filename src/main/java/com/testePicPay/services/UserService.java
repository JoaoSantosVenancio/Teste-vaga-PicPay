package com.testePicPay.services;

import com.testePicPay.domain.user.User;
import com.testePicPay.domain.user.UserType;
import com.testePicPay.dtos.UserDTO;
import com.testePicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal value) throws Exception {
        if (sender.getUserType() == UserType.SHOPERS){
            throw new Exception("Type user shopkeepers dont have permission!");
        }
        if(sender.getBalance().compareTo(value) < 0) {
            throw new Exception("Insufficient funds!");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(()-> new Exception("Cant find user"));
    }

    public User createUser(UserDTO user){
        User newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers (){
        List<User> users = this.repository.findAll();
        return users;
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
