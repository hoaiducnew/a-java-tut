package chapter02.recipe05;

/**
 * This class gets lines from the simulate file and stores them in the buffer, if there is space in
 * it.
 *
 */
public class Producer implements Runnable {

  private FileMock mock;
  private Buffer buffer;

  public Producer(FileMock mock, Buffer buffer) {
    this.mock = mock;
    this.buffer = buffer;
  }

  @Override
  public void run() {
    buffer.setPendingLines(true);
    while (mock.hasMoreLines()) {
      String line = mock.getLine();
      buffer.insert(line);
    }
    buffer.setPendingLines(false);
  }

}
