package com.example.movieworkshop.services;

import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.repositories.MovieHandler;

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
}
