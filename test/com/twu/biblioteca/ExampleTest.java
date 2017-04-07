package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
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
    public void testPrintBookList() {
        String actualPrint = bibliotecaApp.printBookList();
        String expectPrint = "Test-driven Development\n" +
                "Refactoring: Improving the Design of Existing Code\n" +
                "Head First Java\n" +
                "Core Java Volume I\n";

        assertEquals(expectPrint,actualPrint);
    }
}
