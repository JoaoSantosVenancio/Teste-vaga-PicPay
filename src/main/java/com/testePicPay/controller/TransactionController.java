package com.testePicPay.controller;

import com.testePicPay.domain.transaction.Transaction;
import com.testePicPay.dtos.TransactionDTO;
import com.testePicPay.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping
    public ResponseEntity<Transaction> madeTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        return new ResponseEntity<>(transactionsService.createTransaction(transaction), HttpStatus.OK);
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionsService.getAllTransaction();
    }

}
