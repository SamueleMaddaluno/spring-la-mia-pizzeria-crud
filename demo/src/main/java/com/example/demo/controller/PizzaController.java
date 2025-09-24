package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pizza;
import com.example.demo.repository.PizzaRepository;



@Controller
@RequestMapping("/pizza")
public class PizzaController{

    @Autowired
    private PizzaRepository repository;

    @GetMapping 
    public String index(Model model){
        List<Pizza> result = repository.findAll();
        model.addAttribute("pizze", result);
        return "index";

    }
    


}
