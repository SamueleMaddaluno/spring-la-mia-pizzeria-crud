package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Pizza;
import com.example.demo.repository.PizzaRepository;

import jakarta.validation.Valid;







@Controller
@RequestMapping("/pizza")
public class PizzaController{

    @Autowired
    private PizzaRepository repository;

    @GetMapping 
    public String index(Model model, @RequestParam(name="keyword",required=false) String keyword){
        List<Pizza> result = null;
        if(keyword==null||keyword.isBlank()){
            result=repository.findAll();  
        }else{
            result=repository.findByNomeContainingIgnoreCase(keyword);
        }
        model.addAttribute("pizze", result);  
        return "index";

    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> optionalPizza = repository.findById(id);
        if(optionalPizza.isPresent()){
            model.addAttribute("pizza", optionalPizza.get());
            model.addAttribute("empty", false);
        }else{
            model.addAttribute("empty",true);
        }
        return "fragments/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());

        return "fragments/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "fragments/create";
        }else{
            repository.save(formPizza);
            redirectAttributes.addFlashAttribute("successMessage", "Pizza creata!");
             return "redirect:/pizza";
        }

     
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable ("id") Integer id, Model model) {
        Optional<Pizza> optPizza =repository.findById(id);
        Pizza pizza=optPizza.get();
        model.addAttribute("pizza", pizza);

        return  "fragments/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("pizza") Pizza pizzaForm, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "fragments/edit";
        }

        repository.save(pizzaForm);

        return "redirect:/pizza";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {

        repository.deleteById(id);
        
        
        return "redirect:/pizza";
    }
    
    
    
    
    
    
    


}
