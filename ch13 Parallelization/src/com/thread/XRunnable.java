package com.thread;

public class XRunnable implements Runnable {

  private int lastIdUsed = 42;

  public int getLastIdUsed() {
    return ++lastIdUsed;
  }

  @Override
  public void run() {
    Thread thr = Thread.currentThread();

    System.out.println("Thread Name = "+thr.getName() + ",lastIdUsed = " + getLastIdUsed());
  }

}
