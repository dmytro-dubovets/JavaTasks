package com.testing.tasks;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Model {

    private int firstNumber;
    private int secondNumber;

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getRandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater or not equal than min");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public void validateInput(Scanner scanner) {
        while (scanner.hasNext()) {
            validateTheIntegerInput(scanner);
            if (scanner.hasNextInt()) {
                break;
            }
            new View().printNewLine();
            scanner.next();
        }
    }

    public void validateTheIntegerInput(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            new View().printMessageWithoutNewLine(View.INPUT_NOT_INTEGER);
        }
    }

    public List<Integer> swapFromStartedToNewRange(List<Integer> numbers, List<Integer> newRange) {
        try {
            if (numbers.get(0) > numbers.get(1)) {
                Collections.sort(numbers);
            }
            newRange.addAll(numbers);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return newRange;
    }
}
