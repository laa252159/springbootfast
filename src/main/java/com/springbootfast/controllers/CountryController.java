package com.springbootfast.controllers;

import com.springbootfast.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        return ResponseEntity
                .status(202)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(Country.of("France", 101));
    }

    @GetMapping("/countries")
    public List<Country> countries() {
        return List.of(Country.of("Russia", 999999999),
                Country.of("USA", 111111111));
    }

}
