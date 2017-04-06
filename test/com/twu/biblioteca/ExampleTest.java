package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testPrintWelcomeMessage() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String actualMessage = bibliotecaApp.printWelcomeMessage();

        assertEquals("Welcome to Biblioteca", actualMessage);
    }
}
