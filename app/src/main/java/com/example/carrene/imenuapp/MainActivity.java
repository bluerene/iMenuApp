package com.example.carrene.imenuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carrene.imenuapp.Common.Common;
import com.example.carrene.imenuapp.Constant.Constant;
import com.example.carrene.imenuapp.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnSignUp, btnMenu;
    public AppPreferences appPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appPreference = new AppPreferences(this);

        btnMenu = (Button)findViewById(R.id.btnMenu);
        btnSignUp = (Button)findViewById(R.id.btnSignUp);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //Initialize Firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent home = new Intent(MainActivity.this, Home.class);
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        user.setPhone("9876543210");
                        Common.currentUser = user;
                        startActivity(home);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //Common.currentUser.setPhone("9876543210");
                //Here save user info to preferences
                //appPreference.setUserPhoneId(Constant.DEFAULT_PHONE_ID);
                //appPreference.setUserPassword(Constant.DEFAULT_PASSWORD);
                //startActivity(home);


            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(signUp);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent signIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(signIn);
            }
        });
    }
}
