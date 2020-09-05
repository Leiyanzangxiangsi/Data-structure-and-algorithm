import com.sun.org.apache.xpath.internal.objects.XObject;

public class Threadtask1 {
    private static Object lock = new Object();

    public static class Mythread1 implements Runnable{
        @Override
        public synchronized void run(){
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static class Mythread2 implements Runnable{
        @Override
        public synchronized void run(){
            synchronized (lock){
                for (int i = 0;i < 100;i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Mythread1()).start();
        //Thread.sleep(1000);
        new Thread(new Mythread2()).start();

    }
}
