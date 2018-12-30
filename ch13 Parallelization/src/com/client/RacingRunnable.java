package com.client;

import com.thread.HorseRunnable;

public class RacingRunnable {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    HorseRunnable hObj = new HorseRunnable();
    Thread t1 = new Thread(hObj,"t1");
    Thread t2 = new Thread(hObj,"t2");
    t1.start();
    t2.start();
    
    Thread now = Thread.currentThread();
    for(int j = 1 ;j <= 5000 ;j++){
      System.out.println(now.getName()+":"+j);
    } // end for(int j = 1 ;j <= 5000 ;j++){
    
  } // end main

}
