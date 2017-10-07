package com.threading.task1.counter;

public class CounterThread implements Runnable {

  private Counter counter;
  private int counterBorder;

  public CounterThread(Counter counter, int counterBorder) {
    this.counter = counter;
    this.counterBorder = counterBorder;
  }

  @Override
  public void run() {
    while (counter.getValue() < counterBorder) {
      counter.increment();
      System.out.println(String.format("%d - thread: %s", counter.getValue(),
          Thread.currentThread().getName()));
      try {
        Thread.sleep(100);
      } catch (InterruptedException exc) {
        exc.printStackTrace();
      }
    }
  }
}
