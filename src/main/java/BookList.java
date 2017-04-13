import java.util.ArrayList;
public class BookList {
    private ArrayList<Book> bookList = null;
    BookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public String bookList() {
        if(bookList == null) {
            return null;
        }

        String bookListString = "";
        for (int i = 0; i < bookList.size(); i++) {
            bookListString += bookList.get(i).getBookName() + "\n";
        }

        return bookListString;
    }

    public boolean removeBook(int index) {
        if(index >= 0 && index < bookList.size()) {
            bookList.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addBook(Book returnBook) {
        if(returnBook != null) {
            bookList.add(returnBook);
            return true;
        }
        else{
            return false;
        }
    }

    public String booksListDetail() {
        String booksDetails = generateOneRow(new Book());
        for(int i = 0; i < bookList.size(); i++)
        {
            booksDetails += i + ". " + generateOneRow(bookList.get(i));
        }
        return booksDetails;
    }

    private String generateOneRow(Book book) {
        return CellGenerator.generateOneCell(book.getBookName()) +
                CellGenerator.generateOneCell(book.getAuthor()) +
                CellGenerator.generateOneCell(book.getYearPublished()) + "\n";
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
