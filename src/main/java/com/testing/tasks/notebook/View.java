package com.testing.tasks.notebook;

public class View {

    public static final String TRY_AGAIN = "Try again!";
    public static final String INPUT_LASTNAME = "Enter your lastname: ";
    public static final String INPUT_FIRSTNAME = "Enter your firstname: ";
    public static final String INPUT_SURNAME = "Enter your surname: ";


    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printMessageWithoutNewLine(String message) {
        System.out.print(message);
    }

}
