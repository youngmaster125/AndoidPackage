package com.example.furnitureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    // Variables
    private ArrayList<DataModel> dataSet;
    private Context mContext;


    // Constructor:
    public CustomAdapter2(ArrayList<DataModel> dataSet, Context mContext) {
        this.dataSet = dataSet;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview_secondary, parent, false);        // We Will Create the Item_cardview layout



        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }






    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        // Adding the data for textviews
        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());


        // Adding the data for imageView
        // Adding Glide Library

        Glide.with(mContext)
                .load(dataSet.get(position).getImage())
                .apply(RequestOptions.bitmapTransform
                        (new RoundedCorners(20)))
                .into(imageView);





    }







    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    // Let's Create a ViewHolder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;
        //ItemClickListener itemClickListener;  let's save it for later use

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.textViewVersion = itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = itemView.findViewById(R.id.imageView);
            //itemView.setOnClickListener((View.OnClickListener) this);
        }

        @Override
        public void onClick(View view) {

        }
    }


}
