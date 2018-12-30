package com.thread;

public class XRunnableTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    XRunnable xObj = new XRunnable();
    
    Thread t1 = new Thread(xObj,"t1");
    Thread t2 = new Thread(xObj,"t2");
    
    t1.start();
    t2.start();
  } // end main

}
