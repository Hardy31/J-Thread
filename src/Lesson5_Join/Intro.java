package Lesson5_Join;

public class Intro {
        public static void main(String[] args) {
        new Intro().doCounter();
    }

    private void doCounter() {
        System.out.println("doCounter ");
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("tr1");
                System.out.println("Thread 1 "+ Thread.currentThread().getName());
            }
        });

        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("tr2");
                System.out.println("Thread 2 sleep "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tr1.start();
        tr2.start();

        try {
            tr1.join();     //Ожидание завершения потока TR1
            System.out.println("Эта сторка Всегда после -  Thread 1 tr1");
            tr2.join();     //Ожидание завершения потока TR2

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Last string");

    }


}
