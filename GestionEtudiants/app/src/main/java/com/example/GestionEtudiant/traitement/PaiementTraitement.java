package com.example.GestionEtudiant.traitement;

import com.example.GestionEtudiant.entities.Etudiant;
import com.example.GestionEtudiant.entities.Paiement;

import java.util.ArrayList;

public class PaiementTraitement implements  PaiementInterface {
    static   ArrayList<Paiement> paiements =new ArrayList<>();

    @Override
    public ArrayList<Paiement> afficher() {
        return null;
    }

    @Override
    public void enregistrer(Paiement p) {

    }

    @Override
    public void supprimer(int id) {

    }

    @Override
    public void modifier(Etudiant e) {

    }

    @Override
    public Paiement rechercher(int id) {
        return null;
    }

    @Override
    public int nombrePaiement() {
        return 0;
    }

    @Override
    public int nombrePaiementParClasse(String classe) {
        return 0;
    }
}
