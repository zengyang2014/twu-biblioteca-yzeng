import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private BibliotecaApp bibliotecaApp;
    private ConsoleOutput output;

    @Before
    public void testSet() {
        output = mock(ConsoleOutput.class);
        bibliotecaApp = new BibliotecaApp(output);
    }

    @Test
    public void shouldPrintMainMenu() {
        bibliotecaApp.printMainMenu();

        verify(output, times(1)).print("Main Manu:\n * 1. List Books\n * 2. List Movies \n * 3. Return Book \n * 4. Login \n * 0. exit");
    }

    @Test
    public void shouldShowInvalidMessage() {
        String expectPrint = "Select a valid option!";
        bibliotecaApp.printWrongInstructionMessage();

        verify(output, times(1)).print(expectPrint);
    }

    @Test
    public void testPrintQuitMessage() {
        String expectPrint = "Goodbye!";
        bibliotecaApp.printQuitMessage();

        verify(output, times(1)).print(expectPrint);
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        bibliotecaApp.printWelcomeMessage();

        verify(output, times(1)).print("Welcome to Biblioteca\n------------------------------------------");
    }

    @Test
    public void shouldUserCanRendBookAfterLogin() {
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.checkoutBook(0);

        verify(output, times(1)).print("Thank you! Enjoy the book");
    }

    @Test
    public void shouldUserCannotRendBookBeforeLogin() {
        bibliotecaApp.userLogin("123-0001", "wrongPassword");
        bibliotecaApp.checkoutBook(0);

        verify(output, times(1)).print("Please Login!");
    }

    @Test
    public void shouldCheckoutBookSuccessfully() throws Exception {
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.checkoutBook(0);

        verify(output, times(1)).print("Thank you! Enjoy the book");
    }

    @Test
    public void shouldCheckoutBookUnsuccessfully() throws Exception {
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.checkoutBook(10);

        verify(output, times(1)).print("That book is not available.");
    }

    @Test
    public void shouldUserCanReturnBookAfterLogin() throws  Exception {
        Book returnBook = new Book("testBook", "testAuthor","testYear");
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.returnBook(returnBook);

        verify(output, times(1)).print("Thank you for returning the book.");
    }

    @Test
    public void shouldUserCannotReturnBookBeforeLogin() throws  Exception {
        Book returnBook = new Book("testBook", "testAuthor","testYear");
        bibliotecaApp.userLogin("123-0001", "wrongPassword");
        bibliotecaApp.returnBook(returnBook);

        verify(output, times(1)).print("Please Login!");
    }

    @Test
    public void shouldReturnBookSuccessfully() throws  Exception {
        Book returnBook = new Book("testBook", "testAuthor","testYear");
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.returnBook(returnBook);

        verify(output, times(1)).print("Thank you for returning the book.");
    }

    @Test
    public void shouldReturnBookUnsuccessfully() throws Exception {
        Book returnBook = null;
        bibliotecaApp.userLogin("123-0001", "password");
        bibliotecaApp.returnBook(returnBook);

        verify(output, times(1)).print("That is not a valid book to return.");
    }
}
