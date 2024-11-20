package com.example.medicalapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;


    // Array of images
    // Copying images from the xd files to drawables folder
    // Source code and XD Files are available to download from the resources
    // CHeck description below
    int[] covers = new int[]{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6
    };


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
        // 1- Toolbar:
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 4- Making the home button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator
                (R.drawable.menuu);




        // 5- Initializing RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        appList = new ArrayList<>();

        //Adapter
        adapter = new RecyclerViewAdaptery(this, appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);


        // Layout Manager
        recyclerView.setLayoutManager(manager);

        // Adapter
        recyclerView.setAdapter(adapter);

        // 6- Putting Data into recyclerView
        IntializeDataIntoRecyclerView();

    }
    private void IntializeDataIntoRecyclerView() {

        row a = new row(covers[0]);
        appList.add(a);

        a = new row(covers[1]);
        appList.add(a);

        a = new row(covers[2]);
        appList.add(a);

        a = new row(covers[3]);
        appList.add(a);

        a = new row(covers[4]);
        appList.add(a);

        a = new row(covers[5]);
        appList.add(a);

        adapter.notifyDataSetChanged();


    }

    // 2- Adding buttons to toolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);


    }

    // 3- Handling click on toolbar buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}