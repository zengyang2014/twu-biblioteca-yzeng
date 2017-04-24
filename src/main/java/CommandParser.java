public class CommandParser {
    private Receiver receiver = null;
    public CommandParser(Receiver receiver) {
        this.receiver = receiver;
    }
    public Command parseCommand(String strCommand) {
        switch (strCommand) {
            case "0":
                return new CommandQuit(receiver);
            case "1":
                return new CommandListBooksDetail(receiver);
            case "2":
                return new CommandListMovies(receiver);
            case "3":
                return new CommandReturnBook(receiver);
            case "4":
                return new CommandLogin(receiver);
            case "5":
                return new CommandShowUserInfo(receiver);
            default:
                return new CommandPrintWrongMessage(receiver);
        }
    }
}