public class CommandPrintWrongMessage implements Command {
    private Receiver receiver = null;

    public CommandPrintWrongMessage(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.doPrintWrongMessage();
    }
}
