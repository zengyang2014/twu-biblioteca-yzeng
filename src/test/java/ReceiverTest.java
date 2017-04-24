import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReceiverTest {
    private Receiver receiver = null;
    private ConsoleOutput output;
    @Before
    public void testSet() {
        output = new ConsoleOutput();
        output = mock(ConsoleOutput.class);
        receiver = new Receiver(output);
    }
    @Test
    public void shouldPrintMainMenu() {
        receiver.doPrintMenu();

        verify(output, times(1)).print("Main Manu:\n * 1. List Books\n * 2. List Movies \n" +
                " * 3. Return Book \n * 4. Login  \n * 5. Show User Info \n * 0. exit");
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
}
