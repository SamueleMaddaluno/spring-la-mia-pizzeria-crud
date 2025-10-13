package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ingredienti;


public interface IngredientiRepository extends JpaRepository<Ingredienti, Integer>{

    public Ingredienti findByIngrediente(String ingrediente);

}
