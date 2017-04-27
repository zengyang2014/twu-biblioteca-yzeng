package services;

import commands.*;
import interfaces.Command;
import receivers.Receiver;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {
    private Receiver receiver = null;
    private ArrayList<Command> registedCommands = null;

    public CommandParser(Receiver receiver) {
        this.receiver = receiver;
        registedCommands = new ArrayList<Command>() {{
            add(new CommandQuit(receiver));
            add(new CommandListBooksDetail(receiver));
            add(new CommandListMovies(receiver));
            add(new CommandReturnBook(receiver));
            add(new CommandLogin(receiver));
            add(new CommandShowUserInfo(receiver));
            add(new CommandPrintWrongMessage(receiver));
        }};
    }

    public Command parseCommand(String strCommand) {
        for (Command command : registedCommands) {
            if (command.shouldExecute(strCommand)) {
                return command;
            }
        }
        return new CommandPrintWrongMessage(receiver);
    }
}