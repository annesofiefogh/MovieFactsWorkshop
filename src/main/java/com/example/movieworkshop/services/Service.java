package com.example.movieworkshop.services;

import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.repositories.MovieHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Service {

    private ArrayList<Movie> movies;
    private Random rn = new Random();

    public Service() {
        MovieHandler movieHandler = new MovieHandler();
        movies = movieHandler.addFileDataToList();
    }

    public String getGreeting(){
        String welcomeMessage = "Welcome to the movie workshop - " +
                                "Here you can find a ton of information about the movies you like - " +
                                "Enjoy!";
        return welcomeMessage;
    }

    public String getFirstMovieTitle(){
        String firstTitle = movies.get(0).getTitle();
        return firstTitle;
    }

    public String getRandomMovieTitle(){
        String randomTitle = movies.get(rn.nextInt(movies.size()+1)).getTitle();
        return randomTitle;
    }

    public ArrayList<Movie> getTenMoviesPopularitySorted(){
        ArrayList<Movie> tenMovies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tenMovies.add(movies.get(rn.nextInt(movies.size())+1));
        }
        Collections.sort(tenMovies);
        return tenMovies;
    }

    public int getAwardWinningMovies(){
        int count = 0;
        for (Movie m : movies){
            if (m.getAward().equals("Yes")){
                count++;
            }
        }
        return count;
    }

    public ArrayList<Movie> getMoviesWithSpecificLetters(char x, int n){
        MovieHandler movieHandler = new MovieHandler();
        return movieHandler.specificLetterMovies(x,n);
    }

    //Helping-method to get a list of specific genres
    public ArrayList<Movie> movieGenres(String genre){
        ArrayList<Movie> genreList = new ArrayList<>();
        for (Movie m : movies) {
            if (m.getGenre().equals(genre)){
               genreList.add(m);
            }
        }
        return genreList;
    }

    //Helping-method to calculate the average length of the movies with a specific genre
    public double averageMovieLength(ArrayList<Movie> genreList){
        double sumOfLengths = 0;
        for (Movie m : genreList) {
            sumOfLengths += m.getLength();
        }
        double average = sumOfLengths / genreList.size();
        return average;
    }

    public String genreWithLongestMovie(String g1, String g2){
        String result = "";
        DecimalFormat df = new DecimalFormat("0.00");

        ArrayList<Movie> genreList1 = movieGenres(g1);
        ArrayList<Movie> genreList2 = movieGenres(g2);

        double longest1 = averageMovieLength(genreList1);
        double longest2 = averageMovieLength(genreList2);

        if (longest1 > longest2){
           result = "The genre " + g1 + " has the longest movie, with a length of " + df.format(longest1) + " min. compared to " + g2 + " with a length of " + df.format(longest2) + " min.";
        } else {
            result = "The genre " + g2 + " has the longest movie, with a length of " + df.format(longest2) + " min. compared to " + g1 + " with a length of " + df.format(longest1) + " min.";
        }
        return result;
    }
}

