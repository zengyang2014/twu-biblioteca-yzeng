public class Receiver {
    public void doQuit() {
        return;
    }

    public void doPrintWrongMessage() {
        ConsoleOutput console = new ConsoleOutput();
        console.print("Select a valid option!");
    }
}
