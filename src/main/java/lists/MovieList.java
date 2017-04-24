package lists;

import models.Movie;
import services.CellGenerator;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movieList = null;

    public MovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public boolean removeMovie(int index) {
        if(index >= 0 && index < movieList.size()) {
            movieList.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public String movieListDetail() {
        String moviesDetail = generateOneRow(new Movie());
        for(int i = 0; i < movieList.size(); i++)
        {
            moviesDetail += i + ". " + generateOneRow(movieList.get(i));
        }
        return moviesDetail;
    }

    private String generateOneRow(Movie movie) {
        return CellGenerator.generateOneCell(movie.getName()) +
                CellGenerator.generateOneCell(movie.getYear()) +
                CellGenerator.generateOneCell(movie.getDirector()) +
                CellGenerator.generateOneCell(movie.getRating())+"\n";
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
