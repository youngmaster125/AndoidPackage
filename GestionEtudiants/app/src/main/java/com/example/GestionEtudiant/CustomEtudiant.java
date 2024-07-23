package com.example.GestionEtudiant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.GestionEtudiant.entities.Etudiant;

import java.util.ArrayList;

public class CustomEtudiant extends ArrayAdapter<Etudiant> {

 private   ArrayList<Etudiant> listEtudiant ;
    Context context;

    public CustomEtudiant(  ArrayList<Etudiant> listEtudiant,Context context) {
        super(context, R.layout.list_item_etudiant,listEtudiant);
        this.listEtudiant = listEtudiant;
        this.context = context;

    }

     public static class   MyViewHolder{
            TextView id;
            TextView prenom;
            TextView nom;
           TextView age;
           TextView classe;
           TextView sexe;
           TextView dateInscription;
     }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1- Get the planet object for the current position
        Etudiant etudiant=getItem(position);

        // 2- Inflate Layout:
        MyViewHolder myViewHolder;
        final View result;


        if(convertView==null){
               myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView=inflater.inflate(
             R.layout.list_item_etudiant,
             parent,false
           );
           // findind view
            myViewHolder.id=(TextView) convertView.findViewById(R.id.id);
            myViewHolder.prenom=(TextView) convertView.findViewById(R.id.prenom);
             myViewHolder.nom=(TextView) convertView.findViewById(R.id.nom);
            myViewHolder.age=(TextView) convertView.findViewById(R.id.age);
            myViewHolder.classe=(TextView) convertView.findViewById(R.id.classe);
            myViewHolder.sexe=(TextView) convertView.findViewById(R.id.sexe);
            myViewHolder.dateInscription=(TextView) convertView.findViewById(R.id.dateInscription);


            result = convertView;

            convertView.setTag(myViewHolder);
        }else{
            // the view is recycled
            myViewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        // Getting the data from model class (Planet)
        myViewHolder.id.setText(String.valueOf(etudiant.getId()));
        myViewHolder.prenom.setText(etudiant.getPrenom());
       myViewHolder.nom.setText(etudiant.getNom());
       myViewHolder.age.setText(String.valueOf(etudiant.getAge()));
       myViewHolder.classe.setText(etudiant.getClasse());
        myViewHolder.sexe.setText(String.valueOf(etudiant.getSexe()));
        myViewHolder.dateInscription.setText(etudiant.getDateInscription().toString());
        return result;


     //   return super.getView(position, convertView, parent);

    }


}
