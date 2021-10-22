package com.basejava.webapp;

public class MainDeadlock {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public static void main(String[] args) {

        threadAction(object1, object2);
        threadAction(object2, object1);
    }

    private static void threadAction(Object obj1, Object obj2) {
        new Thread(() -> {
            synchronized (obj1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printInfo(obj1);
                synchronized (obj2) {
                    printInfo(obj2);
                }
            }
        }).start();
    }

    private static void printInfo(Object object) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + ","
                + object + " lock");
    }
}