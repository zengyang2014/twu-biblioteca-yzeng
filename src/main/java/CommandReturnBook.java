public class CommandReturnBook implements Command {
    private Receiver receiver = null;
    public CommandReturnBook(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doReturnBook();
    }
}
