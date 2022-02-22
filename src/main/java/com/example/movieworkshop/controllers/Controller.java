package com.example.movieworkshop.controllers;

import com.example.movieworkshop.models.Movie;
import com.example.movieworkshop.services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    Service service = new Service();

    //3.1
    @GetMapping("/")
    public String greeting(){
        String welcomeMessage = service.getGreeting();
        return welcomeMessage;
    }

    //3.2
    @GetMapping("/getFirst")
    public String getFirst(){
        String firstTitle = service.getFirstMovieTitle();
        return firstTitle;
    }

    //3.3
    @GetMapping("/getRandom")
    public String getRandom(){
        String randomTitle = service.getRandomMovieTitle();
        return randomTitle;
    }

    //3.4
    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> getTenSortByPopularity(){
        ArrayList<Movie> sortedList = service.getTenMoviesPopularitySorted();
        return sortedList;
    }

    //3.5
    @GetMapping("/howManyWonAnAward")
    public int getHowManyWonAnAward(){
        int awardMovies = service.getAwardWinningMovies();
        return awardMovies;
    }

    //3.6
    @GetMapping("/advancedFilter")
    public ArrayList<Movie> moviesWithCertainAmountOfLetters(@RequestParam char findLetter, @RequestParam int amount){
        ArrayList<Movie> moviesWithSpecificLetters = service.getMoviesWithSpecificLetters(findLetter, amount);
        return moviesWithSpecificLetters;
    }

    //3.7
    @GetMapping("/advancedLongest")
    public String whichGenreWithLongestMovie(@RequestParam String genre1, @RequestParam String genre2){
        String longestMovie = service.genreWithLongestMovie(genre1, genre2);
        return longestMovie;
    }
}
