package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandPrintWrongMessage implements Command {
    private Receiver receiver = null;

    public CommandPrintWrongMessage(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        return false;
    }

    @Override
    public void execute() {
        receiver.doPrintWrongMessage();
    }
}
