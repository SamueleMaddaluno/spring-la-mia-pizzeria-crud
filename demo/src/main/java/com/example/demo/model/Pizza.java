package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizze")
public class Pizza {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descrizione;

    private String fotoUrl;

    private double prezzo;

    public Pizza(String nome, String descizione,String fotoUrl, double prezzo){
        this.nome=nome;
        this.descrizione=descrizione;
        this.fotoUrl=fotoUrl;
        this.prezzo=prezzo;
    }

   


    public String  getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }




    public Integer getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }

    
}
