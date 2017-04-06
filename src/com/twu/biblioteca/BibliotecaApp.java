package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.printWelcomeMessage());
    }

    public String printWelcomeMessage() {
        return "Welcome to Biblioteca";
    }
}
