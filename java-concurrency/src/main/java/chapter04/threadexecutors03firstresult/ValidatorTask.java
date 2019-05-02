package chapter04.threadexecutors03firstresult;

import java.util.concurrent.Callable;

/**
 * This class encapsulate a user validation system to be executed as a Callable object. If the user
 * is validated, it returns the name of the validation system. If not, it throws an Exception
 */
public class ValidatorTask implements Callable<String> {

  private final UserValidator validator;
  private final String user;
  private final String password;

  public ValidatorTask(UserValidator validator, String user, String password) {
    this.validator = validator;
    this.user = user;
    this.password = password;
  }

  /**
   * Core method of the Callable interface. Tries to validate the user using the user validation
   * system. If the user is validated, returns the name of the validation system. If not, throws and
   * Exception
   */
  @Override
  public String call() throws Exception {
    if (!validator.validate(user, password)) {
      System.out.printf("%s: The user has not been found\n", validator.getName());
      throw new Exception("Error validating user");
    }
    System.out.printf("%s: The user has been found\n", validator.getName());
    return validator.getName();
  }
}
