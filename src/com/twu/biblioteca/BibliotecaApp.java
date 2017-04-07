package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> bookLists = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.printWelcomeMessage());
        System.out.println(bibliotecaApp.printBookList());
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
        return "Welcome to Biblioteca";
    }

    public ArrayList<Book> getBookLists() {
        return bookLists;
    }
}
