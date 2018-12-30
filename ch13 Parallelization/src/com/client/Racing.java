package com.client;

import com.thread.Horse;

public class Racing {

  /**
   * @param args
   */
  public static void main(String[] args) {
     Horse h1 = new Horse();
     h1.start();
     
     Thread t1 = Thread.currentThread();
     for(int j = 1 ;j <=5000; j++){
       System.out.println(t1.getName()+":"+j);
     } // end for(int j = 1 ;j <=5000; j++){
     
  }

}
