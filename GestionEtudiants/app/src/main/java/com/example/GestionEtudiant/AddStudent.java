package com.example.GestionEtudiant;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class AddStudent extends AppCompatActivity {
    Spinner classe;
    String sexe;
    TextView prenom,nom,age;
    Button button;
    RadioGroup radioGroup;


    EtudiantTraitement etudiantTraitement ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //  Radio Group - Radio Buttons

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());





        etudiantTraitement = new EtudiantTraitement();
        prenom=findViewById(R.id.prenom1);
        nom=findViewById(R.id.nom1);
        age=findViewById(R.id.age1);
        classe=findViewById(R.id.spinner);
        button=findViewById(R.id.button2);
        String [] courses={"5e","6e","7e","8e","9e","NS1","NS2","NS3","NS4"};
        ArrayAdapter<String> adapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item ,
                courses
        );
        classe.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Etudiant etudiant=new Etudiant();
                int selectedId=radioGroup.getCheckedRadioButtonId();
              RadioButton  radioButton1=(RadioButton) findViewById(selectedId);
             System.out.println(radioButton1.getText());

               etudiant.setNom(nom.getText().toString());
                etudiant.setPrenom(prenom.getText().toString());
                etudiant.setAge(Integer.parseInt(age.getText().toString()));
                etudiant.setClasse(classe.getSelectedItem().toString());
                etudiant.setSexe(radioButton1.getText().toString());
                LocalDateTime localDateTime;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Date d=new Date();
                    etudiant.setDateInscription(LocalDateTime.of(LocalDateTime.now().getYear(),
                            LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(),
                            LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()));

                    System.out.println(etudiant.getDateInscription());
                }
                etudiantTraitement.enregistrer(etudiant);

               Intent i =new Intent(getApplicationContext(),MainActivity.class);

               startActivity(i);


            }
        });
    }
}