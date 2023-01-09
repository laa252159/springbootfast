package com.springbootfast.service;

import com.springbootfast.exceptions.NotEnoughMoneyException;
import com.springbootfast.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
