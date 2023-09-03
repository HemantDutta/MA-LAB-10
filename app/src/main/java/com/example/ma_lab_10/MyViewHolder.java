package com.example.ma_lab_10;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, subs, userID;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        nameView = itemView.findViewById(R.id.name);
        subs = itemView.findViewById(R.id.subscription);
        userID = itemView.findViewById(R.id.userID);
    }
}
