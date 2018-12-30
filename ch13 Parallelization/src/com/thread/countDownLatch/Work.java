package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/*  
 *  模擬"運動員"類別
 *  
 *  CountDownLatch：在釋放所有等待這個鎖的執行緒之前，這個鎖會先等待指定數量的事件。
 *                  這使得所有的執行緒都有公平的機會，在同時間啟動。
 *    
 *  其中 count 是一個計數器中的初始化數字，比如初始化數字是 2,
 *  當一個線程裡調用了 countDown(),則這個計數器就減 1，
 *  當線程調用了 await(),則這個線程就等待這個計數器變 0，
 *  當這個計數器變為 0 時，這個線程繼續自已下面的工作。
 *                
 */
public class Work implements Runnable {

  private int id;
  private CountDownLatch beginSignal;
  private CountDownLatch endSignal;
  
  public Work(int id,CountDownLatch begin,CountDownLatch end){
    this.id = id;
    this.beginSignal = begin;
    this.endSignal = end;
  }
  
  
  @Override
  public void run() {  
    try{
      beginSignal.await();
      System.out.println("work "+id+",起跑             ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
      System.out.println("work "+id+" 到達終點！！！   ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
      endSignal.countDown();
      System.out.println("work "+id+" 繼續做它事情...  ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
     
    }catch(Exception e){
      e.printStackTrace();
    }
  } // end run

  
}
