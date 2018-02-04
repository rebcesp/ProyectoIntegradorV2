package com.example.rebcesp.proyectointegradorv2.ViewHolder;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rebcesp.proyectointegradorv2.Interface.ItemClickListener;
import com.example.rebcesp.proyectointegradorv2.R;

import org.w3c.dom.Text;

/**
 * Created by Rebcesp on 04/02/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView txtMenuName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;


    public MenuViewHolder(View itemView) {
        super(itemView);

        txtMenuName = (TextView)itemView.findViewById(R.id.menu_name);
        imageView = (ImageView)itemView.findViewById(R.id.menu_image);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

            itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
