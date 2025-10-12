package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.OffertaSpeciale;
import com.example.demo.repository.OffertaSpecialeRepository;

import jakarta.validation.Valid;






@Controller
@RequestMapping("/offerte")
public class OffertaController {

    @Autowired
    private OffertaSpecialeRepository repository;
  
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("offertaSpeciale") OffertaSpeciale offertaSpeciale,
    BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            return "offerte/edit";
        }
        
        repository.save(offertaSpeciale);
        return "redirect:/pizza/show/"+ offertaSpeciale.getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        OffertaSpeciale offertaSpeciale =repository.findById(id).get();
        model.addAttribute("editMode", true);
        model.addAttribute("offertaSpeciale", offertaSpeciale);

        return "/offerte/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("offertaSpeciale") OffertaSpeciale offertaSpeciale, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("editMode",true);
            return "/offerte/edit";
        }
        repository.save(offertaSpeciale);
        return "redirect:/pizza/show/"+ offertaSpeciale.getPizza().getId();
    }
    
     @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        OffertaSpeciale offertaSpeciale=repository.findById(id).get();
        repository.deleteById(id);
        
        return "redirect:/pizza/show/"+ offertaSpeciale.getPizza().getId();
    }
    
    
}
