package com.example.carrene.imenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.carrene.imenuapp.Common.Common;
import com.example.carrene.imenuapp.Model.Recommend;
import com.example.carrene.imenuapp.ViewHolder.RecommendViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Recommendation extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodRec;

    String categoryId ="";

    FirebaseRecyclerAdapter<Recommend, RecommendViewHolder> adapter;


    //public Recommendation(String phone) {

    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        //recyclerView = (RecyclerView)findViewById(R.id.recycler_recommendation);
        //recyclerView.setHasFixedSize(true);
        //layoutManager = new GridLayoutManager(this,2);
        //recyclerView.setLayoutManager(layoutManager);

        TextView recList = (TextView)findViewById(R.id.rec_list);


        //Firebase
        database = FirebaseDatabase.getInstance();
        foodRec = database.getReference("Food");


            String userPhone = Common.currentUser.getPhone();
            String recommend = findRecommendation(userPhone);

            if (recommend != null)
            {
                recList.setText(recommend);
            }
            else
            {
                recList.setText("Not enough transaction");
            }



    }

    private String findRecommendation(String userPhone) {

        //open raw resource and connect to input stream variable
        InputStream input = getResources().openRawResource(R.raw.foodrecommendation);
        //bufferedReader
       /** BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = "";

        try {

            while ((line = br.readLine()) == userPhone )
            {

                String[] pieces = line.split("=");

                if (pieces[0].equalsIgnoreCase(userPhone.trim())){
                    return pieces[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line; **/

        //scanner
        Scanner scan = new Scanner(input);



        //String [] pieces;

        while (scan.hasNext())
        {
            String line = scan.nextLine(); //phoneNo + foodId
            String [] pieces = line.split("=");
            pieces = line.split("=");
            if (pieces[0].equalsIgnoreCase(userPhone.trim())){
                //String food = getFoodId(pieces);
                //loadRecommendation(pieces);
                return pieces[1];


            }
        }
        return null;




    }

    /** private void loadRecommendation(String [] pieces) {

        adapter = new FirebaseRecyclerAdapter<Recommend, RecommendViewHolder>(
                Recommendation.class,
                R.layout.recommendation_item,
                RecommendViewHolder.class,
                foodRec.orderByChild("menuID").equalTo(pieces)

        ) {
            @Override
            protected void populateViewHolder(RecommendViewHolder viewHolder, Recommend model, int position) {

                viewHolder.food_name.setText(model.getFoodName());
                viewHolder.food_price.setText(String.format("RM %s", model.getFoodPrice().toString()));
                Picasso.with(getBaseContext()).load(model.getFoodImage())
                        .into(viewHolder.food_image);

            }
        };
    }  **/

    //private String getFoodId(String[] pieces) {
    //}
}
