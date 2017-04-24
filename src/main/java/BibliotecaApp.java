import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookList = null;
    private MovieList movieList = null;
    private User user = null;
    private boolean isLogin = false;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.runApp();
    }

    BibliotecaApp() {
        user = new User("123-0001", "password", "George", "email@biblioteca.com", "61453");
        initializeBookList();
        initializeMovieList();
    }

    public void runApp() {
        Receiver receiver = new Receiver(bookList, movieList, isLogin, user);
        Invoker invoker = new Invoker();
        CommandParser commandParser = new CommandParser(receiver);
        String command = "";
        receiver.doPrintMessage("Welcome to Biblioteca\n------------------------------------------");
        while (!command.equals("0")) {
            receiver.doPrintMenu();
            receiver.doPrintMessage("Please input the command:");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            invoker.setCommand(commandParser.parseCommand(command));
            invoker.executeCommand();
        }

        receiver.doPrintMessage("Goodbye!");
    }

    private void initializeMovieList() {
        ArrayList<Movie> initMovieList = new ArrayList<>();
        initMovieList.add(new Movie("Tootsie", "1982", "Sydney Pollack", "9"));
        initMovieList.add(new Movie("The Godfather", "1972", "Francis Ford Coppola", "9"));

        movieList = new MovieList(initMovieList);
    }

    private void initializeBookList() {
        ArrayList<Book> initBookList = new ArrayList<Book>();
        initBookList.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        initBookList.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        initBookList.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        initBookList.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));

        bookList = new BookList(initBookList);
    }
}
