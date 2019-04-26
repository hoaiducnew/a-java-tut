package chapter03.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {

  public static void main(String[] args) {

    final int ROWS = 10000;
    final int NUMBERS = 1000;
    final int SEARCH = 5;
    final int PARTICIPANTS = 5;
    final int LINES_PARTICIPANT = 2000;
    MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);

    Results results = new Results(ROWS);

    Grouper grouper = new Grouper(results);

    // Creates the CyclicBarrier object. It has 5 participants and, when
    // they finish, the CyclicBarrier will execute the grouper object
    CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

    // Creates, initializes and starts 5 Searcher objects
    Searcher searchers[] = new Searcher[PARTICIPANTS];
    for (int i = 0; i < PARTICIPANTS; i++) {
      searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i + 1) * LINES_PARTICIPANT, mock, results, 5, barrier);
      Thread thread = new Thread(searchers[i]);
      thread.start();
    }
    System.out.printf("Main: The main thread has finished.\n");
  }
}
