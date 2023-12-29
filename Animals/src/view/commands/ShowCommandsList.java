package view.commands;

import view.view.ConsoleUI;

public class ShowCommandsList extends Command {
    public ShowCommandsList(ConsoleUI consoleUI) {
        super("Show list of animal's commands", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().showAnimalCommands();
    }
}
