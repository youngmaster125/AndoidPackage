package com.example.contactmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.contactmanager.AddNewContactActivity;

public class MainActivityClickHandler {

    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public  void onFABClicked(View view){
        Intent i=new Intent(view.getContext(), AddNewContactActivity.class);
        context.startActivity(i);
    }
}
