package com.ivanzhur;

import java.util.LinkedList;

public class QueueDeadlock extends Queue {

    private static final int MAX_SIZE = 5;
    private java.util.Queue<String> items;

    public QueueDeadlock() {
        items = new LinkedList<>();
    }

    @Override
    public void add(String item) {
        while (items.size() == MAX_SIZE) {
            synchronized (this) {
                try {
                    System.out.println("Producer waiting");
                    wait();
                } catch (Exception ex) {
                }
            }
        }

        items.add(item);
        try {
            notifyAll();
        }
        catch (Exception ex) {

        }
    }

    @Override
    public String take() {
        while (items.size() == 0) {
            synchronized (this) {
                try {
                    System.out.println("Consumer waiting");
                    wait();
                } catch (Exception ex) {
                }
            }
        }

        String item = items.remove();
        try {
            notifyAll();
        }
        catch (Exception ex) {

        }
        return item;
    }
}
