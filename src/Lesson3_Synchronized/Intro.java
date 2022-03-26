package Lesson3_Synchronized;

public class Intro {
    int  count = 0;
    Object monitor = new Object();
    public static void main(String[] args) {
        Intro intro = new Intro();

        intro.noCounter();


        System.out.println( "count end  "+ intro.count);
    }

    //критическая секция!!!!
    private  void increment(){
        synchronized (this){
            count++;
        }
    }

    //критическая секция!!!!
    private synchronized void increment1(){
        count++;
    }

   private void noCounter(){
        Thread tr1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000000; i++){

                    increment();
                }
                    

            }


        });
       Thread tr2 = new Thread(new Runnable() {
           @Override
           public void run() {
               for(int i = 0; i < 1000000; i++){

                   increment1();
               }


           }


       });

       tr1.start();
       tr2.start();
       while (tr1.isAlive() || tr2.isAlive()){
           try {
               Thread.sleep(10);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println( "count "+ count);
       }


       System.out.println( "count "+ count);
   }
}
