package com.ivanzhur;

public class QueueItemLoss extends Queue {

    private int item = -1;

    @Override
    public synchronized void put(int item) {
        System.out.println("Putting item: " + item);
        this.item = item;
        notifyAll();
    }

    @Override
    public synchronized int take() {
        while (item == -1) {
            try {
                wait();
            }
            catch (InterruptedException ex){
            }
        }

        System.out.println("Taking item: " + item);

        int res = item;
        item = -1;
        return res;
    }
}
