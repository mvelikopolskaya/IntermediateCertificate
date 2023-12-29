package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends DomesticAnimal {

    public Dog(Integer id, String animalType, String name, LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, animalType, name, birthDate, knownCommands);
    }
}
