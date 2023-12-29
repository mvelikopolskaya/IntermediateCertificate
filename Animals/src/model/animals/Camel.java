package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends PackAnimal {

    public Camel(Integer id, String animalType, String name, LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, animalType, name, birthDate, knownCommands);
    }
}
