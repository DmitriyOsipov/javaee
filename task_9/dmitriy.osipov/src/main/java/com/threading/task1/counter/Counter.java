package com.threading.task1.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

  private AtomicInteger value;

  public Counter(int initValue) {
    value = new AtomicInteger(initValue);
  }

  public int getValue() {
    return value.get();
  }

  public int increment() {
    return value.incrementAndGet();
  }
}
