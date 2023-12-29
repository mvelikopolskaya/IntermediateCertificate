package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends DomesticAnimal {
    private ArrayList<String> knownCommands;

    public Cat(Integer id, String animalType, String name, LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, animalType, name, birthDate, knownCommands);
    }
}
