package main.java.sg.dlt.elevator;


import main.java.sg.dlt.elevator.component.Car;
import main.java.sg.dlt.elevator.component.Processor;
import main.java.sg.dlt.elevator.request.InternalRequest;

import java.util.List;
import java.util.Scanner;

public class Elevator {
    public int getSourceLevel() {
        return sourceLevel;
    }

    public void setSourceLevel(int sourceLevel) {
        this.sourceLevel = sourceLevel;
    }

    private int sourceLevel;

    public static int SOURCE_LEVEL=0;

    public Elevator(int sourceLevel) {
        this.sourceLevel = sourceLevel;
    }
    public Elevator() {
        this.sourceLevel = 0;
    }

    public void start(){
        Car car = new Car();
        System.out.println("<<ELEVATOR STARTS>>\n At Level "+SOURCE_LEVEL+"\nReceived External Request \n"+"Reached at Requested floor "+ Car.CURRENTFLOOR);
        Processor processor = new Processor();
        List<InternalRequest> internalRequests = processor.getRequests(car);
        car.decideFloor(internalRequests);


    }


}
