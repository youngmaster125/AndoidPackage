package com.example.normalrecyleview.singles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyleview.R;

import java.util.ArrayList;

public class SingleSelectionRV extends AppCompatActivity {
    // Widgets
    private RecyclerView recyclerView;
    private Button btn;

    // Variables
    private ArrayList<Employee> employees = new ArrayList<>();
    private SingleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_single_selection_rv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.singleRV);
        btn = findViewById(R.id.button_get_selected);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SingleAdapter(this,employees);
        recyclerView.setAdapter(adapter);

        CreateList();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected() != null){
                    ShowToast(adapter.getSelected().getName());
                }
                else
                    ShowToast("No Selection");
            }
        });





    }

    private void CreateList() {
        employees = new ArrayList<>();
        for (int i = 0 ; i <20 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee " + (i+1));
            employees.add(employee);
        }
        adapter.SetEmployees(employees);

    }

    private void ShowToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}


// Let's solve the error