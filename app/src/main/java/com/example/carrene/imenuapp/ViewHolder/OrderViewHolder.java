package com.example.carrene.imenuapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carrene.imenuapp.Interface.ItemClickListener;
import com.example.carrene.imenuapp.R;

import org.w3c.dom.Text;

/**
 * Created by carrene on 17/6/2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderTotal, txtOrderDate;
    //public ImageView img_order_count;

    private ItemClickListener itemClickListener;

    public OrderViewHolder(View itemView) {
        super(itemView);

        txtOrderId = (TextView)itemView.findViewById(R.id.order_id);
        txtOrderStatus = (TextView)itemView.findViewById(R.id.order_status);
        txtOrderPhone = (TextView)itemView.findViewById(R.id.order_phone);
        txtOrderTotal = (TextView)itemView.findViewById(R.id.order_total);
        txtOrderDate = (TextView)itemView.findViewById(R.id.order_date);


        //img_order_count = (ImageView)itemView.findViewById(R.id.img_order_count);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),true);
        return true;
    }
}



