package com.testePicPay.dtos;

import java.math.BigDecimal;

public record TransactionDTO (BigDecimal value, Long senderId, Long receiverID){
}
