package com.client;

public class ThreadTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Thread thr = Thread.currentThread();
    System.out.println("�ثe������W�١G"+thr.getName());
    thr.setName("t1");
    System.out.println("�ثe������W�١G"+thr.getName());
  }

}
