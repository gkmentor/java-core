package org.hagiakinh.thread.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {

    public static Integer count = 1;

    public static void main(String[] args) {
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();
        Thread thread4 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(count);
    }

    public static synchronized void increase() {
        count++;
    }

    static class MyThread extends Thread {

        public void count() {
            for (int i = 0; i < 1000; i++) {
                increase();
            }
        }

        @Override
        public void run() {
            count();
        }
    }
}
