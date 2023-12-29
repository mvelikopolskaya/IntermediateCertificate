package view.commands;

import view.view.ConsoleUI;

public class AddAnimalCommand extends Command {
    public AddAnimalCommand(ConsoleUI consoleUI) {
        super("Add a command to an animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().addCommandToAnimal();
    }
}
