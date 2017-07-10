package com.example.kuba_10.artwallpapers.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Film {

    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("story")
    @Expose
    private String story;
    @SerializedName("movie")
    @Expose
    private String movie;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("duration")
    @Expose
    private String duration;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
