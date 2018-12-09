package com.example.carrene.imenuapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carrene.imenuapp.Common.Common;
import com.example.carrene.imenuapp.Database.Database;
import com.example.carrene.imenuapp.Model.Food;
import com.example.carrene.imenuapp.Model.Rating;
import com.example.carrene.imenuapp.Model.Request;
import com.example.carrene.imenuapp.ViewHolder.OrderDetailAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stepstone.apprating.AppRatingDialog;
import com.stepstone.apprating.listener.RatingDialogListener;

import java.util.Arrays;

public class OrderDetail extends AppCompatActivity implements OrderDetailAdapter.OnRatingButtonClickListener {

    TextView order_id, order_phone, order_total;
    String order_id_value = "";
    RecyclerView lstFoods;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton btnRating2;


    String foodId = "";
    FirebaseDatabase database;
    DatabaseReference foods;
    DatabaseReference ratingTbl;


    Request currentRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Food");
        ratingTbl = database.getReference("Rating");

        //Initialize view
        order_id = (TextView)findViewById(R.id.order_id);
        order_phone = (TextView)findViewById(R.id.order_phone);
        order_total = (TextView)findViewById(R.id.order_total);

        lstFoods = (RecyclerView)findViewById(R.id.lstFoods);
        lstFoods.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstFoods.setLayoutManager(layoutManager);

        //btnRating2 = (FloatingActionButton)findViewById(R.id.btn_rating2);




        if(getIntent() != null) {
            order_id_value = getIntent().getStringExtra("OrderId");
            foodId = getIntent().getStringExtra("FoodId");

            //Set value
            order_id.setText(order_id_value);
            order_phone.setText(Common.currentRequest.getPhone());
            order_total.setText(Common.currentRequest.getTotal());

            OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getFoods(),this);
            //OrderDetailAdapter adapter = new OrderDetailAdapter(this);
            adapter.notifyDataSetChanged();
            lstFoods.setAdapter(adapter);



        }



    }


    /* private void getDetailOrder(final String order_id_value) {
        foods.child(order_id_value).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentRequest = dataSnapshot.getValue(Request.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    } */



    @Override
    public void onRatingClick(String productId) {
        btnRating2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    showRatingDialog();

            }
        });

    }

    private void showRatingDialog() {
        new AppRatingDialog.Builder()
                .setPositiveButtonText("Submit")
                .setNegativeButtonText("Cancel")
                .setNoteDescriptions(Arrays.asList("Very Bad","Bad","Quite OK","Very Good","Excellent"))
                .setDefaultRating(1)
                .setTitle("Rate this food")
                .setDescription("Kindly give your ratings and comment")
                .setTitleTextColor(R.color.transparentBlack)
                .setDescriptionTextColor(R.color.transparentBlack)
                .setHint("Please write your comment here...")
                .setHintTextColor(R.color.fbutton_color_midnight_blue)
                .setCommentTextColor(android.R.color.black)
                .setCommentBackgroundColor(android.R.color.white)
                .setWindowAnimation(R.style.RatingDialogFadeAnim)
                .create(OrderDetail.this)
                .show();

    }



}
