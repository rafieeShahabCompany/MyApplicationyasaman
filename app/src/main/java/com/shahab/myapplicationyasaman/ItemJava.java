package com.shahab.myapplicationyasaman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemJava extends RecyclerView.Adapter<ItemJava.ItemJavaHolder> {

    List<String> X;
    public ItemJava(List<String>list){
        X = list;
    }




    @NonNull
    @Override
    public ItemJavaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Y = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        ItemJavaHolder holder = new ItemJavaHolder(Y);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemJavaHolder holder, int position) {
        String Movie = X.get(position);
        holder.txtMovie.setText(Movie);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemJavaHolder extends RecyclerView.ViewHolder{
        TextView txtMovie;

        public ItemJavaHolder(@NonNull View itemView) {
            super(itemView);
            txtMovie = itemView.findViewById(R.id.txtMovie);
        }
    }
}
