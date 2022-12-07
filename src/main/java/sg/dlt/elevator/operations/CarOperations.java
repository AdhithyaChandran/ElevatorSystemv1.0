package main.java.sg.dlt.elevator.operations;

import main.java.sg.dlt.elevator.component.Car;
import main.java.sg.dlt.elevator.component.Display;
import main.java.sg.dlt.elevator.component.Processor;
import main.java.sg.dlt.elevator.operations.processrequestqueue.PrioritisedQueue;
import main.java.sg.dlt.elevator.operations.processrequestqueue.Request;
import main.java.sg.dlt.elevator.request.InternalRequest;

import java.util.List;

public class CarOperations {
    public void decidefloor(List<InternalRequest> internalRequests)//receives the list of destinationLevel and assigns  them priorities based on the difference in sourceLevel and destination level
    {
        Processor processor = new Processor();
        PrioritisedQueue prioritisedQueue = processor.assignPriority(internalRequests);//creates  a priority queue
        while (!prioritisedQueue.isEmpty()) {
            Request destinationRequest = prioritisedQueue.remove();
            System.out.println("Level : " + destinationRequest.level + " Range : " + destinationRequest.range);
            long start = System.nanoTime();
            Car.CURRENTFLOOR = moveTo(destinationRequest);
            long end = System.nanoTime();
            System.out.println("Time taken :" + (end - start) / 1000);
            System.out.println("People remaining : " + prioritisedQueue.size());
        }
    }

    int moveTo(Request destinationRequest) {
        Display display = new Display();
        if (Car.CURRENTFLOOR < destinationRequest.level) {
            while (Car.CURRENTFLOOR != destinationRequest.level) {
                Car.CURRENTFLOOR = Car.CURRENTFLOOR+ 1;
                System.out.println("-You are at : " +Car.CURRENTFLOOR);
            }
        } else {
            while (Car.CURRENTFLOOR != destinationRequest.level) {
                Car.CURRENTFLOOR = Car.CURRENTFLOOR- 1;
                System.out.println("-You are at : " + Car.CURRENTFLOOR);
            }
        }
        display.displayLevel();
        return Car.CURRENTFLOOR;
    }
}
