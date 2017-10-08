package com.threading.task1.counter;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

  private AtomicInteger value;
  private AtomicBoolean stopped;
  private final int border;

  public Counter(int initValue, int border) {
    this.value = new AtomicInteger(initValue);
    this.border = border;
    this.stopped = new AtomicBoolean(false);
  }

  public int getValue() {
    return value.get();
  }

  public synchronized void increment() {
    if (!stopped.get()) {
      int current = value.incrementAndGet();
      stopped.set(current == border);
    }
  }

  public boolean isStopped() {
    return stopped.get();
  }
}
