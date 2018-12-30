package com.thread;

public class HorseRunnable implements Runnable {

  
  @Override
  public void run() {
    
    for(int i = 1; i <= 5000; i++){
      Thread t = Thread.currentThread();
      System.out.println(t.getName()+":"+i);
    } // end for(int i = 0; i <= 5000; i++){
  
  } // end run
  
}
