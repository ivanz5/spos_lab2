package com.ivanzhur;

public class Deadlock {

    public static void main(String[] args) {
        Queue queue = new QueueDeadlock();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {

        }
        consumer.start();
    }
}
