package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Second_activity extends AppCompatActivity {

    TimePicker timePicker;
    Button btn1;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        timePicker=findViewById(R.id.timePicker);
        datePicker=findViewById(R.id.datePicker);
  btn1=findViewById(R.id.btn1);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getApplicationContext()
                ,"Hour :"+hourOfDay+" minute :"+minute,Toast.LENGTH_LONG).show();
            }
          //  Toast toast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String day="Day :"+datePicker.getDayOfMonth();
              String month="Month :"+datePicker.getMonth();
              String year="Year :"+datePicker.getYear();
                Toast.makeText(getApplicationContext(), ""+day, Toast.LENGTH_LONG).show();
            }
        });
    }
}