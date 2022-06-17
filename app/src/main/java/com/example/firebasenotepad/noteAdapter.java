package com.example.firebasenotepad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class noteAdapter extends RecyclerView.Adapter<noteAdapter.noteViewholder>{

    Context context;
    ArrayList<notemodel>notemodelArrayList;

    public noteAdapter(Context context, ArrayList<notemodel> notemodelArrayList) {
        this.context = context;
        this.notemodelArrayList = notemodelArrayList;
    }

    @NonNull
    @Override
    public noteViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.note_layout,parent,false);
        return new noteViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noteViewholder holder, int position) {
        notemodel notes=notemodelArrayList.get(position);
        holder.titles.setText(notes.getTitle());
        holder.description.setText(notes.getDescription());


    }

    @Override
    public int getItemCount() {
        return notemodelArrayList.size();
    }

    public class noteViewholder extends RecyclerView.ViewHolder {
        TextView titles, description;

        public noteViewholder(@NonNull View itemView) {
            super(itemView);

            titles = itemView.findViewById(R.id.titles);
            description = itemView.findViewById(R.id.description);
        }
    }
}
