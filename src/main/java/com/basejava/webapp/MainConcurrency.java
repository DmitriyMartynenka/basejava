package com.basejava.webapp;

public class MainConcurrency {

    private static final Object one = new Object();
    private static final Object two = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (one) {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " , object1 lock");
                synchronized (two) {
                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " , object2 lock");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (two) {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " , object2 lock");
                synchronized (one) {
                    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState() + " , object1 lock");
                }
            }
        }).start();
    }
}
