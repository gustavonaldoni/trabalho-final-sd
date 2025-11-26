package com.mycompany.movieapp;

public class Movie {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String year;
    private double rating;

    public Movie(String id, String title, String description, String imageUrl, String year, double rating) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.year = year;
        this.rating = rating;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getYear() { return year; }
    public double getRating() { return rating; }
}
