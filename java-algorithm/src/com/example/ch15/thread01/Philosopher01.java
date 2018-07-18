package com.example.ch15.thread01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher01 {

  public static void main(String[] args) {
    System.out.println("------Start------");
    Chopstick left = new Chopstick();
    Chopstick right = new Chopstick();

    Philosopher p1 = new Philosopher(left, right);
    Philosopher p2 = new Philosopher(left, right);
    Philosopher p3 = new Philosopher(left, right);
    Philosopher p4 = new Philosopher(left, right);
    Philosopher p5 = new Philosopher(left, right);
    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
  }
}


class Chopstick {
  private Lock lock;

  public Chopstick() {
    lock = new ReentrantLock();
  }

  public void pickUp() {
    lock.lock();
  }

  public void putDown() {
    lock.unlock();
  }
}


class Philosopher extends Thread {
  private int bites = 10;
  private Chopstick left, right;

  public Philosopher(Chopstick left, Chopstick right) {
    this.left = left;
    this.right = right;
  }

  public void eat() {
    pickUp();
    chew();
    putDown();
  }

  public void pickUp() {
    left.pickUp();
    right.pickUp();
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
