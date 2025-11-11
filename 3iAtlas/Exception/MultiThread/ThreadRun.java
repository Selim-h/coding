package Exception.MultiThread;
class MyThread implements Runnable {
    public void run() {
        System.out.println("Thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(), "Thread A");
        Thread t2 = new Thread(new MyThread(), "Thread B");

        t1.start();
        t2.start();
    }
}

