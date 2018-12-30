package com.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/*
 *  模擬玩家類別
 * 
 *  1. CyclicBarrier(int parties)
 *     這裡的 parties 也是一個計數器，例如，初始化時 parties 裡的計數是3，於是擁有該 CycleBarrier 對象唐線程當 parties 的計數為 4 就喚醒，
 *     註：這裡 parties 裡的計數在運行時當調用 CyclicBarries:await() 時，計數就加1，一直加到初始的值。
 *  2. CyclicBarrier(int parties, Runnable barrierAction)
 *     這裡的 parties 與上一個構造方法的解釋是一樣的，這裡需要解釋的是第二個入參(Runnable barrierAction)，
 *     這個參數是一個實現 Runnable 接品的類別對，也就是說當 parties 加到初始值時就出發 barrierAction 的內容。
 */
public class Player implements Runnable {

  private int id;
  private CyclicBarrier cyclicBarrier;
  
  public Player(int id,CyclicBarrier cyclicBarrier){
    this.id = id;
    this.cyclicBarrier = cyclicBarrier;
  }
  
  
  @Override
  public void run() {
    try{
      System.out.println("玩家 "+id+" ,正在玩第一關");
      cyclicBarrier.await();
      
      System.out.println("玩家 "+id+" ,進入第二關");
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  
  
}
