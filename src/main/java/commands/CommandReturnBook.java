package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandReturnBook implements Command {
    private Receiver receiver = null;
    public CommandReturnBook(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if (command.equals("3"))
            return true;
        return false;
    }

    @Override
    public void execute() {
        receiver.doReturnBook();
    }
}
