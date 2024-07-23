package com.example.viewmodelandlivedata;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodelandlivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding mainBinding;
 MyViewModel viewModel;
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

/*        DiceRollViewModel model = new ViewModelProvider(this).get(DiceRollViewModel.class);
        model.getUiState().observe(this, uiState -> {
            // update UI
        });*/

        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);


        viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

    /*    mainBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increaseCounter();
                mainBinding.counter.setText(""+viewModel.getCounter());
            }
        });*/
        mainBinding.setMyCounter(viewModel);
         viewModel.getCounter().observe(this, new Observer<Integer>() {
             @Override
             public void onChanged(Integer counter) {
                 mainBinding.counter.setText(""+counter);
             }
         });
       // mainBinding.counter.setText(""+viewModel.getCounter().getValue());

    }
}