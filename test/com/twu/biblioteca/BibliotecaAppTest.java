package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yzeng on 07/04/2017.
 */
public class BibliotecaAppTest {


    @Test
    public void shouldPrintOutSth() throws Exception {
        ConsoleOutput output = mockito.mock(ConsoleOutput.class);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(output);

        verify(output).print("welcome message!");
    }
}