package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandListMovies implements Command {
    private Receiver receiver;
    public CommandListMovies(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doListMovies();
    }
}
