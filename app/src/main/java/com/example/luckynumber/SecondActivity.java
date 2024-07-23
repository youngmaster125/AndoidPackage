package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
  TextView welcometext,lucknumberText;
  Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcometext=findViewById(R.id.textView3);
        lucknumberText=findViewById(R.id.textView4);
        btn1=findViewById(R.id.btn1);
       int luck =getLuckyNumber();

       lucknumberText.setText(String.valueOf(luck));

        Intent i =getIntent();
        String userName=i.getStringExtra("name");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,luck);
            }
        });

    }

    public int getLuckyNumber(){
        Random nb=new Random();
        return nb.nextInt(1000);
    }

    public void shareData(String userName,int randomNumber){

     Intent i=new Intent(Intent.ACTION_SEND);
     i.setType("text/plain");
     i.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
     i.putExtra(Intent.EXTRA_TEXT,"His lucky number is :"+randomNumber);
     startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}