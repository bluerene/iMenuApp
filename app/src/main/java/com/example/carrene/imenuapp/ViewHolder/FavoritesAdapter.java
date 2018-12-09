package com.example.carrene.imenuapp.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.carrene.imenuapp.Common.Common;
import com.example.carrene.imenuapp.Database.Database;
import com.example.carrene.imenuapp.FoodDetail;
import com.example.carrene.imenuapp.FoodList;
import com.example.carrene.imenuapp.Interface.ItemClickListener;
import com.example.carrene.imenuapp.Model.Favorites;
import com.example.carrene.imenuapp.Model.Food;
import com.example.carrene.imenuapp.Model.Order;
import com.example.carrene.imenuapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by carrene on 14/8/2018.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesViewHolder> {

    private Context context;
    private List<Favorites> favoritesList;

    public FavoritesAdapter(Context context, List<Favorites> favoritesList) {
        this.context = context;
        this.favoritesList = favoritesList;
    }

    @Override
    public FavoritesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.favorites_item,parent,false);
        return new FavoritesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder viewHolder, int position) {

        viewHolder.food_name.setText(favoritesList.get(position).getFoodName());
        viewHolder.food_price.setText(String.format("RM %s", favoritesList.get(position).getFoodPrice().toString()));
        Picasso.with(context).load(favoritesList.get(position).getFoodImage())
                .into(viewHolder.food_image);



        /**boolean isExists = new Database(context).checkFoodExists(favoritesList.get(position).getFoodId(), Common.currentUser.getPhone());

        if (!isExists) {
            new Database(context).addToCart(new Order(
                    Common.currentUser.getPhone(),
                    favoritesList.get(position).getFoodId(),
                    favoritesList.get(position).getFoodName(),
                    "1",
                    favoritesList.get(position).getFoodPrice(),
                    favoritesList.get(position).getFoodDescription(),
                    favoritesList.get(position).getFoodImage()

            ));
        }
        else
        {
            new Database(context).increaseCart(Common.currentUser.getPhone(), favoritesList.get(position).getFoodId());
        }
        Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show();
        **/


        final Favorites local = favoritesList.get(position);
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                //start new activity
                Intent foodDetail = new Intent (context, FoodDetail.class);
                foodDetail.putExtra("FoodId", favoritesList.get(position).getFoodId()); //send FoodId to new activity
                context.startActivity(foodDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }

    public void removeItem(int position)
    {
        favoritesList.remove(position);
        notifyItemRemoved(position);

    }

    public void restoreItem(Favorites item, int position)
    {
        favoritesList.add(position, item);
        notifyItemInserted(position);

    }

    public Favorites getItem(int position)
    {
        return favoritesList.get(position);
    }
}
