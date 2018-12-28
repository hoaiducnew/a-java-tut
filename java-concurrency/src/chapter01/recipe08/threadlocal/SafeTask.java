package chapter01.recipe08.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {

  private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
    protected Date initialValue() {
      return new Date();
    }
  };

  @Override
  public void run() {
    System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(),
        startDate.get());

    try {
      TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(),
        startDate.get());
  }

  public static void main(String[] args) throws InterruptedException {

    SafeTask task = new SafeTask();

    for (int i = 0; i < 2 * Runtime.getRuntime().availableProcessors(); i++) {
      Thread thread = new Thread(task);
      thread.start();
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
