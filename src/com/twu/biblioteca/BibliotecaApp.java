package com.twu.biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<String> bookList = null;
    private JTable bookDetail = null;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.printWelcomeMessage());
        System.out.println(bibliotecaApp.printBookList());
    }

    BibliotecaApp(){
        initializeBookList();
        initializeBookDetail();
    }

    private void initializeBookDetail() {
        bookDetail = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel)bookDetail.getModel();
        tableModel.addColumn("Book Name");
        tableModel.addColumn("Author");
        tableModel.addColumn("Year Published");
        Object[] book1 = {"Test-driven Development", "Kent Beck", "2003"};
        Object[] book2 = {"Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"};
        Object[] book3 = {"Head First Java", "Kathy Sierra, Bert Bates", "2003"};
        Object[] book4 = {"Core Java Volume I", "Cay S. Horstmann", "2015"};
        tableModel.addRow(book1);
        tableModel.addRow(book2);
        tableModel.addRow(book3);
        tableModel.addRow(book4);
    }

    private void initializeBookList() {
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
