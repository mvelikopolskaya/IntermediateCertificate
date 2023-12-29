package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class DomesticAnimal extends CommandableAnimal {
    private Integer id;
    public String animalType;
    public String name;
    public LocalDate birthDate;

    public DomesticAnimal(Integer id, String animalType, String name, LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, animalType, name, birthDate, knownCommands);
    }
}
