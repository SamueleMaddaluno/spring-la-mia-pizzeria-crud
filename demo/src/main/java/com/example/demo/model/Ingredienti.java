package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Ingredienti {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    private String ingrediente;


    @NotNull
    public Ingredienti(){}

    @ManyToMany(mappedBy="ingredienti")
    private List<Pizza> pizze;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getIngrediente() {
        return ingrediente;
    }


    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }


    public List<Pizza> getPizze() {
        return pizze;
    }


    public void setPizze(List<Pizza> pizze) {
        this.pizze = pizze;
    }

    
    

}
