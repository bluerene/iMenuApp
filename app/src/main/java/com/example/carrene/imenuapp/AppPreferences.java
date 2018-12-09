package com.example.carrene.imenuapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by carrene on 5/10/2018.
 */

public class AppPreferences {

    // Class variables
    private Context context;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    public static final String PREF_NAME = "iMenuApp";
    private int PRIVATE_MODE = 0;
    private static final boolean USER_LOGGED_IN = false;

    // Define your preferences key
    private static final String USER_PHONE = "9876543210";
    private static final String USER_PASSWORD = "12345";

    public AppPreferences(Context context)
    {
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        if (sharedPreferences != null)
        {
            editor = sharedPreferences.edit();
        }
    }

    //Store user PhoneId


    public void setUserPhoneId(String userId){
        String TAG = "AppPref:setUserId";
        try
        {
            editor.putString(USER_PHONE, userId);
            editor.commit();
        } catch (Exception e) {
            Log.e(TAG, String.valueOf(e));
        }
    }

    // Get userPhoneId
    public String getUserPhoneId(){
        return sharedPreferences.getString(USER_PHONE,"default_phone");
    }

    //Store userPassword
    public void setUserPassword(String userPassword){
        String TAG = "AppPref:setUserPassword";
        try
        {
            editor.putString(USER_PASSWORD, userPassword);
            editor.commit();
        } catch (Exception e) {
            Log.e(TAG, String.valueOf(e));
        }
    }

    // Get userPassword
    public String getUserPassword(){
        return sharedPreferences.getString(USER_PASSWORD,"default_password");
    }

    public static void setUserLoggedIn(boolean value) {
        String TAG = "AppPref:setUserLoggedIn";
        try{
            editor.putBoolean(String.valueOf(USER_LOGGED_IN), value);
            editor.commit();
        } catch (Exception e) {
            Log.e(TAG, String.valueOf(e));
        }
    }

    public static boolean getUserLoggedIn() {
        return sharedPreferences.getBoolean(String.valueOf(USER_LOGGED_IN), false);
    }


}
