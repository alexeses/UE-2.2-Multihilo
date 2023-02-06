package com.github.alexeses;

public class Relevos {
    public static void main(String[] args) {
        final Object lock = new Object();
        final int[] turn = {1};
        Thread[] runners = new Thread[4];

        for (int i = 0; i < runners.length; i++) {
            int finalI = i;
            runners[i] = new Thread(() -> {
                synchronized (lock) {
                    try {
                        while (turn[0] != finalI + 1) {
                            lock.wait();
                        }
                        System.out.println("Runner " + (finalI + 1) + " comenzó a correr.");
                        Thread.sleep(2000);
                        System.out.println("Runner " + (finalI + 1) + " terminó de correr.");
                        turn[0]++;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (Thread runner : runners) {
            runner.start();
        }

        synchronized (lock) {
            lock.notifyAll();
        }

        for (Thread runner : runners) {
            try {
                runner.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Todos los runners han terminado de correr.");
    }
}
