package com.example.fragmentapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        Toast.makeText(context,
                "OnAttach() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(),
                "OnCreate() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(),
                "OnResume() is Called", Toast.LENGTH_SHORT).show();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button firstBtn = view.findViewById(R.id.btn_frag1);
        TextView text = view.findViewById(R.id.text_frag1);

        firstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        "Welcome to the First Fragment",
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}