package com.ivanzhur;

public class ItemLoss {

    public static void main(String[] args) {
        Queue queue = new QueueItemLoss();
        Producer producer1 = new Producer(queue, 1);
        Producer producer2 = new Producer(queue, 2);
        Consumer consumer = new Consumer(queue);

        producer1.start();
        consumer.start();
        new Consumer(queue).start();
    }
}
