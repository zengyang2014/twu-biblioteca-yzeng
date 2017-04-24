import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private BookList bookList = null;
    private Output console;
    private MovieList movieList = null;
    private User user = null;
    private boolean isLogined = false;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ConsoleOutput());
        bibliotecaApp.runApp();
    }

    BibliotecaApp(Output output){
        console = output;
        user = new User("123-0001", "password", "George", "email@biblioteca.com", "61453");
        initializeBookList();
        initializeMovieList();
    }

    public void runApp() {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker();
        CommandParser commandParser = new CommandParser(receiver);
        String command = "";
        printWelcomeMessage();
        while (!command.equals("0")) {
            printMainMenu();
            console.print("Please input the command:");
            Scanner scanner = new Scanner(System.in);
            command = scanner.next();
            invoker.setCommand(commandParser.parseCommand(command));
            invoker.executeCommand();
        }


//        printWelcomeMessage();
//        String instruction = "";
//        while (!instruction.equals("Quit") && !instruction.equals("0")) {
//            printMainMenu();
//            console.print("Please input the selection:");
//            Scanner scanner = new Scanner(System.in);
//            instruction = scanner.next();
//            switch (instruction) {
//                case "0":
//                    break;
//                case "1":
//                    console.print(bookList.booksListDetail());
//                    printHelpMessageToCheckoutBook();
//                    checkoutBook(scanner.nextInt());
//                    break;
//                case "2":
//                    console.print(movieList.movieListDetail());
//                    break;
//                case "3":
//                    printHelpMessageToReturnBook();
//                    returnBook(new Book(scanner.next(), scanner.next(), scanner.next()));
//                    break;
//                case "4":
//                    userLogin(scanner.next(), scanner.next());
//                    break;
//                case "5":
//                    showUserInfo();
//                    break;
//                default:
//                    printWrongInstructionMessage();
//                    break;
//            }
//        }
        printQuitMessage();
    }

    private void showUserInfo() {
        console.print(user.userInfo());
    }

    public void userLogin(String account, String password) {
        isLogined = user.login(account, password);
    }

    private void printHelpMessageToReturnBook() {
        console.print("Please input the data of return book. (name, author, published year)");
    }

    public void checkoutBook(int index) {
        if(isLogined) {
            if (bookList.removeBook(index)) {
                console.print("Thank you! Enjoy the book");
            } else {
                console.print("That book is not available.");
            }
        }
        console.print("Please Login!");
    }

    public void returnBook(Book returnBook) {
        if(isLogined) {
            if (bookList.addBook(returnBook)) {
                console.print("Thank you for returning the book.");
            } else {
                console.print("That is not a valid book to return.");
            }
        }
        console.print("Please Login!");
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
        console.print("Main Manu:\n * 1. List Books\n * 2. List Movies \n" +
                " * 3. Return Book \n * 4. Login  \n * 5. Show User Info \n * 0. exit");
    }

    private void initializeBookList() {
        ArrayList<Book> initBookList = new ArrayList<Book>();
        initBookList.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        initBookList.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        initBookList.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        initBookList.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));

        bookList = new BookList(initBookList);
    }

    public User getUser() {
        return user;
    }
}
