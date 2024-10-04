package com.example.contactmanager.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.contactmanager.entities.Contact;
import com.example.contactmanager.repository.ContactDao;

@Database(entities = {Contact.class},version=1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDao getContactDao();

    //Singleton Pattern

    private static ContactDatabase dbInstance;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class ,
                    "contact_db"
            ).fallbackToDestructiveMigration().build();
        }
            return dbInstance;

    }
}