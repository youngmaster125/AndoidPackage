package com.example.GestionEtudiant.traitement;

import com.example.GestionEtudiant.entities.Etudiant;

import java.util.ArrayList;

public class EtudiantTraitement implements EtudiantInterface {
   static   ArrayList<Etudiant> etudiantsArrayList =new ArrayList<>();
  int nbre=0;
    public EtudiantTraitement() {
    }

    @Override
    public ArrayList<Etudiant> afficher() {
/*

        etudiantsArrayList.add(new Etudiant("2", "Laurie", "Chama", 17, "Rheto"));
        etudiantsArrayList.add(new Etudiant("3", "Dashley", "Louis", 15, "Second"));
        etudiantsArrayList.add(new Etudiant("4", "Guerson", "Augustin", 11, "7e"));
        etudiantsArrayList.add(new Etudiant("5", "Lauma", "Thibert", 18, "Philo"));


       etudiantsArrayList.add(new Etudiant("1", "Manley", "Paul", 19, "Philo"));*/
        return etudiantsArrayList;
    }

    @Override
    public void supprimer(int id) {
  Etudiant e=rechercher(id);
  etudiantsArrayList.remove(e);
    }

    @Override
    public void modifier(Etudiant e) {

        Etudiant e1=rechercher(e.getId());
        e1=e;

    }

    @Override
    public Etudiant rechercher(int id) {
        Etudiant etudiant = null;
        for (Etudiant e:etudiantsArrayList
             ) {
            if (e.getId() == id) {
                etudiant = e;
            }
        }
        return etudiant;

    }

    @Override
    public int nombreEtudiant() {
        return etudiantsArrayList.size();
    }

    @Override
    public int nombreEtudiantParClasse(String classe) {

        for (Etudiant e:etudiantsArrayList
        ) {
            if (e.getClasse().equalsIgnoreCase(classe)) {
            nbre++;
            }
        }

int nbre1=nbre;
        nbre=0;
        return nbre1;
    }

    public void enregistrer(Etudiant e){
        e.setId(etudiantsArrayList.size()+1);
        etudiantsArrayList.add(new Etudiant(e.getId(),e.getPrenom(),e.getNom(),e.getSexe(),
                e.getAge(),e.getClasse(),e.getDateInscription()));

    }






}
