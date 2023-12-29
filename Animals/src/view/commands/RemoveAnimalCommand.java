package view.commands;

import view.view.ConsoleUI;

public class RemoveAnimalCommand extends Command {
    public RemoveAnimalCommand(ConsoleUI consoleUI) {
        super("Remove command from an animal", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().removeAnimalCommand();
    }
}
