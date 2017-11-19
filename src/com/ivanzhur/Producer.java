package com.ivanzhur;

public class Producer extends Thread {

    private Queue queue;
    private int id = -1;
    private int counter = 0;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public Producer(Queue queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            String item = id == -1 ? String.format("Message #%d", counter) : String.format("Message id %d #%d", id, counter);
            counter++;
            if (counter == Integer.MAX_VALUE) counter = 0;

            System.out.println("Putting item: " + item);

            queue.add(item);
        }
    }
}
