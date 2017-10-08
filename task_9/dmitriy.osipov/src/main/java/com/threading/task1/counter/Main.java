package com.threading.task1.counter;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    int border = 100;
    int threadsCount = 3;
    Counter counter = new Counter(0, border);

    for (int ind = 1; ind <= threadsCount; ind++) {
      Thread thread = new Thread(new CounterThread(counter, ind, threadsCount));
      thread.setName("Thread " + ind);
      thread.start();
    }
  }
}
