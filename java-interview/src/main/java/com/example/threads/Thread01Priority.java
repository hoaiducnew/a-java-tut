package com.example.threads;

public class Thread01Priority {
  public static void main(String[] args) throws InterruptedException {
    // Each thread in Java is assigned a default Priority 5. This priority
    // can be increased or decreased (Range 1 to 10).
    // If two threads are waiting, the scheduler picks the thread with
    // highest priority to be run. If all threads have equal priority, the
    // scheduler then picks one of them randomly. Design programs so that
    // they don't depend on priority.

    // Consider the thread example declared below:
    class ThreadExample extends Thread {
      private String name;
      
      public ThreadExample(String name) {
        this.name = name;
      }
      
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.println(name + " Running " + i);
        }
      }
    }

    // Priority of thread can be changed by invoking setPriority method on the thread.
    ThreadExample thread1 = new ThreadExample("Thread 1");
    thread1.setPriority(8);
    thread1.setPriority(Thread.MAX_PRIORITY);   // 10
    thread1.setPriority(Thread.MIN_PRIORITY);   // 1
    thread1.setPriority(Thread.NORM_PRIORITY);   // 5

    // Thread Join method
    // Join method is an instance method on the Thread class. Let's see a
    // small example to understand what join method does.

    // Lets consider the thread's declared below : thread2, thread3, thread4

    ThreadExample thread2 = new ThreadExample("Thread 2");
    ThreadExample thread3 = new ThreadExample("Thread 3");
    ThreadExample thread4 = new ThreadExample("Thread 4");

    // We would want to run thread2 and thread3 in parallel but thread4 can
    // only run when thread3 is finished. This can be achieved using join
    // method. Look at the example code below.
    thread2.start();
    thread3.start();
    thread3.join();// wait for thread 3 to complete
    System.out.println("Thread3 is completed.");
    thread4.start();

    // thread3.join() method call force the execution of main method to stop
    // until thread3 completes execution. After that, thread4.start() method
    // is invoked, putting thread4 into a Runnable State.

    // Join method also has an overloaded method accepting time in
    // milliseconds as a parameter.
    // In below example, main method thread would wait for 2000 ms or the
    // end of execution of thread4, whichever is minimum.
    thread4.join(2000);
    ThreadExample thread5 = new ThreadExample("Thread 5");
    thread5.start();

    // Thread yield method
    // Yield is a static method in the Thread class. It is like a thread
    // saying
    // " I have enough time in the limelight. Can some other thread run next?".
    // A call to yield method changes the state of thread from RUNNING to
    // RUNNABLE. However, the scheduler might pick up the same thread to run
    // again, especially if it is the thread with highest priority.
    // Summary is yield method is a request from a thread to go to Runnable
    // state. However, the scheduler can immediately put the thread back to
    // RUNNING state.

    // Thread sleep method
    // sleep is a static method in Thread class. sleep method can throw a
    // InterruptedException. sleep method causes the thread in execution to
    // go to sleep for specified number of milliseconds.
  }

}
