import java.util.ArrayList;

/**
 * Created by yzeng on 13/04/2017.
 */
public class BookList {
    private static final int MAX_CELL_SPACE = 70;
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
        return generateOneCell(book.getBookName()) +
                generateOneCell(book.getAuthor()) +
                generateOneCell(book.getYearPublished()) + "\n";
    }

    private String generateOneCell(String cellElement) {
        String oneCell = "";
        oneCell += cellElement + createSpace(MAX_CELL_SPACE - cellElement.length());
        return oneCell;
    }

    private String createSpace(int spaceNum) {
        String spaces = "";
        for(int i = 0; i < spaceNum; i++) {
            spaces += " ";
        }
        return spaces;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
