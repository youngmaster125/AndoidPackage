package com.example.contactmanager.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanager.databinding.ContactListItemBinding;

public  class ContactViewHolder extends RecyclerView.ViewHolder{




         ContactListItemBinding contactListItemBinding;

    public ContactViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
        super(contactListItemBinding.getRoot());
        this.contactListItemBinding = contactListItemBinding;
    }

    public ContactListItemBinding getContactListItemBinding() {
        return contactListItemBinding;
    }
}
