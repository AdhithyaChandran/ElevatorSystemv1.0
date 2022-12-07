package main.java.sg.dlt.elevator.component;

import main.java.sg.dlt.elevator.operations.CarOperations;
import main.java.sg.dlt.elevator.request.InternalRequest;

import java.util.List;

public class Car {

    public static int CURRENTFLOOR = 3;
    private int currentfloor;

    public int getCurrentfloor() {
        return this.currentfloor;
    }

    public void setCurrentfloor(int currentfloor) {
        this.currentfloor = currentfloor;
    }



    public void decideFloor(List<InternalRequest> internalRequests){
        CarOperations carOperations = new CarOperations();
        carOperations.decidefloor(internalRequests);
    }
}
