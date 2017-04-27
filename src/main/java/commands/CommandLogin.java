package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandLogin implements Command {
    private Receiver receiver = null;
    public CommandLogin(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if (command.equals("4"))
            return true;
        return false;
    }

    @Override
    public void execute() {
        receiver.doLogin();
    }
}
