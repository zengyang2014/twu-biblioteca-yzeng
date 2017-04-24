package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandListBooksDetail implements Command {
    private Receiver receiver = null;
    public CommandListBooksDetail(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doListBookDetail();
    }
}
