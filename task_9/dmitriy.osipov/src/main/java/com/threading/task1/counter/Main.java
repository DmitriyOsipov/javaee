package com.threading.task1.counter;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    Counter counter = new Counter(0);
    int border = 100;
    int threadsCount = 3;

    for (int ind = 0; ind < threadsCount; ind++) {
      Thread thread = new Thread(new CounterThread(counter, border));
      thread.setName("Thread " + ind);
      thread.start();
      Thread.sleep(50);
    }
  }
}
