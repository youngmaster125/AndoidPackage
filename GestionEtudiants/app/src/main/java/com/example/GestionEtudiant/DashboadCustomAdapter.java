package com.example.GestionEtudiant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GestionEtudiant.entities.Dash;

import java.util.List;

public class DashboadCustomAdapter extends RecyclerView.Adapter<DashboadCustomAdapter.MyViewHolder> {


List<Dash> dashList;
//HashMap<String,int> dash;


    public DashboadCustomAdapter(List<Dash> dashList) {
        this.dashList = dashList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).
                inflate(
                R.layout.card_item_layout, parent,false
        );

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Dash dash=dashList.get(position);
      holder.title.setText(dash.getTitle());
      holder.value.setText(String.valueOf(dash.getValue()));
    }

    @Override
    public int getItemCount() {
        return this.dashList.size();
    }


    public  static  class MyViewHolder extends RecyclerView.ViewHolder{

     TextView title, value;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.value = itemView.findViewById(R.id.value);
        }
    }


}
