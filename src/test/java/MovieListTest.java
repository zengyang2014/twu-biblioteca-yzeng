import lists.MovieList;
import models.Movie;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MovieListTest {
    private MovieList movieList = null;

    @Before
    public void setUp() {
        ArrayList<Movie> initMovieList = new ArrayList<>();
        initMovieList.add(new Movie("Tootsie", "1982", "Sydney Pollack", "9"));
        initMovieList.add(new Movie("The Godfather", "1972", "Francis Ford Coppola", "9"));

        movieList = new MovieList(initMovieList);
    }

    @Test
    public void shouldReturnMovieListDetail() throws Exception {
        String exceptPrint = "Name                                                                  Year                                                                  Director                                                              Rating                                                                \n" +
                "0. Tootsie                                                               1982                                                                  Sydney Pollack                                                        9                                                                     \n" +
                "1. The Godfather                                                         1972                                                                  Francis Ford Coppola                                                  9                                                                     \n";

        assertTrue(exceptPrint.equals(movieList.movieListDetail()));
    }

    @Test
    public void shouldRemoveMovie() throws Exception {
        Movie removeMovie = new Movie("Tootsie", "1982", "Sydney Pollack", "9");
        movieList.removeMovie(0);

        assertEquals(1, movieList.getMovieList().size());
        assertTrue(!movieList.getMovieList().contains(removeMovie));
    }
}
