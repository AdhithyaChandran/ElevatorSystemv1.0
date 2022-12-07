package main.java.sg.dlt.elevator.operations.processrequestqueue;

public class PrioritisedQueue {
    private Request[] heap;
    private int heapSize, capacity;


    /**
     * Constructor
     **/
    public PrioritisedQueue(int capacity) {
        this.capacity = capacity + 1;
        heap = new Request[this.capacity];
        heapSize = 0;
    }
    public boolean isEmpty() {
        return heapSize == 0;
    }

    /**
     * function to insert task
     **/
    public void insert(int level, int range, int sourceLevel) {
        Request newJob = new Request(level, range, sourceLevel);

        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && newJob.range > heap[pos / 2].range) {
            heap[pos] = heap[pos / 2];
            pos /= 2;
        }
        heap[pos] = newJob;
    }

    public void displayQueue() {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(heap[i] + ",");
        }
    }

    /**
     * function to remove task
     **/
    public Request remove() {
        int parent, child;
        Request item, temp;
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        item = heap[heapSize--];
        temp = heap[1];

        parent = 1;
        child = 2;
        while (child <= heapSize) {

            if (child < heapSize && heap[child].range < heap[child + 1].range)
                child++;
            if (temp.range >= heap[child].range)
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;

        }
        heap[parent] = temp;

        return item;
    }

    public int size() {
        return heapSize;
    }

}