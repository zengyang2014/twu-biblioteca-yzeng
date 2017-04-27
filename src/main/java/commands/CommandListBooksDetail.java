package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandListBooksDetail implements Command {
    private Receiver receiver = null;
    public CommandListBooksDetail(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if(command.equals("1"))
            return true;
        return false;
    }

    @Override
    public void execute() {
        receiver.doListBookDetail();
    }
}
