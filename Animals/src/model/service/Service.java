package model.service;

import model.AnimalsList;
import model.animals.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Service {
    public AnimalsList<Animal> animalsList;
    private int id = 1;

    public Service() {
        animalsList = new AnimalsList<>();
    }

    public void addAnimal(String name, String animalType, LocalDate birthDate, ArrayList<String> knownCommands) {
        Animal animal = null;
        if (animalType.equalsIgnoreCase("Cat")) {
            animal = new Cat(id++, name, animalType, birthDate, knownCommands);
            } else if (animalType.equalsIgnoreCase("Dog")) {
            animal = new Dog(id++, name, animalType, birthDate, knownCommands);
        } else if (animalType.equalsIgnoreCase("Hamster")) {
            animal = new Hamster(id++, name, animalType, birthDate, knownCommands);
        } else if (animalType.equalsIgnoreCase("Horse")) {
            animal = new Horse(id++, name, animalType, birthDate, knownCommands);
        } else if (animalType.equalsIgnoreCase("Camel")) {
            animal = new Camel(id++, name, animalType, birthDate, knownCommands);
        } else if (animalType.equalsIgnoreCase("Donkey")) {
            animal = new Donkey(id++, name, animalType, birthDate, knownCommands);
        }
        animalsList.addAnimal(animal);
    }

    public Animal findByID(Integer requiredID){
        Animal result = null;
        for (Animal animal : animalsList) {
            if (animal.getId() == requiredID) {
                result = animal;
            }
        }
        return result;
    }

    public void removeAnimal(Integer id){
        Animal result = findByID(id);
        animalsList.removeAnimal(result);
    }

    public void addCommandToAnimal(Integer id, String learnedCommand){
        CommandableAnimal result = (CommandableAnimal) findByID(id);
        result.knowsCommand(learnedCommand);
    }

    public void removeCommand(Integer id, String forgottenCommand) {
        CommandableAnimal result = (CommandableAnimal) findByID(id);
        result.forgetCommand(forgottenCommand);
    }

    public String showListOfCommands(Integer id){
        CommandableAnimal result = (CommandableAnimal) findByID(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of known commands: ");
        stringBuilder.append(result.getKnownCommands());
        return stringBuilder.toString();
    }

    public String showAnimalsList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animals list:");
        stringBuilder.append("\n");
        for(Animal animal : animalsList) {
            stringBuilder.append(animal);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
