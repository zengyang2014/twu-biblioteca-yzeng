public class Movie {
    private String name;

    private String year;
    private String director;
    private String rating;
    Movie(){
        this.name = "Name";
        this.year = "Year";
        this.director = "Director";
        this.rating = "Rating";
    }

    Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }
}
