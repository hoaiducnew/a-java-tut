package chapter04.threadexecutors03firstresult;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This class implement a simulation of a user validation system. It suspend the Thread a random
 * period of time and then returns a random boolean value. We consider that it returns the true
 * value when the user is validated and the false value when it's not
 */
public class UserValidator {

  private final String name;

  public UserValidator(String name) {
    this.name = name;
  }

  public boolean validate(String name, String password) {
    // Create a new Random objects generator
    Random random = new Random();

    // Sleep the thread during a random period of time
    try {
      Long duration = (long) (Math.random() * 10);
      System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
      TimeUnit.SECONDS.sleep(duration);
    } catch (InterruptedException e) {
      return false;
    }

    // Return a random boolean value
    return random.nextBoolean();
  }

  public String getName() {
    return name;
  }

}
