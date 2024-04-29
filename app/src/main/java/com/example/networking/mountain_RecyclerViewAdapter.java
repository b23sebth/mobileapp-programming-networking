package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mountain_RecyclerViewAdapter extends RecyclerView.Adapter<mountain_RecyclerViewAdapter.MyViewHolder>{

    Context context;
    ArrayList<mountain> mountains;

    public mountain_RecyclerViewAdapter(Context context, ArrayList<mountain>mountains){
        this.context = context;
        this.mountains = mountains;
    }
    @NonNull
    @Override
    public mountain_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_layout, parent, false);
        return new mountain_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mountain_RecyclerViewAdapter.MyViewHolder holder, int position) {
    holder.textview.setText(mountains.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textview = itemView.findViewById(R.id.title);
        }
    }
}
