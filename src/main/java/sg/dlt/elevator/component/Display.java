package main.java.sg.dlt.elevator.component;

import main.java.sg.dlt.elevator.operations.DisplayOperations;

public class Display {
    public void displayLevel(){
        DisplayOperations displayOperations = new DisplayOperations();
        displayOperations.displayCurrentLevel();
    }
}
