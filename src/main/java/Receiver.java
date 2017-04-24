public class Receiver {
    private Output console;
    public Receiver() {
        console = new ConsoleOutput();
    }
    public Receiver(Output output) {
        this.console = output;
    }
    public void doQuit() {
        return;
    }

    public void doPrintWrongMessage() {
        console.print("Select a valid option!");
    }

    public void doPrintMessage(String message) {
        console.print(message);
    }

    public void doPrintMenu() {
        console.print("Main Manu:\n * 1. List Books\n * 2. List Movies \n" +
                " * 3. Return Book \n * 4. Login  \n * 5. Show User Info \n * 0. exit");
    }

}
