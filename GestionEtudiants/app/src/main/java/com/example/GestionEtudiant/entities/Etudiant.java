package com.example.GestionEtudiant.entities;

import java.time.LocalDateTime;

public class Etudiant  {
    private  int id;
    private String prenom;
    private String nom;
    private  int age;
    private  String classe;
    private String sexe;
    private LocalDateTime dateInscription;

    public Etudiant() {
    }

    public Etudiant(int id, String prenom, String nom,String sexe, int age,String classe,
                    LocalDateTime dateInscription    ) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.classe=classe;
        this.sexe=sexe;
        this.dateInscription=dateInscription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }
}
