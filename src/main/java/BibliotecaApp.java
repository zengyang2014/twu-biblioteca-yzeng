import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static final int MAX_CELL_SPACE = 70;
    private ArrayList<Book> bookLists = null;
    private Output console;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new ConsoleOutput());
        bibliotecaApp.runApp();
    }

    BibliotecaApp(Output output){
        console = output;
        initializeBookList();
    }

    private void initializeBookList() {
        bookLists = new ArrayList<Book>();
        bookLists.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        bookLists.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        bookLists.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        bookLists.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));
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
                    break;
                default:
                    printWrongInstructionMessage();
                    break;
            }
        }
        printQuitMessage();
    }

    public void printQuitMessage() {
        console.print("Goodbye!");
    }

    public void printWrongInstructionMessage() {
        console.print("Select a valid option!");
    }

    public void printBookList() {
        if(bookLists == null) {
            return;
        }

        String printString = "";
        for (int i = 0; i < bookLists.size(); i++) {
            printString += bookLists.get(i).getBookName() + "\n";
        }

        console.print(printString);
    }

    public void printWelcomeMessage() {
        console.print("Welcome to Biblioteca\n------------------------------------------");
    }

    public void printBooksDetail() {
        String booksDetails = generateOneRow(new Book());
        for(int i = 0; i < bookLists.size(); i++)
        {
            booksDetails += generateOneRow(bookLists.get(i));
        }
        console.print(booksDetails);
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

    public void printMainMenu() {
        console.print("Main Manu:\n * 1. List Books\n * 0. exit");
    }
}
