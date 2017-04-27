package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandShowUserInfo implements Command {
    private Receiver receiver = null;
    public CommandShowUserInfo(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if (command.equals("5"))
            return true;
        return false;
    }

    @Override
    public void execute() {
        receiver.doShowUserInfo();
    }
}
