package com.springbootfast.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/{color}")
    public String home(@PathVariable(required = false) String color,
                       @RequestParam(required = false, defaultValue = "Noname") String userName,
                       Model page) {
        page.addAttribute("color", color);
        page.addAttribute("username", userName);
        return "home.html";
    }

}
