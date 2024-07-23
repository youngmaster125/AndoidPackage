package com.example.GestionEtudiant.traitement;

import com.example.GestionEtudiant.entities.Etudiant;
import com.example.GestionEtudiant.entities.Paiement;

import java.util.ArrayList;

public interface PaiementInterface {

    public ArrayList<Paiement> afficher();
    public void enregistrer(Paiement p);
    public void supprimer(int id);
    public void modifier(Etudiant e);
    public Paiement rechercher(int id);
    public int nombrePaiement();

    public int nombrePaiementParClasse(String classe);
}
