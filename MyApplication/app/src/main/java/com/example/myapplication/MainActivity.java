package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this,
                "create :",Toast.LENGTH_LONG).show();
        Button btn1=findViewById(R.id.btn);
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        goToSecondActivity();
    }
});
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,
                "start:",Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,
                "resume :",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,
                "pause:",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,
                "stop :",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,
                "Destroy:",Toast.LENGTH_LONG).show();

    }
    public void goToSecondActivity(){
        Intent intent=new Intent(this,SecondActivity.class);
   startActivity(intent);
    }
}