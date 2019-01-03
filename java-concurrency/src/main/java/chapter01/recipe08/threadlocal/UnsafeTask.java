package chapter01.recipe08.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

  private Date startDate;

  @Override
  public void run() {
    startDate = new Date();
    System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
    try {
      TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
  }

  public static void main(String[] args) throws InterruptedException {
    UnsafeTask task = new UnsafeTask();

    for (int i = 0; i < 10; i++) {
      Thread thread = new Thread(task);
      thread.start();
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
