import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static final int MAX_CELL_SPACE = 70;
    private ArrayList<Book> bookList = null;
    private Output console;
    private ArrayList<Movie> movieList = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ConsoleOutput());
        bibliotecaApp.runApp();
    }

    BibliotecaApp(Output output){
        console = output;
        initializeBookList();
        initializeMovieList();
    }

    public ArrayList<Book> getBookList() {
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
                    printBooksDetail();
                    printHelpMessageToCheckoutBook();
                    checkoutBook(scanner.nextInt());
                    break;
                case "2":
                    printMovieListDetail();
                    break;
                default:
                    printWrongInstructionMessage();
                    break;
            }
        }
        printQuitMessage();
    }


    private void initializeMovieList() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Tootsie", "1982","Sydney Pollack", "9"));
        movieList.add(new Movie("The Godfather", "1972","Francis Ford Coppola", "9"));
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

    public void printBookList() {
        if(bookList == null) {
            return;
        }

        String printString = "";
        for (int i = 0; i < bookList.size(); i++) {
            printString += bookList.get(i).getBookName() + "\n";
        }

        console.print(printString);
    }

    public void printWelcomeMessage() {
        console.print("Welcome to Biblioteca\n------------------------------------------");
    }

    public void printBooksDetail() {
        String booksDetails = generateOneRow(new Book());
        for(int i = 0; i < bookList.size(); i++)
        {
            booksDetails += i + ". " + generateOneRow(bookList.get(i));
        }
        console.print(booksDetails);
    }

    public void printMainMenu() {
        console.print("Main Manu:\n * 1. List Books\n * 2. List Movies \n * 0. exit");
    }

    public void checkoutBook(int index) {
        if(index >= 0 && index < bookList.size()) {
            bookList.remove(index);
            console.print("Thank you! Enjoy the book");
        }
        else {
            console.print("That book is not available.");
        }
    }

    public void returnBook(Book returnBook) {
        if(returnBook != null) {
            bookList.add(returnBook);
            console.print("Thank you for returning the book.");
        }
        else{
            console.print("That is not a valid book to return.");
        }
    }

    private String generateOneRow(Book book) {
        return generateOneCell(book.getBookName()) +
                generateOneCell(book.getAuthor()) +
                generateOneCell(book.getYearPublished()) + "\n";
    }
    private String generateOneRow(Movie movie) {
        return generateOneCell(movie.getName()) +
                generateOneCell(movie.getYear()) +
                generateOneCell(movie.getDirector()) +
                generateOneCell(movie.getRating())+"\n";
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

    private void initializeBookList() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        bookList.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        bookList.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        bookList.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));
    }

    public void printMovieListDetail() {
        String moviesDetail = generateOneRow(new Movie());
        for(int i = 0; i < movieList.size(); i++)
        {
            moviesDetail += i + ". " + generateOneRow(movieList.get(i));
        }
        console.print(moviesDetail);
    }
}
