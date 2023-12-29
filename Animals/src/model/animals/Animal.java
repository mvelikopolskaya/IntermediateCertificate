package model.animals;

import java.time.LocalDate;
import java.time.Period;

public class Animal {
    public Integer id;
    public String animalType;
    public String name;
    public LocalDate birthDate;

    public Animal(Integer id, String name, String animalType,  LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.animalType = animalType;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getAnimalType() {
        return this.getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ");
        stringBuilder.append(getId());
        stringBuilder.append("\n");
        stringBuilder.append("Name: ");
        stringBuilder.append(getName());
        stringBuilder.append("\n");
        stringBuilder.append("Animal type: ");
        stringBuilder.append(getAnimalType());
        stringBuilder.append("\n");
        stringBuilder.append("Age: ");
        stringBuilder.append(getAge());
        return stringBuilder.toString();
    }
}
