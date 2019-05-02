package chapter04.threadexecutors05scheduled;

import java.util.Date;

/**
 * Writes a message to the console with the actual date.
 * Is used to explain the utilization of an scheduled executor to execute tasks periodically
 */
public class Task implements Runnable {

  private final String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.printf("%s: Executed at: %s\n", name, new Date());
  }
}
