package org.hagiakinh.thread;

public class ThreadDemo {

    public static void main(String[] args) {
        // Creating thread
        Thread thread1 = new Thread();
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("Thread Running");
            }
        };
        Thread thread3 = new MyThread();

        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new Runnable() {
            public void run() {
                System.out.println("Runnable running");
            }
        };
        Runnable runnable3 = () -> System.out.println("Lambda Runnable running");

        Thread thread4 = new Thread(runnable1);
        Thread thread5 = new Thread(runnable2);
        Thread thread6 = new Thread(runnable3);

        // start thread
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}


class MyThread extends Thread {

    public void run() {
        System.out.println("run by: " + getName());
    }
}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("MyRunnable running");
    }
}