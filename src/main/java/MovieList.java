import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movieList = null;
    private static final int MAX_CELL_SPACE = 70;

    MovieList(ArrayList<Movie> movieList) {
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
        return generateOneCell(movie.getName()) +
                generateOneCell(movie.getYear()) +
                generateOneCell(movie.getDirector()) +
                generateOneCell(movie.getRating())+"\n";
    }

    private String generateOneRow(Book book) {
        return generateOneCell(book.getBookName()) +
                generateOneCell(book.getAuthor()) +
                generateOneCell(book.getYearPublished()) + "\n";
    }

    private String generateOneCell(String cellElement) {
        String oneCell = "";
        oneCell += cellElement + createSpace(MAX_CELL_SPACE - cellElement.length());
        return oneCell;
    }

    private String createSpace(int spaceNum) {
        String spaces = "";
        for(int i = 0; i < spaceNum; i++) {
            spaces += " ";
        }
        return spaces;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
}
