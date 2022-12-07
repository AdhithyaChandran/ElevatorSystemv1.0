package main.java.sg.dlt.elevator.component;

import main.java.sg.dlt.elevator.operations.processrequestqueue.PrioritisedQueue;
import main.java.sg.dlt.elevator.request.InternalRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processor {
    public List<InternalRequest> getRequests(Car car){
        System.out.println("Enter destination floors ,Enter -1 as end of inputs");
        Scanner sc = new Scanner(System.in);
        List<InternalRequest> internalRequests = new ArrayList();
        boolean inputFlag = true;
        int destinationfloor;
        while(inputFlag)
        {
            destinationfloor = sc.nextInt();
            if(destinationfloor == -1)
                inputFlag = false;
            else{
                InternalRequest internalRequest = new InternalRequest(car.getCurrentfloor(), destinationfloor, (int) System.nanoTime());
                internalRequests.add(internalRequest);
            }

        }
        return internalRequests;
    }

    public PrioritisedQueue assignPriority(List<InternalRequest> internalRequests) {
        PrioritisedQueue prioritisedQueue = getPrioritisedRequest(internalRequests);
        return prioritisedQueue;
    }

    public PrioritisedQueue getPrioritisedRequest(List<InternalRequest> internalRequests) {
        PrioritisedQueue prioritisedQueue = new PrioritisedQueue(internalRequests.size());
        for (InternalRequest internalRequest: internalRequests) {
            prioritisedQueue.insert(internalRequest.getDestinationFloor(), internalRequest.getDestinationFloor() - internalRequest.getSourcefloor() , internalRequest.getSourcefloor());
        }
        return prioritisedQueue;
    }
}
