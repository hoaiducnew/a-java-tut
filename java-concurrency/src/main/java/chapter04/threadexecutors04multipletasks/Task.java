package chapter04.threadexecutors04multipletasks;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {

  private final String name;

  public Task(String name) {
    this.name = name;
  }

  @Override
  public Result call() throws Exception {
    // Writes a message to the console
    System.out.printf("%s: Staring\n", this.name);

    // Waits during a random period of time
    try {
      Long duration = (long) (Math.random() * 10);
      System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Calculates the sum of five random numbers
    int value = 0;
    for (int i = 0; i < 5; i++) {
      value += (int) (Math.random() * 100);

    }

    // Creates the object with the results
    Result result = new Result();
    result.setName(this.name);
    result.setValue(value);
    System.out.printf("%s: Ends\n", this.name);

    // Returns the result object
    return result;
  }

}
