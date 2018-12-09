package com.example.carrene.imenuapp.Model;

/**
 * Created by carrene on 7/5/2018.
 */

public class User {

    private String Name;
    private String Password;
    private String Phone;
    private String IsSatff;


    public User(){


    }

    public User(String name, String password){

        Name = name;
        Password = password;
        IsSatff = "false";

    }

    public String getIsSatff() {
        return IsSatff;
    }

    public void setIsSatff(String isSatff) {
        IsSatff = isSatff;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    }

