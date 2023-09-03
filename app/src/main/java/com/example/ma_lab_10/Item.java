package com.example.ma_lab_10;

public class Item {
    String name;
    String duration;
    private int id;

    public Item(String name, String duration, int id) {
        this.name = name;
        this.duration = duration;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
