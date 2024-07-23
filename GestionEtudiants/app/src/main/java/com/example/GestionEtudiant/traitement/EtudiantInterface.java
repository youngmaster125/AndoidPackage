package com.example.GestionEtudiant.traitement;

import com.example.GestionEtudiant.entities.Etudiant;

import java.util.ArrayList;

public interface EtudiantInterface< e> {

    public ArrayList<Etudiant>afficher();
    public void enregistrer(Etudiant e);
    public void supprimer(int id);
    public void modifier(Etudiant e);
    public Etudiant rechercher(int id);
    public int nombreEtudiant();

    public int nombreEtudiantParClasse(String classe);
}
