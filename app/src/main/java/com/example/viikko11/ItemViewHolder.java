package com.example.viikko11;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    ImageView imageEdit, imageRemove;
    TextView txtName, editName;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        imageRemove = itemView.findViewById(R.id.imageDelete);
        imageEdit = itemView.findViewById(R.id.imageEdit);
        txtName = itemView.findViewById(R.id.txtItemName);
        editName = itemView.findViewById(R.id.editItem);
    }
}