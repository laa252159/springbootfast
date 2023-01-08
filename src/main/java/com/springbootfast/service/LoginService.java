package com.springbootfast.service;

import com.springbootfast.model.UserLogin;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class LoginService {

    private LoggedUserManagmentService loggedUserManagmentService;
    private LoginCountService loginCountService;

    public LoginService(LoggedUserManagmentService loggedUserManagmentService, LoginCountService loginCountService) {
        this.loggedUserManagmentService = loggedUserManagmentService;
        this.loginCountService = loginCountService;
    }

    public boolean isLoggedIn(UserLogin userLogin) {
        loginCountService.increment();
        boolean isLoggedIn = loggedUserManagmentService.getUserName() != null;
        if (isLoggedIn || "natali".equalsIgnoreCase(userLogin.getUserName()) && "password".equals(userLogin.getPassword())) {
            loggedUserManagmentService.setUserName("natali");
            return true;
        } else {
            return false;
        }
    }
}
