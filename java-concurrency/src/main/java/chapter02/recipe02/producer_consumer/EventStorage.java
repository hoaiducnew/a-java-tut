package chapter02.recipe02.producer_consumer;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements an Event storage. Producers will storage events in it and Consumers will
 * process them. An event will be a java.util.Date object
 *
 */
public class EventStorage {

  private int maxSize;
  private Queue<Date> storage;

  public EventStorage() {
    maxSize = 10;
    storage = new LinkedList<>();
  }

  public synchronized void set() {
    while (storage.size() == maxSize) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    storage.add(new Date());
    System.out.printf("Set: %d\n", storage.size());
    notify();
  }

  public synchronized void get() {
    while (storage.size() == 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Date element = storage.poll();
    System.out.printf("Get: %d: %s\n", storage.size(), element);
    notify();
  }

}
