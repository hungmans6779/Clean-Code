package com.client;

import java.util.concurrent.CountDownLatch;

import com.thread.countDownLatch.Work;

/*
 * 
 *  CountDownLatch：在釋放所有等待這個鎖的執行緒之前，這個鎖會先等待指定數量的事件。
 *                  這使得所有的執行緒都有公平的機會，在同時間啟動。
 *                  
 *  其中 count 是一個計數器中的初始化數字，比如初始化數字是 2,
 *  當一個線程裡調用了 countDown(),則這個計數器就減 1，
 *  當線程調用了 await(),則這個線程就等待這個計數器變 0，
 *  當這個計數器變為 0 時，這個線程繼續自已下面的工作。
 */
public class WorkTest01 {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    CountDownLatch beginSignal = new CountDownLatch(1);
    CountDownLatch endSignal = new CountDownLatch(8);
    
    System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
    System.out.println("beginSigna before count = "+beginSignal.getCount());
    System.out.println("endSigna   before count = "+endSignal.getCount());
    System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
    for(int i = 0;i < 8;i++){
      new Thread(new Work(i,beginSignal,endSignal)).start();
    } // end for(int i = 1;i <= 8;i++){
    
    
    
    try{
      System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
      System.out.println("beginSigna middle count = "+beginSignal.getCount());
      System.out.println("endSigna   middle count = "+endSignal.getCount());
      System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

      beginSignal.countDown(); // 統一起跑
      endSignal.await();       // 等待運動員到達終點

      System.out.println("beginSigna after count = "+beginSignal.getCount());
      System.out.println("endSigna   after count = "+endSignal.getCount());
      
      System.out.println("\n\n\n");
      System.out.println("★★ 結果發送到匯報成績的系統 ★★");
    }catch(Exception e){
      e.printStackTrace();
    }
    
  } // end main

  
}
