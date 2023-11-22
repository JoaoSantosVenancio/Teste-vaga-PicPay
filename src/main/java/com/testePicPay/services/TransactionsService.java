package com.testePicPay.services;

import com.testePicPay.domain.transaction.Transaction;
import com.testePicPay.domain.user.User;
import com.testePicPay.dtos.TransactionDTO;
import com.testePicPay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;


    public void createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverID());

        userService.validateTransaction(sender, transaction.value());
    }
}
