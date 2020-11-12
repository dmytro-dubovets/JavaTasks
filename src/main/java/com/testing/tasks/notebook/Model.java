package com.testing.tasks.notebook;

import java.util.List;
import java.util.Scanner;

public class Model {

    public static final String LASTNAME_REGEX = "^[a-zA-Z]{1,20}$";
    public static final String FIRSTNAME_REGEX = "^[a-zA-Z]{1,20}$";
    public static final String SURNAME_REGEX = "^[a-zA-Z]{1,20}$";
    public static final String NICKNAME_REGEX = "\\w+{20}";
    public static final String MOBILE_PHONE_REGEX = "\\d{10}";
    public static final String EMAIL_REGEX = "\\w+@\\w+[.]\\w+";

    public String inputRegex(Scanner scanner, String regex) {
        String result = null;
        String next;
        while (scanner.hasNext()) {
            next = scanner.nextLine();
            if (next.matches(regex)) {
                result = next;
                break;
            } else {
                View.printMessage(View.TRY_AGAIN);
            }
        }
        return result;
    }

    public void storeInfo(List<String> listOfInfo, String info) {
        listOfInfo.add(info);
    }

    public List<String> getInfo(List<String> listOfInfo) {
        return listOfInfo;
    }

    public String getLastnameFirstnameSurname(List<String> listOfInfo) {
        return listOfInfo.get(0) + " " + listOfInfo.get(1).charAt(0) + ".";
    }
}
