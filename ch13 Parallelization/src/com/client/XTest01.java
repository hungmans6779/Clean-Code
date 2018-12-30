package com.client;

import com.thread.X;

public class XTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    X xObj = new X();
    
    Thread t1 = new Thread(xObj,"t1");
    Thread t2 = new Thread(xObj,"t2");
    
    System.out.println("t1 before isAlive = "+t1.isAlive());
    System.out.println("t2 before isAlive = "+t2.isAlive());
    
    t1.start();
    t2.start();
    
    System.out.println("t1 after isAlive = "+t1.isAlive());
    System.out.println("t2 after isAlive = "+t2.isAlive());
    
  } // end main

}
