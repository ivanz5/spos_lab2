package com.ivanzhur;

public class Producer extends Thread {

    private Queue queue;
    private int counter = 0;

    private boolean stopped = false;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!stopped) {
            queue.put(counter++);
            if (counter == Integer.MAX_VALUE) counter = 0;
        }
    }

    public void stopProducer() {
        stopped = true;
    }
}
