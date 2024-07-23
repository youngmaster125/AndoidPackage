package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button slt=findViewById(R.id.salut);

        slt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           goToAWebPage();
            }
        });

    }
    public void goToAWebPage(){
        Uri webPage=Uri.parse("https://www.google.com");
        Intent intent =new Intent(Intent.ACTION_VIEW,webPage);
        startActivity(intent);
    }
}