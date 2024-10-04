package com.example.contactmanager.entities;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.contactmanager.MainActivity;
import com.example.contactmanager.viewModel.MyViewModel;

public class AddNewContactHandler {
    Contact contact;
    Context context;

    MyViewModel myViewModel;

    public AddNewContactHandler(Contact contact, Context context,MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel=myViewModel;
    }

    public void onSubmitClicked(View view){

        if(contact.getName()==null || contact.getEmail()==null){
            Toast.makeText(context,"Field cannot be empty",Toast.LENGTH_LONG).show();
        }else{

            Contact c=new Contact(
                    contact.getName(),contact.getEmail()
            );
            myViewModel.addNewContact(c);

            Intent i=new Intent(context, MainActivity.class);
            context.startActivity(i);
        }
    }
}
