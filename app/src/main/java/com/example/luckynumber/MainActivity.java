package com.example.luckynumber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText editText;
 Button btn;
 TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        btn=findViewById(R.id.btn);
        textView=findViewById(R.id.textView);
        imageView=findViewById(R.id.img);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=editText.getText().toString();
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("name",userName);

                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();

        if(itemId==R.id.search_action){
            String userName=editText.getText().toString();
            Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
            intent.putExtra("name",userName);

            startActivity(intent);
            Toast.makeText(this,"Search item",Toast.LENGTH_SHORT).show();
        }else if(itemId==R.id.home_action){
            Toast.makeText(this,"Home item",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}