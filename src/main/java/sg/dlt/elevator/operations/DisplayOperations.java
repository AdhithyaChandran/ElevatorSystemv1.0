package main.java.sg.dlt.elevator.operations;

import main.java.sg.dlt.elevator.component.Car;

public class DisplayOperations {
    public void displayCurrentLevel() {
        //display direction and floornumber
        System.out.println("Source Level :"+Car.CURRENTFLOOR);
    }
}
