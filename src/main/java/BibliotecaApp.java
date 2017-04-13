import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookList = null;
    private Output console;
    private MovieList movieList = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ConsoleOutput());
        bibliotecaApp.runApp();
    }

    BibliotecaApp(Output output){
        console = output;
        initializeBookList();
        initializeMovieList();
    }

    public BookList getBookList() {
        return bookList;
    }


    public void runApp() {
        printWelcomeMessage();
        String instruction = "";
        while (!instruction.equals("Quit") && !instruction.equals("0")) {
            printMainMenu();
            console.print("Please input the selection:");
            Scanner scanner = new Scanner(System.in);
            instruction = scanner.next();
            switch (instruction) {
                case "0":
                    break;
                case "1":
                    console.print(bookList.booksListDetail());
                    printHelpMessageToCheckoutBook();
                    checkoutBook(scanner.nextInt());
                    break;
                case "2":
                    console.print(movieList.movieListDetail());
                    break;
                default:
                    printWrongInstructionMessage();
                    break;
            }
        }
        printQuitMessage();
    }

    public void checkoutBook(int index) {
        if(bookList.removeBook(index)) {
            console.print("Thank you! Enjoy the book");
        }
        else {
            console.print("That book is not available.");
        }
    }

    public void returnBook(Book returnBook) {
        if(bookList.addBook(returnBook)) {
            console.print("Thank you for returning the book.");
        }
        else {
            console.print("That is not a valid book to return.");
        }
    }


    private void initializeMovieList() {
        ArrayList<Movie> initMovieList = new ArrayList<>();
        initMovieList.add(new Movie("Tootsie", "1982","Sydney Pollack", "9"));
        initMovieList.add(new Movie("The Godfather", "1972","Francis Ford Coppola", "9"));

        movieList = new MovieList(initMovieList);
    }

    private void printHelpMessageToCheckoutBook() {
        console.print("Input the index of book which need to checkout.");
    }

    public void printQuitMessage() {
        console.print("Goodbye!");
    }

    public void printWrongInstructionMessage() {
        console.print("Select a valid option!");
    }

    public void printWelcomeMessage() {
        console.print("Welcome to Biblioteca\n------------------------------------------");
    }

    public void printMainMenu() {
        console.print("Main Manu:\n * 1. List Books\n * 2. List Movies \n * 0. exit");
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
