package view.view;

import presenter.Presenter;
import view.commands.AnimalsMenu;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private AnimalsMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new AnimalsMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while(flag) {
            System.out.println("Choose action:");
            System.out.println(menu.menu());
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addAnimal() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input date of birth");
        LocalDate birthDate = inputDate();
        System.out.println("Input animal type");
        String animalType = scanner.nextLine();
        ArrayList<String> knownCommands = new ArrayList<>();
        System.out.println("Does animal know commands(y/n)?");
        String answer = scanner.nextLine();
        if(answer.equalsIgnoreCase("y")) {
            System.out.println("Input command or press Enter to exit");
            String command;
            do {
                command = scanner.nextLine();
                if(!command.isEmpty()) {
                    knownCommands.add(command);
                }
                scanner.reset();
            } while (!command.isEmpty());
        }
        presenter.addAnimal(name, animalType, birthDate, knownCommands);
    }

    public void removeAnimal() {
        try {
            System.out.println("Which animal do you want to remove (input id)?");
            String id = scanner.nextLine();
            int intID = Integer.parseInt(id);
            presenter.removeAnimal(intID);
        } catch (Exception e) {
        }
    }

    public void showAnimalsList() {
        presenter.showAnimalList();
    }

    public void addCommandToAnimal() {
        try {
            System.out.println("Choose an animal to teach a command (input id)");
            String id = scanner.nextLine();
            int intID = Integer.parseInt(id);
            System.out.println("Input command");
            String command = scanner.nextLine();
            presenter.addCommandToAnimal(intID, command);
        } catch (Exception e) {
        }
    }

    public void removeAnimalCommand() {
        try {
            System.out.println("Choose an animal to forget a command (input id)");
            String id = scanner.nextLine();
            int intID = Integer.parseInt(id);
            System.out.println("Input command");
            String command = scanner.nextLine();
            presenter.removeAnimalCommand(intID, command);
        } catch (Exception e) {
        }
    }

    public void showAnimalCommands() {
        try {
            System.out.println("Choose an animal to show it's commands (input id)");
            String id = scanner.nextLine();
            int intID = Integer.parseInt(id);
            presenter.showAnimalCommands(intID);
        } catch (Exception e) {
        }
    }

    private LocalDate inputDate() {
        boolean inputDate;
        LocalDate reqDate = null;
        do {
            System.out.println("Input year");
            String year = scanner.nextLine();
            System.out.println("Input month");
            String month = scanner.nextLine();
            System.out.println("Input day");
            String day = scanner.nextLine();
            String date = year + "-" + month + "-" + day;
            inputDate = true;
            try {
                reqDate = LocalDate.parse(date);
            } catch (DateTimeException e){
                inputDate = false;
                System.out.println("Wrong data");
            }
        } while (!inputDate);
        return reqDate;
    }

    public void finish() {
        flag = false;
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
