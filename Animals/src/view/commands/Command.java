package view.commands;

import view.view.ConsoleUI;

public abstract class Command implements ICommand{
    private String commandDescription;
    private ConsoleUI consoleUI;

    public Command(String commandDescription, ConsoleUI console) {
        this.commandDescription = commandDescription;
        this.consoleUI = console;
    }
    public ConsoleUI getConsole() {
        return consoleUI;
    }

    public String getCommandDescription() {
        return commandDescription;
    }
}
