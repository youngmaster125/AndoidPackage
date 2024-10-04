package com.example.contactmanager.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.contactmanager.entities.Contact;
import com.example.contactmanager.repository.ContactRepository;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

 private ContactRepository contactRepository;

 private LiveData<List<Contact>> allContacts;
    public MyViewModel(@NonNull Application application) {
        super(application);

        this.contactRepository=new ContactRepository(application);
    }

    public LiveData<List<Contact>> getAllContacts(){
        allContacts=contactRepository.getAllContacts();
        return allContacts;
    }

    public void addNewContact(Contact contact){
        contactRepository.addContact(contact);
    }

    public void  deleteContact(Contact contact){
        contactRepository.deleteContacts(contact);
    }
}
