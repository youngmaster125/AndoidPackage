package com.example.gestionetudiant;

public class Etudiant {
    private  Long id;
    private String prenom;
    private String nom;
    private  int age;
    private  int classe;
    public Etudiant() {
    }

    public Etudiant(Long id, String prenom, String nom, int age,int classe) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.classe=classe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }
}
