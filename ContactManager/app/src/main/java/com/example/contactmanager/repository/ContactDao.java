package com.example.contactmanager.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.contactmanager.entities.Contact;

import java.util.List;
@Dao
public interface ContactDao {

  @Insert
    void insert(Contact contact);
    @Delete
    void delete(Contact contact);

    @Query("SELECT * FROM CONTACTS_TABLE ")
    LiveData<List<Contact> >getAllContacts();
}
