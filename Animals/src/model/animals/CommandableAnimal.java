package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class CommandableAnimal extends Animal implements Commandable{
    private ArrayList<String> knownCommands;

    public CommandableAnimal(Integer id, String name, String animalType,  LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, name, animalType, birthDate);
        this.knownCommands = knownCommands;
    }

    public String getKnownCommands() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> commandsIterator = knownCommands.iterator();
        while(commandsIterator.hasNext()) {
                stringBuilder.append(commandsIterator.next());
                if(commandsIterator.hasNext()){
                    stringBuilder.append(", ");
                }
                else stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    public void knowsCommand(String learnedCommand) {
        knownCommands.add(learnedCommand);
    }

    public void forgetCommand(String learnedCommand) {
        knownCommands.remove(learnedCommand);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("\n");
        stringBuilder.append("Known commands: ");
        stringBuilder.append(getKnownCommands());
        return stringBuilder.toString();
    }
}
