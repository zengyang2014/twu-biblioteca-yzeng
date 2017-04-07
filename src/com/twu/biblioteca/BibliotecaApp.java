package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.printWelcomeMessage());
        System.out.println(bibliotecaApp.printBookList());
    }

    BibliotecaApp(){
        bookList = new ArrayList<>();
        bookList.add("Test-driven Development");
        bookList.add("Refactoring: Improving the Design of Existing Code");
        bookList.add("Head First Java");
        bookList.add("Core Java Volume I");
    }
    public String printBookList() {
        if(bookList == null) {
            return null;
        }

        String printString = "";
        for (int i = 0; i < bookList.size(); i++) {
            printString += bookList.get(i) + "\n";
        }

        return printString;
    }

    public String printWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public ArrayList<String> getBookList() {
        return bookList;
    }
}
