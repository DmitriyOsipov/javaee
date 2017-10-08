package com.threading.task1.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread implements Runnable {

  private static AtomicInteger turn = new AtomicInteger(1);

  private Counter counter;
  private int id;
  private int next;

  public CounterThread(Counter counter, int id, int threadsCount) {
    this.counter = counter;
    this.id = id;
    this.next = (id % threadsCount) + 1;
  }

  @Override
  public void run() {
    while (!counter.isStopped()) {
      if (turn.get() == this.id) {
        counter.increment();
        System.out.println(String.format("%d - thread: %s", counter.getValue(),
            Thread.currentThread().getName()));
        turn.set(next);
      } else {
        try {
          Thread.sleep(10);
        } catch (InterruptedException exc) {
          exc.printStackTrace();
        }
      }
    }
  }
}
