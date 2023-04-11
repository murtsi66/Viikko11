package com.example.viikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.txtName.setText(items.get(position).getName());
        holder.imageEdit.setImageResource(R.drawable.edit);
        holder.imageRemove.setImageResource(R.drawable.delete);
        holder.imageRemove.setOnClickListener(view -> {
            Storage.getInstance().getItems().remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());
        });

        holder.imageEdit.setOnClickListener(view -> {

            if(holder.editName.getVisibility() == View.VISIBLE){
                Item item = Storage.getInstance().getItems().get(holder.getAdapterPosition());
                item.setName(holder.editName.getText().toString());
                holder.editName.setVisibility(View.GONE);
                notifyDataSetChanged();
            } else {
                holder.editName.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}