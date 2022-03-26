package Lesson4_WaitNotify;

public class Intro {
    int count = 0;
    Lock lock = new Lock();


    public static void main(String[] args) {

        new Intro().doCounter();

    }
    private void increment(){
        try {
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        lock.unLock();
    }

    private void doCounter() {
        System.out.println("doCounter ");
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("counter 1 "+ count);
                for (int i=0; i < 1000000; i++){
                    increment();
                }
                System.out.println("counter 1 "+ count);

            }
        });

        Thread tr2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 1000000; i++){
                    increment();
                }
                System.out.println("counter 2 "+ count);

            }
        });
        tr1.start();
        tr2.start();

    }
    public class Lock {
        private boolean isLocked = false;

        void lock() throws InterruptedException {
            synchronized (this){
                while (isLocked){
                        wait(0);
                }
                isLocked = true;
            }
        }
        void unLock(){
            synchronized (this){
                isLocked = false;
                notify();
            }

        }

    }

}
