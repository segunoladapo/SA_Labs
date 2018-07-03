package edu.mum.lab.sa.WebshopProductService.model;

public class Review {
    private String comments;
    private int rating;
    private String username;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
