package chapter01.recipe09.group;

import java.util.Random;

public class MyThreadGroup extends ThreadGroup {

  public MyThreadGroup(String name) {
    super(name);
  }

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.out.printf("The thread %s has thrown an Exception\n", t.getId());
    e.printStackTrace(System.out);

    System.out.printf("Terminating the rest of the Threads\n");
    interrupt();
  }

  public static void main(String[] args) {

    int numberOfThreads = 2 * Runtime.getRuntime().availableProcessors();

    MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");

    Task task = new Task();

    for (int i = 0; i < numberOfThreads; i++) {
      Thread t = new Thread(threadGroup, task);
      t.start();
    }

    System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
    System.out.printf("Information about the Thread Group\n");
    threadGroup.list();

    Thread[] threads = new Thread[threadGroup.activeCount()];
    threadGroup.enumerate(threads);
    for (int i = 0; i < threadGroup.activeCount(); i++) {
      System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
    }

  }
}


class Task implements Runnable {

  @Override
  public void run() {
    Random random = new Random(Thread.currentThread().getId());
    while (true) {
      // Generate a random number and calculate 1000000000 divide by that random number
      int result = 1000 / ((int) (random.nextDouble() * 1000000000));

      // Check if the Thread has been interrupted
      if (Thread.currentThread().isInterrupted()) {
        System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
        return;
      }
    }
  }
}
