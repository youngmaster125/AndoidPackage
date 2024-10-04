package com.example.contactmanager.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.contactmanager.dao.ContactDatabase;
import com.example.contactmanager.entities.Contact;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContactRepository {

    //The Availabe data source & room database

    private  final ContactDao contactDao;
    ExecutorService executorService;

    public ContactRepository(Application application) {


        ContactDatabase contactDatabase=ContactDatabase.getInstance(application);
        this.contactDao = contactDatabase.getContactDao();
        executorService=Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
    }

 public void  addContact(Contact contact){

     executorService.execute(new Runnable() {
         @Override
         public void run() {
             contactDao.insert(contact);
         }
     });

 }
 public  void deleteContacts(Contact contact){
     executorService.execute(new Runnable() {
         @Override
         public void run() {
             contactDao.delete( contact);
         }
     });
 }

 public LiveData<List<Contact>>getAllContacts(){
   return contactDao.getAllContacts();
 }
}
