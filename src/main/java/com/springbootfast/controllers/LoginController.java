package com.springbootfast.controllers;

import com.springbootfast.model.UserLogin;
import com.springbootfast.service.LoginCountService;
import com.springbootfast.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private LoginCountService loginCountService;
    private LoginService loginService;

    public LoginController(LoginCountService loginCountService, LoginService loginService) {
        this.loginCountService = loginCountService;
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(UserLogin userLogin, Model model) {
        boolean isLoggedIn = loginService.isLoggedIn(userLogin);
        String message = isLoggedIn ? "You are now logged in" : "Login failed";
        if (isLoggedIn) {
            return "redirect:/main";
        }
        model.addAttribute("loginCount", loginCountService.getAttemptsCounter());
        model.addAttribute("message", message);
        return "login.html";
    }

}
