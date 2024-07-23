package com.example.GestionEtudiant;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GestionEtudiant.entities.Dash;
import com.example.GestionEtudiant.traitement.EtudiantTraitement;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
    Spinner classe;
    int select;
    TextView nbetudiant;
Dash dash;
    //2- Data Source
    private List<Dash> dashList;

    // 3- Adapter
    private DashboadCustomAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EtudiantTraitement etudiantTraitement =new EtudiantTraitement();
       classe=findViewById(R.id.spinner1);
        String [] courses={"total","5e","6e","7e","8e","9e","NS1","NS2","NS3","NS4"};
        ArrayAdapter<String> adapterClasse =new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item ,
                courses
        );
        adapterClasse.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        classe.setAdapter(adapterClasse);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        nbetudiant=findViewById(R.id.nbetudiant);
        dashList=new ArrayList<>();


        classe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         //
             String pos=classe.getSelectedItem().toString();
             if (pos.equalsIgnoreCase("total"))
             {

                 dashList.clear();
                 nbetudiant.setText(R.string.nb_etudiant);
                 dashList.add(new Dash("Nombre Etudiant", etudiantTraitement.nombreEtudiant()));
                 // Toast.makeText(activity, formid, Toast.LENGTH_SHORT).show();
             }else{
                 dashList.clear();
                 nbetudiant.setText("Nombre etudiant pour la "+pos);
                 nbetudiant.setTextSize(20F);
                 dashList.add(new Dash("Nombre Etudiant",
                         etudiantTraitement.nombreEtudiantParClasse(pos)));
             }




             myAdapter = new DashboadCustomAdapter(dashList);
             recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
             recyclerView.setAdapter(myAdapter);

         }

         @Override
         public void onNothingSelected(AdapterView<?> adapterView) {
           //  dashList.add(new Dash("Nombre Etudiant", 1));
select=2;
         }
     });
   System.out.println(select);

    }

}