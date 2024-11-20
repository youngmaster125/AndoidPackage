package com.example.normalrecyleview.multiviewtype;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyleview.R;

import java.util.ArrayList;

public class MultiTypeViewActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multi_type_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView =findViewById(R.id.multiple_view_rv);


        InsertDatatoRV();


    }

    private void InsertDatatoRV() {
        ArrayList<MultiEmployee> employees = new ArrayList<>();


        // Adding Data to it
        MultiEmployee employee1 = new MultiEmployee();

        // A phone item
        employee1.setName("Mohammad");
        employee1.setAddress("New York");
        employee1.setPhone("+012398234234");
        employees.add(employee1);


        // An email item
        MultiEmployee employee2 = new MultiEmployee();
        employee2.setName("Ali");
        employee2.setAddress("London");
        employee2.setEmail("ali@gmail.com");
        employees.add(employee2);

        MultiEmployee employee3 = new MultiEmployee();
        employee3.setName("Jack");
        employee3.setAddress("Philadelphia");
        employee3.setEmail("jack@gmail.com");
        employees.add(employee3);

        MultiEmployee employee4 = new MultiEmployee();
        employee4.setName("Ryan");
        employee4.setAddress("Canada");
        employee4.setPhone("+123423453456");
        employees.add(employee4);


        // set adapter
        MultipleTypeAdapter adapter = new MultipleTypeAdapter(this, employees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }


}