package view.commands;

import view.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Finish", consoleUI);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
