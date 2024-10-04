package com.example.contactmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactmanager.databinding.ActivityAddNewContactBinding;
import com.example.contactmanager.databinding.ActivityMainBinding;
import com.example.contactmanager.entities.AddNewContactHandler;
import com.example.contactmanager.entities.Contact;
import com.example.contactmanager.viewModel.MyViewModel;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding contactBinding;
    private AddNewContactHandler contactHandler;

    private Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contact=new Contact();


        contactBinding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_contact);

        MyViewModel myViewModel=new ViewModelProvider(this).
                get(MyViewModel.class);
        contactHandler=new AddNewContactHandler(contact,this
        ,myViewModel);

       contactBinding.setContact(contact);
       contactBinding.setClickHander(contactHandler);
    }


}