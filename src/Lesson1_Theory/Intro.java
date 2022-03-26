package Lesson1_Theory;

public class Intro {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new A());
        System.out.println("Перед сном");
        Thread.sleep(10000);
        System.out.println("Cтартуем треад");
        thread.start();
        System.out.println("thread запущен");

    }
}

class A implements Runnable {
    @Override
    public void run(){
        System.out.println("А.run() ");
    }
}
