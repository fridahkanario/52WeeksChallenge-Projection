package com.example.a52weekchallenge;


// model class denoting the week container properties
public class WeeklyContainers {
    private String name;
    private int capacity;
    private int thumbnail;

    public WeeklyContainers() {
    }

    public WeeklyContainers(String name, int capacity, int thumbnail) {
        this.name = name;
        this.capacity = capacity;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int numOfSongs) {
        this.capacity = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
