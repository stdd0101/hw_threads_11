import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) throws Exception {

        Runnable runnable = () -> {
            try {
                while(true) {
                    String name = Thread.currentThread().getName();
                    System.out.println("Всем привет!, я " + Thread.currentThread().getName());
                    Thread.currentThread().sleep(2000);
                }
            }
            catch (InterruptedException e) {
                return;
                //e.printStackTrace();
            } finally {
                System.out.printf("%s завершен\n", Thread.currentThread().getName());
            }
        };

        ThreadGroup mainGroup = new ThreadGroup("main group");
        Thread thread1 = new Thread(mainGroup, runnable, "Поток 1");
        Thread thread2 = new Thread(mainGroup, runnable, "Поток 2");
        Thread thread3 = new Thread(mainGroup, runnable, "Поток 3");
        Thread thread4 = new Thread(mainGroup, runnable, "Поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(10000);

        mainGroup.interrupt();
    }
}
