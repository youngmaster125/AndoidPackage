package com.example.GestionEtudiant;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.GestionEtudiant.Fragment.ListPaiementFragment;
import com.example.GestionEtudiant.Fragment.PaiementFragment;

public class OtherActivity extends AppCompatActivity {


    Button paiement,listPaiement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.other);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        paiement=findViewById(R.id.paiement);
        listPaiement=findViewById(R.id.listPaiement);

        paiement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new PaiementFragment());
            }
        });

listPaiement.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        loadFragment(new ListPaiementFragment());
    }
});
    }

    public void loadFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout,fragment);

        fragmentTransaction.commit();

    }
}