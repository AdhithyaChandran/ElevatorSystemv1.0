package test.java.sg.dlt.elevator;

import main.java.sg.dlt.elevator.Elevator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        requestProcessor();
    }
    public static void requestProcessor() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++) {
            scheduler.schedule(new StartElevator(), 5, TimeUnit.SECONDS);
        }
        scheduler.shutdown();

    }

    static class StartElevator implements Runnable {
        @Override
        public void run() {
            Elevator elevator = new Elevator();
            elevator.start();
        }
    }
}