package com.ivanzhur;

import java.util.LinkedList;

public class QueueItemLoss extends Queue {

    private int MAX_SIZE = 5;
    private java.util.Queue<String> items;

    public QueueItemLoss() {
        items = new LinkedList<>();
    }

    @Override
    public void add(String item) {
        synchronized (this) {
            while (items.size() == MAX_SIZE) {
                try {
                    System.out.println("Producer waiting");
                    wait();
                } catch (Exception ex) {
                }
            }

            items.add(item);
            try {
                notifyAll();
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public String take() {
        String item = null;

        synchronized (this) {
            while (items.size() == 0) {
                try {
                    System.out.println("Consumer waiting");
                    wait();
                } catch (Exception ex) {
                }
            }
        }

        item = items.remove();

        synchronized (this) {
            try {
                notifyAll();
            } catch (Exception ex) {
            }
            return item;
        }
    }
}
