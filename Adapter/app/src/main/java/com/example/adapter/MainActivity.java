package com.example.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        button=findViewById(R.id.button);
        String [] pays={"Haiti","USA","Canada","Japon","Kenia"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                pays
        );

        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),SecondActivity.class);

                startActivity(i);
            }
        });
    }
}