package com.example.GestionEtudiant.entities;

import java.time.LocalDateTime;

public class Classe {
   private int id;
   private Etudiant etudiant;
   private LocalDateTime annee;

   private String classe;

    public Classe() {
    }

    public Classe(int id,Etudiant etudiant, LocalDateTime annee, String classe) {
        this.etudiant=etudiant;
        this.id = id;
        this.annee = annee;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getAnnee() {
        return annee;
    }

    public void setAnnee(LocalDateTime annee) {
        this.annee = annee;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
