package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

}
