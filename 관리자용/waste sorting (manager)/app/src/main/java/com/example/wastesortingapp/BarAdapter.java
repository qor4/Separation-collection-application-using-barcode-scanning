package com.example.wastesortingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.mission22.R;

import java.util.ArrayList;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.ViewHolder>
                            implements OnBarItemClickListener {
    ArrayList<BarInfo> items = new ArrayList<BarInfo>();

    OnBarItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.bar_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        BarInfo item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(BarInfo item) {
        items.add(item);
    }

    public void setItems(ArrayList<BarInfo> items) {
        this.items = items;
    }

    public BarInfo getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, BarInfo item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnBarItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;
        ImageView imageView;

        public ViewHolder(View itemView, final OnBarItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(BarInfo item) {
            textView.setText(item.getNum());
            textView2.setText(item.getTitle());
            textView3.setText(item.getContents());
        }

    }

}
