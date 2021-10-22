package com.basejava.webapp;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainConcurrency {

    //    private static int counter;
//    private static final Object LOCK = new Object();
    private static final int THREAD_NUMBER = 10000;
    private static AtomicInteger atomicCounter = new AtomicInteger();
    //    private static final Lock lock = new ReentrantLock();
    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(SimpleDateFormat::new);

    public static void main(String[] args) throws InterruptedException {

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREAD_NUMBER);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        List<Thread> threads = new ArrayList<>(THREAD_NUMBER);
        for (int i = 0; i < THREAD_NUMBER; i++) {
            Future<Integer> future = executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    inc();
//                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });

        }

        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
//        threads.forEach(thread -> {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        System.out.println(atomicCounter);
    }

    private static void inc() {
//        lock.lock();
//        try {
//            counter++;
//        }
//        finally {
//            lock.unlock();
//        }
        atomicCounter.incrementAndGet();
    }
}