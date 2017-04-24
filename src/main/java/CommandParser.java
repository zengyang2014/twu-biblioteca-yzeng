public class CommandParser {
    private Receiver receiver = null;
    public CommandParser(Receiver receiver) {
        this.receiver = receiver;
    }
    public Command parseCommand(String strCommand) {
        switch (strCommand) {
            case "0":
                return new CommandQuit(receiver);
            default:
                return new CommandPrintWrongMessage(receiver);
        }
    }
}
