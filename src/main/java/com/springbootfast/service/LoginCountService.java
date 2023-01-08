package com.springbootfast.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@ApplicationScope
public class LoginCountService {
    public AtomicInteger attemptsCounter = new AtomicInteger(0);

    public int increment() {
        return attemptsCounter.incrementAndGet();
    }

    public int getAttemptsCounter() {
        return attemptsCounter.get();
    }
}
