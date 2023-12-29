package view.commands;

import view.view.ConsoleUI;

public class AddAnimal extends Command {
    public AddAnimal(ConsoleUI consoleUI) {
        super("Add an animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().addAnimal();
    }
}
