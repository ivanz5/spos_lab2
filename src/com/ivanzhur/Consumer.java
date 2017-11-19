package com.ivanzhur;

import java.util.HashSet;

public class Consumer extends Thread {

    private Queue queue;

    private int counterId1 = 0;
    private int counterId2 = 0;

    private static int counterAll = 0;
    private static HashSet<Integer> ids = new HashSet<>();

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String item = queue.take();
            System.out.println("Consumed item: " + item);

            /*if (item.contains("id ")) {
                int startIdPos = item.indexOf("id ") + 3;
                int endIdPos = item.indexOf(" #");
                String idStr = item.substring(startIdPos, endIdPos);
                int id = Integer.valueOf(idStr);
                String nStr = item.substring(endIdPos + 2, item.length());
                int n = Integer.valueOf(nStr);

                if (id == 1) {
                    if (n != counterId1) throw new RuntimeException(String.format("Item id 1 #%d lost", counterId1));
                    else counterId1++;
                }
                else if (id == 2) {
                    if (n != counterId2) throw new RuntimeException(String.format("Item id 2 #%d lost", counterId2));
                    else counterId2++;
                }
            }*/
            if (item.contains("id ")) {
                int startIdPos = item.indexOf("id ") + 3;
                int endIdPos = item.indexOf(" #");
                String idStr = item.substring(startIdPos, endIdPos);
                int id = Integer.valueOf(idStr);
                String nStr = item.substring(endIdPos + 2, item.length());
                int n = Integer.valueOf(nStr);

                /*if (n != counterAll) throw new RuntimeException(String.format("Item id 1 #%d lost", counterAll));
                else counterAll++;*/

                if (ids.contains(n)) throw new RuntimeException(String.format("Id #%d found second time", n));
                else ids.add(n);
            }
        }
    }
}
