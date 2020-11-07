package com.testing.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Model model;
    private final View view;
    private int randomNumber;
    private int next;
    private int attempts = 1;
    private Scanner scanner;
    private List<Integer> numbers;
    private List<Integer> listOfAllNumbers;
    private List<Integer> newRange;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void userProcess() {
        scanner = new Scanner(System.in);
        numbers = new ArrayList<>();
        listOfAllNumbers = new ArrayList<>();
        newRange = new ArrayList<>();
        view.printMessage(View.INPUT_INT_VALUE);
        view.printMessage(View.ADDITIONAL_INFO);
        // Set min and max
        model.setFirstNumber(1);
        model.setSecondNumber(99);
        // Set random number
        randomNumber = model.getRandomNumber(model.getFirstNumber(), model.getSecondNumber());
        // Validate if it is not a number
        //model.validateTheInput(scanner);
        model.validateInput(scanner);
        // Get integer number
        next = scanner.nextInt();
        // Add all integer number
        listOfAllNumbers.add(next);
        // Check if input number equals to random
        while (next != randomNumber) {
            view.printMessage(View.INPUT_NOT_EQUALS_TO_RANDOM_NUMBER);
            numbers.add(next);
            if (next > randomNumber) {
                view.printMessage(View.INPUT_VALUE_IS_GREATER);
            } else {
                view.printMessage(View.INPUT_VALUE_IS_LESS);
            }
            if (attempts == 2) {
                model.swapFromStartedToNewRange(numbers, newRange);
                model.setFirstNumber(newRange.get(0));
                model.setSecondNumber(newRange.get(1));
                randomNumber = model.getRandomNumber(model.getFirstNumber(), model.getSecondNumber());
                view.printMessage(View.NEW_RANGE + View.FROM + model.getFirstNumber() + View.TO + model.getSecondNumber()
                        + View.DOT_SIGN + " " + View.BE_CAREFUL);
            }
            attempts++;
            //model.validateTheInput(scanner);
            model.validateInput(scanner);
            next = scanner.nextInt();
            listOfAllNumbers.add(next);
        }
        // If guessed!
        view.printMessage(View.GUESSED);
        view.printMessage(View.OUTPUT_STATISTIC);
        view.printMessage(View.NUMBER_OF_ATTEMPTS + attempts + View.SEMICOLON_SIGN);
        view.printMessage(View.USED_RANGE + model.getFirstNumber() + View.DASH_SIGN + model.getSecondNumber());
        view.printMessage(View.RANDOM_NUMBER + randomNumber + View.SEMICOLON_SIGN);
        view.printMessage(View.ENTERED_NUMBERS + listOfAllNumbers + View.DOT_SIGN);
    }
}
