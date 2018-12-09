package com.example.carrene.imenuapp.ViewHolder;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carrene.imenuapp.Common.Common;
import com.example.carrene.imenuapp.Interface.ItemClickListener;
import com.example.carrene.imenuapp.Model.Order;
import com.example.carrene.imenuapp.OrderDetail;
import com.example.carrene.imenuapp.R;
import com.stepstone.apprating.AppRatingDialog;

import java.util.Arrays;
import java.util.List;

/**
 * Created by carrene on 28/6/2018.
 */


class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView name, quantity, price, discount;
    public FloatingActionButton btnRating2;

    public MyViewHolder(View itemView) {
        super(itemView);

        name = (TextView)itemView.findViewById(R.id.product_name);
        quantity = (TextView)itemView.findViewById(R.id.product_quantity);
        price = (TextView)itemView.findViewById(R.id.product_price);
        discount = (TextView)itemView.findViewById(R.id.product_discount);
        //btnRating2 = (FloatingActionButton)itemView.findViewById(R.id.btn_rating2);
    }
}

public class OrderDetailAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<Order> myOrders;
    private OnRatingButtonClickListener mOnRatingClickListener;


    public OrderDetailAdapter(List<Order> myOrders, OnRatingButtonClickListener listener) {
        this.myOrders = myOrders;
        this.mOnRatingClickListener = listener;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_detail_layout,parent,false);
        return new MyViewHolder(itemView);
    }




     public interface OnRatingButtonClickListener
    {
        void onRatingClick(String productId);  //String productId
    }




    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Order order = myOrders.get(position);
        holder.name.setText(String.format("Name: %s", order.getProductName()));
        holder.quantity.setText(String.format("Quantity: %s", order.getQuantity()));
        holder.price.setText(String.format("Price: %s", order.getPrice()));
        holder.discount.setText(String.format("Discount: %s", order.getDiscount()));

        /**
         * holder.btnRating2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //mOnRatingClickListener.onRatingClick(order.getProductId());

                mOnRatingClickListener.onRatingClick(order.getProductId());

            }
        });  **/



    }


    @Override
    public int getItemCount() {
        return myOrders.size();
    }


}
