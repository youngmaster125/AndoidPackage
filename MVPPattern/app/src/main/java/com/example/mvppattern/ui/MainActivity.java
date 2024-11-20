package com.example.mvppattern.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mvppattern.R;

public class MainActivity extends AppCompatActivity implements AppView {
    // 1- let's organize the packages
    // 2- implementing MVP Pattern

    Button btn;
    TextView textView;

    // Linking Activity with Presenter
    AppPresenter appPresenter;
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
        btn = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"salut",Toast.LENGTH_LONG).show();
                appPresenter.getAppName();
            }
        });

        // Instantiating The Presenter
       appPresenter = new AppPresenter(this);

    }

    @Override
    public void onGetAppName(String string) {
        textView.setText(string);
    }
}

//     MVC Pattern
// View: TextView & Button (Main Activity)
// Model: MyModel class
// Controller: MainActivity


//      MVP Pattern
// View : Activity with Textview & Button
// Model: My Model
// Presenter: AppPresenter