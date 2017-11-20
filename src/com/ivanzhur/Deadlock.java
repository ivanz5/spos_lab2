package com.ivanzhur;

public class Deadlock {

    public static void main(String[] args) {
        Queue queue = new QueueDeadlock();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        consumer.start();
        producer.start();

        try {
            producer.join();
            consumer.join();
        }
        catch (InterruptedException ex) {
        }
    }
}
