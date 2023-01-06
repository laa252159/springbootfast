package com.springbootfast.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(@RequestParam(required = false, defaultValue = "green") String color,
                       @RequestParam(required = false, defaultValue = "Noname") String userName,
                       Model page) {
        page.addAttribute("color", color);
        page.addAttribute("username", userName);
        return "home.html";
    }

}
