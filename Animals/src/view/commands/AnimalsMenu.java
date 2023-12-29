package view.commands;

import view.view.ConsoleUI;
import java.util.ArrayList;
import java.util.List;

public class AnimalsMenu {
    private List<Command> commandsList;

    public AnimalsMenu(ConsoleUI consoleUI) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddAnimal(consoleUI));
        commandsList.add(new RemoveAnimal(consoleUI));
        commandsList.add(new ShowAnimalsList(consoleUI));
        commandsList.add(new AddAnimalCommand(consoleUI));
        commandsList.add(new RemoveAnimalCommand(consoleUI));
        commandsList.add(new ShowCommandsList(consoleUI));
        commandsList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listSize(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsList.get(i).getCommandDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int act) {
        Command command = commandsList.get(act - 1);
        command.execute();
    }

    public int listSize() {
        return commandsList.size();
    }
}
