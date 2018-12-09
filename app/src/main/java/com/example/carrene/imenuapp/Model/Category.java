package com.example.carrene.imenuapp.Model;

/**
 * Created by carrene on 13/5/2018.
 */

public class Category {

    private String Name;
    private String Image;

    public Category()
        {


        }

    public Category(String Name, String Image)
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
