package com.example.gestionetudiant;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomEtudiant extends ArrayAdapter<Etudiant> {

 private   ArrayList<Etudiant> listEtudiant ;
    Context context;

    public CustomEtudiant(Context context,  ArrayList<Etudiant> listEtudiant) {
        super(context, R.layout.etudiant_layout,listEtudiant);
        this.listEtudiant = listEtudiant;
        this.context = context;

    }

     public static class   MyViewHolder{
            TextView id;
            TextView prenom;
            TextView nom;
            TextView age;
            TextView classe;
     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }


}
