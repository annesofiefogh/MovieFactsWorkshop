package com.example.movieworkshop.repositories;

import com.example.movieworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieHandler {

    public ArrayList<Movie> addFileDataToList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        File movieFile = new File("data/imdb-data.csv");

        try {
            Scanner sc = new Scanner(movieFile);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] movieData = line.split(";");
                int year = Integer.parseInt(movieData[0]);
                int length = Integer.parseInt(movieData[1]);
                String title = movieData[2];
                String genre = movieData[3];
                int popularity = Integer.parseInt(movieData[4]);
                String award = movieData[5];
                Movie movie = new Movie(year, length, title, genre, popularity, award);
                movieList.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return movieList;
    }
}
