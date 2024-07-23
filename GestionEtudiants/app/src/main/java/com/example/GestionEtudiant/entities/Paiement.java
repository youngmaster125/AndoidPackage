package com.example.GestionEtudiant.entities;

import java.time.LocalDateTime;

public class Paiement {
    private int paiement;
    private Etudiant etudiant;
    private double montantAPayer;
    private double balance;
    private LocalDateTime datePayement ;
    private String session;

    public Paiement() {
    }

    public Paiement(int paiement, Etudiant etudiant, double montantAPayer, double balance, LocalDateTime datePayement, String session) {
        this.paiement = paiement;
        this.etudiant = etudiant;
        this.montantAPayer = montantAPayer;
        this.balance = balance;
        this.datePayement = datePayement;
        this.session = session;
    }

    public int getPaiement() {
        return paiement;
    }

    public void setPaiement(int paiement) {
        this.paiement = paiement;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public double getMontantAPayer() {
        return montantAPayer;
    }

    public void setMontantAPayer(double montantAPayer) {
        this.montantAPayer = montantAPayer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(LocalDateTime datePayement) {
        this.datePayement = datePayement;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }


}
