package com.example.mvvmpatternbinding.ui;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvmpatternbinding.R;
import com.example.mvvmpatternbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // 6- Connecting MainActivity with ViewModel and Listening to LIVE Data
    AppViewModel appViewModel;


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

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // instead of using deprecated methods
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        // 7- View binding with Textview will do the job of observing
        binding.setViewModel(appViewModel);

       binding.setLifecycleOwner(this);


    }

    //     MVC Pattern
    // View: TextView & Button (Main Activity)
    // Model: MyModel class
    // Controller: MainActivity


    //      MVP Pattern
    // View : Activity with Textview & Button
    // Model: My Model
    // Presenter: AppPresenter


    // MVVM
    // 1- Implementing the dependency of ViewModel
    // 2- Creating ViewModel Class

    //Amazing Guys !! We have implemented MVVM correctly
}