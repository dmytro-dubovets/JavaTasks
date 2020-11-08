package com.testing.tasks.notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private Scanner scanner;
    private List<String> list;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void userProcess() {
        scanner = new Scanner(System.in);
        list = new ArrayList<>();
        String lastname, firstname, surname;
        Scanner scanner = new Scanner(System.in);
        View.printMessage(View.INPUT_LASTNAME);
        lastname = model.inputRegex(scanner, Model.LASTNAME_REGEX);
        model.storeInfo(list,lastname);
        View.printMessage(View.INPUT_FIRSTNAME);
        firstname = model.inputRegex(scanner, Model.FIRSTNAME_REGEX);
        model.storeInfo(list,firstname);
        View.printMessage(View.INPUT_SURNAME);
        surname = model.inputRegex(scanner, Model.SURNAME_REGEX);
        model.storeInfo(list,surname);
        String result = model.getLastnameFirstnameSurname(list);
        if(list.size() > 0) {
            View.printMessage(result);
        }
    }
}
