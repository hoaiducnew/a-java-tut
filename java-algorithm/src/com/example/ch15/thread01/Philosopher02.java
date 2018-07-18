package com.example.ch15.thread01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// All or Nothing
public class Philosopher02 {

  public static void main(String[] args) {
    System.out.println("------Start------");
    Chopstick2 left = new Chopstick2();
    Chopstick2 right = new Chopstick2();

    Philosopher2 p1 = new Philosopher2(left, right);
    Philosopher2 p2 = new Philosopher2(left, right);
    Philosopher2 p3 = new Philosopher2(left, right);
    Philosopher2 p4 = new Philosopher2(left, right);
    Philosopher2 p5 = new Philosopher2(left, right);
    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
  }
}


class Chopstick2 {
  private Lock lock;

  public Chopstick2() {
    lock = new ReentrantLock();
  }

  public boolean pickUp() {
    return lock.tryLock();
  }

  public void putDown() {
    lock.unlock();
  }
}


class Philosopher2 extends Thread {
  private int bites = 10;
  private Chopstick2 left, right;

  public Philosopher2(Chopstick2 left, Chopstick2 right) {
    this.left = left;
    this.right = right;
  }

  public void eat() {
    if (pickUp()) {
      chew();
      putDown();
    }
  }

  public boolean pickUp() {
    if (!left.pickUp()) {
      return false;
    }

    if (!right.pickUp()) {
      left.putDown();
      return false;
    }

    return true;
  }

  public void chew() {}

  public void putDown() {
    right.putDown();
    left.putDown();
  }

  public void run() {
    for (int i = 0; i < bites; i++) {
      eat();
    }
  }
}
