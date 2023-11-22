package com.testePicPay.services;

import com.testePicPay.domain.user.User;
import com.testePicPay.domain.user.UserType;
import com.testePicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal value) throws Exception {
        if (sender.getUserType() == UserType.SHOPKEEPERS){
            throw new Exception("Type user shopkeepers dont have permission!");
        }
        if(sender.getBalance().compareTo(value) < 0) {
            throw new Exception("Insufficient funds!");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(()-> new Exception("Cant find user"));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
