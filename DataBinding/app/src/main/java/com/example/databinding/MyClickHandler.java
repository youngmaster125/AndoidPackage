package com.example.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickHandler {

    Context context;

    public MyClickHandler(Context context) {
        this.context = context;
    }

    public void onButton1Clicked(View view){
        Toast.makeText(context,"Button is being Click",Toast.LENGTH_LONG).show();
    }
}
