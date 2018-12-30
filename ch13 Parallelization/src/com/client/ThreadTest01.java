package com.client;

public class ThreadTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Thread thr = Thread.currentThread();
    System.out.println("目前執行緒名稱："+thr.getName());
    thr.setName("t1");
    System.out.println("目前執行緒名稱："+thr.getName());
  }

}
