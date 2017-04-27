package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandQuit implements Command {
    private Receiver receiver = null;

    public CommandQuit(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if (command.equals("0")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute() {
        receiver.doQuit();
    }
}
