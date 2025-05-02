package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    ArrayList<ModelFruit> list;
    Context context;

    public MainAdapter(ArrayList<ModelFruit> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final ModelFruit fruit = list.get(position);
        holder.foodimage.setImageResource(fruit.image);
        holder.foodname.setText(fruit.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView foodimage;
        TextView foodname;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            foodimage = itemView.findViewById(R.id.im1);
            foodname = itemView.findViewById(R.id.tv1);
        }
    }
}
