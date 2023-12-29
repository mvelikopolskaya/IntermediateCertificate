package view.commands;

import view.view.ConsoleUI;

public class ShowAnimalsList extends Command {
    public ShowAnimalsList(ConsoleUI consoleUI) {
        super("Show list of animals", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().showAnimalsList();
    }
}
