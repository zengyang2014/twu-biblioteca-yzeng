package services;

import commands.*;
import interfaces.Command;
import receivers.Receiver;

import java.util.ArrayList;

public class CommandParser {
    private Receiver receiver = null;
    private ArrayList<Command> registerCommands = null;

    public CommandParser(Receiver receiver) {
        this.receiver = receiver;
        registerCommands = new ArrayList<Command>() {{
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
        for (Command command : registerCommands) {
            if (command.shouldExecute(strCommand)) {
                return command;
            }
        }
        return new CommandPrintWrongMessage(receiver);
    }
}