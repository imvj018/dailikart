package com.example.dailikart;


public class CourseModel {
    private final String id;
    private final String itemcode;
    private final String url;
    private final String brand;
    private final String desc;
    private final String price;
    private final String mrp;
    private final String rating;
    private final String reviews;

    public CourseModel(String id, String itemcode, String url, String brand, String desc, String price, String mrp, String rating, String reviews) {
        this.id = id;
        this.itemcode = itemcode;
        this.url = url;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
        this.mrp = mrp;
        this.rating = rating;
        this.reviews = reviews;
    }

    public String getId() {
        return id;
    }

    public String getItemcode() {
        return itemcode;
    }

    public String getUrl() {
        return url;
    }

    public String getBrand() {
        return brand;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getMrp() {
        return mrp;
    }

    public String getRating() {
        return rating;
    }

    public String getReviews() {
        return reviews;
    }
}

