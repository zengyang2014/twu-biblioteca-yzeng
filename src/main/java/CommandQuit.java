public class CommandQuit implements Command {
    private Receiver receiver = null;



    public CommandQuit(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        receiver.doQuit();
    }
}
