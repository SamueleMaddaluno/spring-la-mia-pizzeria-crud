package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pizze")
public class Pizza {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany()
    @JoinTable(
        name= "pizza_ingredienti",
        joinColumns=@JoinColumn(name="pizza_id"),
        inverseJoinColumns=@JoinColumn(name="ingrediente_id")
    )
    private List<Ingredienti> ingredienti;

    @OneToMany(mappedBy="pizza")
    private List<OffertaSpeciale> offerte;


    @NotNull
    @NotBlank(message="nome deve essere inserito")
    @Size(min=5, max=20, message="il nome deve essere tra 5 e 20 caratteri")
    private String nome;

    @NotNull
    @NotBlank(message="la descrizione non può essere vuota")
    private String descrizione;
    

    private String fotoUrl;

    @NotNull
    @Min(value=10,message="il prezzo deve essere di minimo 10 €")
    private double prezzo;

    public Pizza(String nome, String descrizione,String fotoUrl, double prezzo){
        this.nome=nome;
        this.descrizione=descrizione;
        this.fotoUrl=fotoUrl;
        this.prezzo=prezzo;
    }

    public Pizza(){

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


    public void setId(Integer id) {
        this.id = id;
    }

    public List<OffertaSpeciale> getOfferte() {
        return offerte;
    }

    public void setOfferte(List<OffertaSpeciale> offerte) {
        this.offerte = offerte;
    }

    public List<Ingredienti> getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(List<Ingredienti> ingredienti) {
        this.ingredienti = ingredienti;
    }

    
}
