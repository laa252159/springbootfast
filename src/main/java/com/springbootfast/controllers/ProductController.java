package com.springbootfast.controllers;

import com.springbootfast.model.Product;
import com.springbootfast.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var producs = productService.findAll();
        model.addAttribute("products", producs);
        return "products.html";
    }

//    @PostMapping("/products")
//    public String addProduct(Model model,
//                             @RequestParam String name,
//                             @RequestParam double price) {
//        productService.addProduct(new Product(name, price));
//        model.addAttribute("products", productService.findAll());
//        return "products.html";
//    }

    @PostMapping("/products")
    public String addProduct(Model model,
                             Product product) {
        productService.addProduct(product);
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }


}
