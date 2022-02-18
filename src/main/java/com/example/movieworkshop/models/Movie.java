package com.example.movieworkshop.models;

public class Movie implements Comparable<Movie> {

    private int year;
    private int length;
    private String title;
    private String genre;
    private int popularity;
    private String award;

    public Movie(int year, int length, String title, String genre, int popularity, String award) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.award = award;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getAward() {
        return award;
    }

    public int compareTo(Movie o){
        return this.popularity - o.getPopularity();
    }

    @Override
    public String toString() {
        return "Year: " + year + " - length: " + length + " - title: " + title + " - genre: " + genre + " - popularity: " + popularity + " - award: " + award + "\n";
    }
}
