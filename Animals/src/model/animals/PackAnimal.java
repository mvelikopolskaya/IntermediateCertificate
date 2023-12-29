package model.animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class PackAnimal extends CommandableAnimal {
    private Integer id;
    public String animalType;
    public String name;
    LocalDate birthDate;


    public PackAnimal(Integer id, String animalType, String name, LocalDate birthDate, ArrayList<String> knownCommands) {
        super(id, animalType, name, birthDate, knownCommands);
    }
}
