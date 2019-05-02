package chapter04.threadexecutors06periodically;

import java.util.Date;

/**
 * This class implements the task of the example. Writes a message to the console with the actual
 * date.
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
