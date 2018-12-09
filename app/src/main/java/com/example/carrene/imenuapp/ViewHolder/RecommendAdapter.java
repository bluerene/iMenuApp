package com.example.carrene.imenuapp.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carrene.imenuapp.FoodDetail;
import com.example.carrene.imenuapp.Interface.ItemClickListener;
import com.example.carrene.imenuapp.Model.Recommend;
import com.example.carrene.imenuapp.R;
import com.example.carrene.imenuapp.Recommendation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by carrene on 25/11/2018.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendViewHolder> {

    private Context context;
    private List<Recommend> recommendList;

    public RecommendAdapter(Context context,List<Recommend> recommendList)
    {
        this.context = context;
        this.recommendList = recommendList;
    }

    @Override
    public RecommendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.recommendation_item, parent, false);
        return new RecommendViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecommendViewHolder viewHolder, int position) {

        viewHolder.food_name.setText(recommendList.get(position).getFoodName());
        viewHolder.food_price.setText(String.format("RM %s", recommendList.get(position).getFoodPrice().toString()));
        Picasso.with(context).load(recommendList.get(position).getFoodImage())
                .into(viewHolder.food_image);


        Recommend local = recommendList.get(position);
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                //start new activity
                Intent foodDetail = new Intent(context, FoodDetail.class);
                foodDetail.putExtra("FoodId", recommendList.get(position).getFoodId()); //send FoodId to new activity
                context.startActivity(foodDetail);

            }
        });


    }



    @Override
    public int getItemCount() {
        return recommendList.size();
        //return 0;
    }
}
