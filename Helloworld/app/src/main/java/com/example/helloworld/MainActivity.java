package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mytextviwe=findViewById(R.id.mytextview);

        mytextviwe.setText("I am a software developer");

        EditText myedittext=findViewById(R.id.myedittext);

        String text=myedittext.getText().toString();
        Button btn=findViewById(R.id.mybtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Bonjour your name is :"+myedittext.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
     //  ImageView myimage=findViewById(R.id.myimg);
    // myimage.setImageResource(R.drawable.samy);



    }
}