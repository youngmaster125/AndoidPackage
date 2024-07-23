package com.example.GestionEtudiant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
//import android.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.GestionEtudiant.entities.Etudiant;
import com.example.GestionEtudiant.traitement.EtudiantTraitement;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Etudiant> etudiantsArrayList;
    Toolbar myToolbar;
    ImageView imageView;

    private static CustomEtudiant adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setSupportActionBar(new androidx.appcompat.widget.Toolbar(this));
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Gestion Etudiant");
        toolbar.inflateMenu(R.menu.my_menu);
        listView=findViewById(R.id.listview);
        etudiantsArrayList=new ArrayList<>();


        EtudiantTraitement etudiantTraitement = new EtudiantTraitement();



        adapter=new CustomEtudiant(etudiantTraitement.afficher(),getApplicationContext());

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //  String nom=adapterView.findViewById(i).toString();

               Intent in=new Intent(MainActivity.this,EditStudent.class);
              String id=String.valueOf(adapter.getItem(i).getId());
               in.putExtra("id",id);

    //  System.out.println(adapter.getItem(i).getId());
                  startActivity(in);

            }




        });

    }



   @SuppressLint("RestrictedApi")
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder menuBuilder=(MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }
        return  true ;//super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.save_action){
            Intent intent=new Intent(getApplicationContext(),AddStudent.class);
            startActivity(intent);
        } else if (itemId==R.id.dash_board) {
            Intent intent=new Intent(getApplicationContext(),Dashboard.class);
            startActivity(intent);
        }
        else if (itemId==R.id.Other_action) {
            Intent intent=new Intent(getApplicationContext(),OtherActivity.class);
            startActivity(intent);
        }
        return true;
    }



}