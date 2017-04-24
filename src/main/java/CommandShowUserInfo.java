public class CommandShowUserInfo implements Command {
    private Receiver receiver = null;
    public CommandShowUserInfo(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doShowUserInfo();
    }
}
