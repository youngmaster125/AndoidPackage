package com.example.GestionEtudiant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.GestionEtudiant.entities.Etudiant;
import com.example.GestionEtudiant.traitement.EtudiantTraitement;

public class EditStudent extends AppCompatActivity implements View.OnClickListener {
    Spinner classe;
    TextView prenom,nom,age;
Etudiant etudiant;
    EtudiantTraitement etudiantTraitement;






    Button button,edit,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etudiantTraitement = new EtudiantTraitement();

        prenom=findViewById(R.id.prenom2);

        nom=findViewById(R.id.nom2);
        age=findViewById(R.id.age2);
        classe=findViewById(R.id.spinner);
        edit=findViewById(R.id.edit);
        delete=findViewById(R.id.delete);
        edit.setOnClickListener(this);
        delete.setOnClickListener(this);
        String [] courses={"5e","6e","7e","8e","9e","NS1","NS2","NS3","NS4"};
        ArrayAdapter<String> adapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item ,
                courses
        );

        classe.setAdapter(adapter);


        Intent i =getIntent();
      String id=i.getStringExtra("id");

      //  assert idStudent != null;

             etudiant=etudiantTraitement.rechercher(Integer.parseInt(id));

System.out.println("Nom :"+etudiant.getPrenom());
        prenom.setText(etudiant.getPrenom());

         nom.setText(etudiant.getNom());
         age.setText(String.valueOf(etudiant.getAge()));
        int pos=adapter.getPosition(etudiant.getClasse());

        classe.setSelection(pos);


/*
        delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }




         });
*/


    }

    @Override
    public void onClick(View view) {
        if(delete.getId()==view.getId()) {
            etudiantTraitement.supprimer(etudiant.getId());
            Toast.makeText(getApplicationContext(), "Etudiant supprime avec succes",
                    Toast.LENGTH_SHORT).show();
        }
        else if(edit.getId()==view.getId()) {
            etudiant.setPrenom(prenom.getText().toString());
            etudiant.setNom(nom.getText().toString());
            etudiant.setAge(Integer.parseInt(age.getText().toString()));
            etudiant.setClasse(classe.getSelectedItem().toString());
            etudiantTraitement.modifier(etudiant);

        }
        Intent i =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}