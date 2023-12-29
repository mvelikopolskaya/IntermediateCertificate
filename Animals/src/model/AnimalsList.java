package model;

import model.animals.AnimalsIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.animals.Animal;

public class AnimalsList<Animal> implements Iterable<Animal> {
    public List<Animal> animalsList;
    public AnimalsList() {
        animalsList = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animalsList.add(animal);
    }

    public void removeAnimal(Animal animal){
        animalsList.remove(animal);
    }

    @Override
    public Iterator iterator() {
        return new AnimalsIterator<>(animalsList);
    }
}
