package services;

import interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
