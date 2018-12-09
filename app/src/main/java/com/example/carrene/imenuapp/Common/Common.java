package com.example.carrene.imenuapp.Common;

import com.example.carrene.imenuapp.Model.Request;
import com.example.carrene.imenuapp.Model.User;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by carrene on 13/5/2018.
 */

public class Common {

    public static User currentUser;

    public static Request currentRequest;

    public static String getDate(long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm",
                calendar)
                .toString());
        return date.toString();
    }

}


