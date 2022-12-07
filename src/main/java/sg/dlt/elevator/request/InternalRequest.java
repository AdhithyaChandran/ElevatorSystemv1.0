package main.java.sg.dlt.elevator.request;

public class InternalRequest {
    private int sourcefloor;
    private int destinationFloor;
    private int timestamp;

    public int getSourcefloor() {
        return sourcefloor;
    }

    public void setSourcefloor(int sourcefloor) {
        this.sourcefloor = sourcefloor;
    }

    public InternalRequest(int sourcefloor, int destinationFloor, int timestamp) {
        this.sourcefloor = sourcefloor;
        this.destinationFloor = destinationFloor;
        this.timestamp = timestamp;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }


}
