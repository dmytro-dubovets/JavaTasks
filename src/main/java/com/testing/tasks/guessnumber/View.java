package com.testing.tasks.guessnumber;

public class View {
    public static final String SEMICOLON_SIGN = ";";
    public static final String DOT_SIGN = ".";
    public static final String DASH_SIGN = " - ";
    public static final String INPUT_INT_VALUE = "Guess the number!";
    public static final String INPUT_NOT_INTEGER = "Enter the integer number!";
    public static final String INPUT_VALUE_IS_GREATER = "The entered number is greater than random number!";
    public static final String INPUT_VALUE_IS_LESS = "The entered number is less than random number";
    public static final String INPUT_NOT_EQUALS_TO_RANDOM_NUMBER = "Try again!";
    public static final String ADDITIONAL_INFO = "(if you do not guess, you'll be guessing from previously entered numbers!)";
    public static final String NEW_RANGE = "You have new range";
    public static final String GUESSED = "You guessed!";
    public static final String OUTPUT_STATISTIC = "There is next statistic: ";
    public static final String NUMBER_OF_ATTEMPTS = "- used attempts: ";
    public static final String USED_RANGE = "- range was: ";
    public static final String RANDOM_NUMBER = "- random number was: ";
    public static final String ENTERED_NUMBERS = "- entered numbers: ";
    public static final String FROM = " from ";
    public static final String TO = " to ";
    public static final String BE_CAREFUL = "Be careful!";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }

    public void printNewLine() {
        System.out.println();
    }

}
