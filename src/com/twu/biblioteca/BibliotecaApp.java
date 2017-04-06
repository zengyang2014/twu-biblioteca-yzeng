package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.printWelcomeMessage());
    }

    BibliotecaApp(){
        bookList = new ArrayList<>();
        bookList.add("Test-driven Development");
        bookList.add("Refactoring: Improving the Design of Existing Code");
        bookList.add("Head First Java");
        bookList.add("Core Java Volume I");
    }

    public String printWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public ArrayList<String> getBookList() {
        return bookList;
    }
}
