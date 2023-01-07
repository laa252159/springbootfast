package com.springbootfast.service;

import com.springbootfast.model.UserLogin;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginService {
    public boolean isLoggedIn(UserLogin userLogin) {
        if ("natali".equalsIgnoreCase(userLogin.getUserName()) && "password".equals(userLogin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
