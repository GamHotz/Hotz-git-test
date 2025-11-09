public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        MyCall c2 = new MyCall();
        Thread thread = new Thread(c2);
        Thread thread1 = new Thread(c2);
        thread.start();
        thread1.start();
    }




}
class MyCall implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ", result:" + i);
            }

        }
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ", result:" + i);
            }
        }
    }
}
