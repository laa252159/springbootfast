package com.springbootfast.controllers;

import com.springbootfast.service.LoggedUserManagmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class MainController {

    private LoggedUserManagmentService loggedUserManagmentService;

    public MainController(LoggedUserManagmentService loggedUserManagmentService) {
        this.loggedUserManagmentService = loggedUserManagmentService;
    }

    @RequestMapping("/home/{color}")
    public String home(@PathVariable(required = false) String color,
                       @RequestParam(required = false, defaultValue = "Noname") String userName,
                       Model page) {
        page.addAttribute("color", color);
        page.addAttribute("username", userName);
        return "home.html";
    }

    @GetMapping("/main")
    public String main(Model model,
                       @RequestParam(required = false) String logout) {
        if (logout != null) {
            loggedUserManagmentService.setUserName(null);
        }
        if (StringUtils.isEmpty(loggedUserManagmentService.getUserName())) {
            return "redirect:/";
        }
        model.addAttribute("userName", loggedUserManagmentService.getUserName());
        return "main.html";
    }

}
