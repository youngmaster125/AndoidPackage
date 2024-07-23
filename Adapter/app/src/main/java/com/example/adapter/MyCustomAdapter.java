package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    private Context context;

    private String[] items;

    public MyCustomAdapter(Context context, String[] items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;
       if(convertView==null){
           // convertView: is a recycled View that you can reuse to
           //              improve the performance of your list.
           convertView= LayoutInflater.from(context)
                   .inflate(R.layout.my_list_item, viewGroup, false);


           holder = new ViewHolder();
           holder.textView = convertView.findViewById(R.id.textView);
           convertView.setTag(holder);
       }else{
           // Reusing the View (that's recycled)
           holder = (ViewHolder) convertView.getTag();
       }
        // Set the data to the view
        holder.textView.setText(items[i]);



        // Binding data to views within the convertView
        return convertView; // Displays the data at a position in the data set
    }
    static class  ViewHolder{
        // Holds references to the views within an item layout
        TextView textView;
    }
}
