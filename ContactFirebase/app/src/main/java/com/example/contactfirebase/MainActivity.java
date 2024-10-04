package com.example.contactfirebase;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactfirebase.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> users;
    private RecyclerView recyclerView;
    private MyAdapter userAdapter;
    private ActivityMainBinding binding;


    // Firebase
    DatabaseReference databaseReference;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Users");



        // RecyclerView with Databinding
        recyclerView = binding.recyclerView;




        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // Fetch the Data from Firebase into RecyclerView
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                  //  Log.i("result",user.phoneNumber);
                   // Log.i("result",user.groupUser);
                    System.out.println("user :"+user.phoneNumber);
                    users.add(user);
                }
                // notify an adapter associated with a recyclerview
                // that the underlying dataset has changed
                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        users = new ArrayList<>();
        userAdapter = new MyAdapter(this, users);
        recyclerView.setAdapter(userAdapter);

    }
}
