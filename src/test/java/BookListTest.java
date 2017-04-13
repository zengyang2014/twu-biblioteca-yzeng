import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yzeng on 13/04/2017.
 */
public class BookListTest {
    private BookList bookList = null;

    @Before
    public void setUp() {
        ArrayList<Book> initBookList = new ArrayList<Book>();
        initBookList.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        initBookList.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        initBookList.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        initBookList.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));

        bookList = new BookList(initBookList);
    }

    @Test
    public void shouldReturnBookList() {
        String expectPrint = "Test-driven Development\n" +
                "Refactoring: Improving the Design of Existing Code\n" +
                "Head First Java\n" +
                "Core Java Volume I\n";

        assertEquals(expectPrint, bookList.bookList());
    }

    @Test
    public void shouldReturnBookListDetail() {
        String expectPrint = "Book Name                                                             Author                                                                Year Published                                                        \n" +
                "0. Test-driven Development                                               Kent Beck                                                             2003                                                                  \n" +
                "1. Refactoring: Improving the Design of Existing Code                    Martin Fowler                                                         2012                                                                  \n" +
                "2. Head First Java                                                       Kathy Sierra, Bert Bates                                              2003                                                                  \n" +
                "3. Core Java Volume I                                                    Cay S. Horstmann                                                      2015                                                                  \n";

        assertEquals(expectPrint, bookList.booksListDetail());
    }

    @Test
    public void shouldRemoveBook() throws Exception {
        Book checkoutBook = new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012");
        bookList.removeBook(1);

        assertEquals(3,bookList.getBookList().size());
        assertTrue(!bookList.getBookList().contains(checkoutBook));
    }

    @Test
    public void shouldAddBook() throws Exception {
        Book returnBook = new Book("testBook", "testAuthor","testYear");
        bookList.addBook(returnBook);

        assertEquals(5, bookList.getBookList().size());
        assertTrue(bookList.getBookList().contains(returnBook));
    }
}
