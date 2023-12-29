package model.animals;

import java.util.Iterator;
import java.util.List;

public class AnimalsIterator<Animal> implements Iterator<Animal> {
    private int index;
    private List<Animal> animalList;

    public AnimalsIterator(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public boolean hasNext() {
        return animalList.size() > index;
    }

    @Override
    public Animal next() {
        return animalList.get(index++);
    }
}
