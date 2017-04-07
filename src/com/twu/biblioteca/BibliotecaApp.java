package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static final int MAX_CELL_SPACE = 70;
    private ArrayList<Book> bookLists = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.runApp();
    }

    BibliotecaApp(){
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
        System.out.println(printWelcomeMessage());
        String instruction = "";
        while (!instruction.equals("Quit") && !instruction.equals("0")) {
            System.out.println(printMainMenu());
            System.out.println("Please input the selection:");
            Scanner scanner = new Scanner(System.in);
            instruction = scanner.next();
            switch (instruction) {
                case "0":
                    break;
                case "1":
                    System.out.println(printBooksDetail());
                    break;
                default:
                    System.out.println(printWrongInstructionMessage());
                    break;
            }
        }
        System.out.println(printQuitMessage());
    }

    public String printQuitMessage() {
        return "Goodbye!";
    }

    public String printWrongInstructionMessage() {
        return "Select a valid option!";
    }

    public String printBookList() {
        if(bookLists == null) {
            return null;
        }

        String printString = "";
        for (int i = 0; i < bookLists.size(); i++) {
            printString += bookLists.get(i).getBookName() + "\n";
        }

        return printString;
    }

    public String printWelcomeMessage() {
        return "Welcome to Biblioteca\n------------------------------------------";
    }

    public ArrayList<Book> getBookLists() {
        return bookLists;
    }

    public String printBooksDetail() {
        String booksDetails = printOneRow(new Book());
        for(int i = 0; i < bookLists.size(); i++)
        {
            booksDetails += printOneRow(bookLists.get(i));
        }
        return booksDetails;
    }

    private String printOneRow(Book book) {
        return printOneCell(book.getBookName()) +
                printOneCell(book.getAuthor()) +
                printOneCell(book.getYearPublished()) + "\n";
    }

    private String printOneCell(String cellElement) {
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

    public String printMainMenu() {
        return "Main Manu:\n * 1. List Books\n * 0. exit";
    }
}
