package Lesson2_Volatile;

public class Intro {

    int count = 0;
//    volatile int  count = 0;
//    AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Intro intro = new Intro();
        System.out.println("count Zero = " + intro.count);
        intro.doCounter();


    }
    synchronized void  increment(){
        count++;
    }

    public void doCounter() {
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000; i++){
//                            count++;
//                            count.incrementAndGet();
                            increment();
                        }
                        System.out.println("count from thread 1 = " + count);
                    }
                }
        );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 1000000; i++){
//                            count++;
//                            count.incrementAndGet();
                            increment();
                        }
                        System.out.println("count from thread 2 = " + count);
                    }
                }
        );
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("count = " + count);

    }
}
