package com.testing.tasks.notebook;

public class Run {

    public static void main(String[] args) throws ExtraInformationException {
        Controller controller = new Controller(new Model(), new View());
        controller.userProcess();
    }
}
