package com.client;

import java.util.concurrent.CyclicBarrier;


import com.thread.cyclicBarrier.Player;

/*
 *  1. CyclicBarrier(int parties)
 *     這裡的 parties 也是一個計數器，例如，初始化時 parties 裡的計數是3，於是擁有該 CycleBarrier 對象唐線程當 parties 的計數為 4 就喚醒，
 *     註：這裡 parties 裡的計數在運行時當調用 CyclicBarries:await() 時，計數就加1，一直加到初始的值。
 *  2. CyclicBarrier(int parties, Runnable barrierAction)
 *     這裡的 parties 與上一個構造方法的解釋是一樣的，這裡需要解釋的是第二個入參(Runnable barrierAction)，
 *     這個參數是一個實現 Runnable 接品的類別對，也就是說當 parties 加到初始值時就出發 barrierAction 的內容。
 */
public class PlayerTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new Runnable(){
      @Override
      public void run() {
        System.out.print("\n");
        System.out.println("★★★ 所有玩家進入第二關 ★★★");   
        System.out.print("\n");
      } // end run
    });
   
  
    System.out.println("*************************************************************************");
    System.out.println("cyclicBarrier parties = "+cyclicBarrier.getParties());
    System.out.println("*************************************************************************");
    
    for(int i=1;i<=4;i++){
      new Thread(new Player(i,cyclicBarrier)).start();  
    }
  
  } // end main

  
}