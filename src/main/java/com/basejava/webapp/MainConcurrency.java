package com.basejava.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {

    private static int counter;
    private static final Object LOCK = new Object();
    private static final int THREAD_NUMBER = 10000;

    public static void main(String[] args) throws InterruptedException {

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREAD_NUMBER);
        for (int i = 0; i < THREAD_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    inc();
                }
            });
            thread.start();
            threads.add(thread);
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(counter);
    }

    private synchronized static void inc() {
        counter++;
    }
}