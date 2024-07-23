package com.example.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 1- AdapterView: ListView
        listview = findViewById(R.id.list1);

        // 2- Data Source: String Array
        String[] countries = {"USA", "Germany", "Saudi Arabia","France"};


        // 3- Adapter: acts as a bridge between the
        //            'data source' and the 'AdapterView'
      MyCustomAdapter adapter = new MyCustomAdapter(this, countries);

        // Link Listview with the Adapter
        listview.setAdapter(adapter);
    }
}