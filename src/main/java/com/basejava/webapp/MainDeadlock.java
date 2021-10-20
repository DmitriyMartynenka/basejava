package com.basejava.webapp;

public class MainDeadlock {
    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (object1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printInfo("object1");
                synchronized (object2) {
                    printInfo("object2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printInfo("object2");
                synchronized (object1) {
                    printInfo("object1");
                }
            }
        }).start();
    }

    private static void printInfo(String s) {
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + "," + s + " lock");
    }
}