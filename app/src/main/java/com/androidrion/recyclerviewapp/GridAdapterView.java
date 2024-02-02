package com.androidrion.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GridAdapterView extends RecyclerView.Adapter<GridAdapterView.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private final ArrayList<ItemModel> dataItem;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;

        ViewHolder(View v, RecyclerViewInterface recyclerViewInterface) {

            super(v);

            textHead = v.findViewById(R.id.headlineGrid);
            textSubhead = v.findViewById(R.id.sublineGrid);
            imageIcon = v.findViewById(R.id.imageGrid);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.OnItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    GridAdapterView(ArrayList<ItemModel> data, RecyclerViewInterface recyclerViewInterface) {
        this.dataItem = data;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public GridAdapterView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.grid_item, parent, false), recyclerViewInterface);
        return viewHolder;

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
//        //myonClickListener
//        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getNamabrg());
        textSubhead.setText("Harga: Rp" + dataItem.get(position).getHrgbrg());
        imageIcon.setImageResource(dataItem.get(position).getGambarbrg());
    }

    @Override
    public int getItemCount() {

        return dataItem.size();
    }
}