import lists.BookList;
import lists.MovieList;
import models.Book;
import models.Movie;
import models.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import receivers.Receiver;
import services.ConsoleInput;
import services.ConsoleOutput;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReceiverTest {
    private Receiver receiver = null;
    private ConsoleOutput output;
    private ConsoleInput input;
    private BookList bookList;
    private MovieList movieList;
    private User user;

    private void initializeMovieList() {
        ArrayList<Movie> initMovieList = new ArrayList<>();
        initMovieList.add(new Movie("Tootsie", "1982","Sydney Pollack", "9"));
        initMovieList.add(new Movie("The Godfather", "1972","Francis Ford Coppola", "9"));

        movieList = new MovieList(initMovieList);
    }

    private void initializeBookList() {
        ArrayList<Book> initBookList = new ArrayList<Book>();
        initBookList.add(new Book("Test-driven Development", "Kent Beck", "2003"));
        initBookList.add(new Book("Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2012"));
        initBookList.add(new Book("Head First Java", "Kathy Sierra, Bert Bates", "2003"));
        initBookList.add(new Book("Core Java Volume I", "Cay S. Horstmann", "2015"));

        bookList = new BookList(initBookList);
    }

    @Before
    public void testSet() {
        user = new User("123-0001", "password", "George", "email@biblioteca.com", "61453");
        initializeBookList();
        initializeMovieList();


        output = new ConsoleOutput();
        input = new ConsoleInput();
        output = mock(ConsoleOutput.class);
        input = mock(ConsoleInput.class);
        receiver = new Receiver(output, input, bookList, movieList, false, user);
    }
    @Test
    public void shouldPrintMainMenu() {
        receiver.doPrintMenu();

        verify(output, times(1)).print("Main Manu:\n * 1. List Books\n * 2. List Movies \n" +
                " * 3. Return models.Book \n * 4. Login  \n * 5. Show models.User Info \n * 0. exit");
    }

    @Test
    public void shouldShowInvalidMessage() {
        String expectPrint = "Select a valid option!";
        receiver.doPrintWrongMessage();

        verify(output, times(1)).print(expectPrint);
    }

    @Test
    public void testPrintQuitMessage() {
        String expectPrint = "Goodbye!";
        receiver.doPrintMessage("Goodbye!");

        verify(output, times(1)).print(expectPrint);
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        receiver.doPrintMessage("Welcome to Biblioteca\n------------------------------------------");
        verify(output, times(1)).print("Welcome to Biblioteca\n------------------------------------------");
    }

    @Test
    public void shouldUserCanRendBookAfterLogin() {
        Mockito.when(input.read()).thenReturn("123-0001", "password","1");

        receiver.doLogin();
        receiver.doCheckoutBook();

        verify(output, times(1)).print("Thank you! Enjoy the book");
    }

    @Test
    public void shouldUserCannotRendBookBeforeLogin() {
        Mockito.when(input.read()).thenReturn("123-0001", "wrongPassword","1");

        receiver.doLogin();
        receiver.doCheckoutBook();

        verify(output, times(1)).print("Please Login!");
    }

    @Test
    public void shouldCheckoutBookSuccessfully() throws Exception {
        Mockito.when(input.read()).thenReturn("123-0001", "password","0");

        receiver.doLogin();
        receiver.doCheckoutBook();

        verify(output, times(1)).print("Thank you! Enjoy the book");
    }

    @Test
    public void shouldCheckoutBookUnsuccessfully() throws Exception {
        Mockito.when(input.read()).thenReturn("123-0001", "password","10");

        receiver.doLogin();
        receiver.doCheckoutBook();

        verify(output, times(1)).print("That book is not available.");
    }

    @Test
    public void shouldUserCanReturnBookAfterLogin() throws  Exception {
        Mockito.when(input.read()).thenReturn("123-0001", "password","testBook", "testAuthor","testYear");

        receiver.doLogin();
        receiver.doReturnBook();

        verify(output, times(1)).print("Thank you for returning the book.");
    }

    @Test
    public void shouldUserCannotReturnBookBeforeLogin() throws  Exception {
        Mockito.when(input.read()).thenReturn("testBook", "testAuthor","testYear");

        receiver.doReturnBook();

        verify(output, times(1)).print("Please Login!");
    }

    @Test
    public void shouldReturnBookSuccessfully() throws  Exception {
        Mockito.when(input.read()).thenReturn("123-0001", "password","testBook", "testAuthor","testYear");

        receiver.doLogin();
        receiver.doReturnBook();

        verify(output, times(1)).print("Thank you for returning the book.");
    }

    @Test
    public void shouldReturnBookUnsuccessfully() throws Exception {
        Mockito.when(input.read()).thenReturn("123-0001", "password");
        bookList = mock(BookList.class);
        receiver.setBookList(bookList);
        Mockito.when(bookList.addBook(Mockito.any(Book.class))).thenReturn(false);

        receiver.doLogin();
        receiver.doReturnBook();

        verify(output, times(1)).print("That is not a valid book to return.");
    }
}
