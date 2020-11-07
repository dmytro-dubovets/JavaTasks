package com.testing.tasks;

public class Run {

    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.userProcess();
    }
}
