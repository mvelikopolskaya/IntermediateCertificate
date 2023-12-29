package view.commands;

import view.view.ConsoleUI;

public class RemoveAnimal extends Command {
    public RemoveAnimal(ConsoleUI consoleUI) {
        super("Remove animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().removeAnimal();
    }
}
