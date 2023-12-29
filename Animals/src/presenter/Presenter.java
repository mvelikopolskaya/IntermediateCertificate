package presenter;

import model.service.Service;
import view.view.View;
import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addAnimal(String name, String animalType, LocalDate birthDate, ArrayList<String> knownCommands){
        service.addAnimal(name, animalType,birthDate, knownCommands);
    }

    public void removeAnimal(Integer id) {
        service.removeAnimal(id);
    }

    public void showAnimalList() {
        view.printText(service.showAnimalsList());
    }

    public void showAnimalCommands(Integer id) {
        view.printText(service.showListOfCommands(id));
    }

    public void addCommandToAnimal(Integer id, String command) {
        service.addCommandToAnimal(id, command);
    }

    public void removeAnimalCommand(Integer id, String command) {
        service.removeCommand(id, command);
    }
}
