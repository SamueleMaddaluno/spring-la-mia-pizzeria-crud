package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Ingredienti;
import com.example.demo.model.Pizza;
import com.example.demo.repository.IngredientiRepository;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

    @Autowired
    private IngredientiRepository repository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("list",repository.findAll());
        model.addAttribute("ingredientiObj",new Ingredienti());
        return "ingredienti/index";
    }

    @PostMapping("/create")
    public String crea(@Valid @ModelAttribute("ingredientiObj") Ingredienti ingredienti,
                        BindingResult bindingResult, Model model) {
        Ingredienti ingre = repository.findByIngrediente(ingredienti.getIngrediente());

        if(ingre == null){
            // se l'ingrediente non è gia presente

        }
        else{
            // se un ingrediente è già presente
            bindingResult.addError(new FieldError("ingredientiOjj", "ingrediente", "ingrediente già presente"));
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("list",repository.findAll());
            model.addAttribute("ingredientiObj",new Ingredienti());
            return "ingredienti/index";
        }
        repository.save(ingredienti);
        return "redirect:/ingredienti";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        Ingredienti ingredienti = repository.findById(id).get();
        for(Pizza pizza : ingredienti.getPizze()){
            pizza.getIngredienti().remove(ingredienti);
        }
        repository.deleteById(id);
        return "redirect:/ingredienti";
    }
    
    


}
