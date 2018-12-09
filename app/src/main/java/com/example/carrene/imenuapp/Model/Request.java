package com.example.carrene.imenuapp.Model;

import java.util.List;

/**
 * Created by carrene on 13/6/2018.
 */

public class Request {

    private String status;
    private String phone;
    private String name;
    private String total;
    private List<Order> foods; //List of food order

    public Request(){

    }

    public Request(String phone, String name, String total, List<Order> foods ) {
        this.phone = phone;
        this.name = name;
        this.foods = foods;
        this.total = total;
        this.status = "0"; //Default: 0, 0: Ordered, 1: Prepared
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
