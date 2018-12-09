package com.example.carrene.imenuapp.Model;

/**
 * Created by carrene on 16/5/2018.
 */

public class Food {

    private String Name, Image, Description, Price, Calorie, MenuID, Discount;

    public Food() {
    }

    public Food(String name, String image, String description, String price, String calorie, String menuID, String discount) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Calorie = calorie;
        MenuID = menuID;
        Discount = discount;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCalorie() {
        return Calorie;
    }

    public void setCalorie(String calorie) {
        Calorie = calorie;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getDiscount() { return Discount; }

    public void setDiscount(String discount) { Discount = discount; }
}
