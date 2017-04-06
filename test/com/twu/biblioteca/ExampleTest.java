package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private BibliotecaApp bibliotecaApp;

    @Before
    public void testSet() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testPrintWelcomeMessage() {
        String actualMessage = bibliotecaApp.printWelcomeMessage();

        assertEquals("Welcome to Biblioteca", actualMessage);
    }

    @Test
    public void testUserCanGetBooksList() {
        ArrayList<String> bookList = bibliotecaApp.getBookList();
        ArrayList<String> expectList = new ArrayList<String>(){{
            add("Test-driven Development");
            add("Refactoring: Improving the Design of Existing Code");
            add("Head First Java");
            add("Core Java Volume I");
        }};

        assertEquals(expectList, bookList);
    }
}
