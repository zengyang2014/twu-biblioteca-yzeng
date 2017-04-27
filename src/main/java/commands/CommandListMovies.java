package commands;

import interfaces.Command;
import receivers.Receiver;

public class CommandListMovies implements Command {
    private Receiver receiver;
    public CommandListMovies(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public boolean shouldExecute(String command) {
        if(command.equals("2"))
            return true;
        return false;
    }

    @Override
    public void execute() {
        receiver.doListMovies();
    }
}
