package com.example.croffleproject.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.croffleproject.R;

import java.util.ArrayList;

public class TimerAdapter extends RecyclerView.Adapter<TimerAdapter.ViewHolder> {
    ArrayList<String> arrayList;
    ItemClickListener itemClickListener;
    int selectedPosition = -1;
    // Create constructor
    public TimerAdapter(ArrayList<String> arrayList,ItemClickListener itemClickListener){
        this.arrayList = arrayList;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.timeritem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.radioButton.setText(arrayList.get(position));

        holder.radioButton.setChecked(position == selectedPosition);

        holder.radioButton.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b){
                selectedPosition = holder.getAdapterPosition();

                itemClickListener.onClick(holder.radioButton.getText().toString());
            }
        });
    }

    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //init
        RadioButton radioButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            radioButton = itemView.findViewById(R.id.select_timer);
        }
    }
}
