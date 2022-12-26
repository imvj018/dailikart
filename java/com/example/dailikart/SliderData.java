package com.example.dailikart;

public class SliderData {
    private String id, url, type, date, time;

    public SliderData(String id, String url, String type, String date, String time) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
