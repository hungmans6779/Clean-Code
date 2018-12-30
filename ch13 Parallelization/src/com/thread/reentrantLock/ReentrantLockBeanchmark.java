package com.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  ReentrantLock class：一個可以被 A 方法中取得，並在 B 方法中釋放的鎖。
 *  
 *  1. 創建非公平鎖，線程按順序請求獲得公平鎖，而一個非公平鎖可以闖入，如果鎖的狀態可用，
 *     請求非公平鎖的線程可在等待陣列中向前跳躍，獲得該鎖。內部鎖 synchronized 沒有提供確定的公平性保證。 
 *  2. 創建公平鎖。如果鎖已經被其他線程佔有，新的請求線程會加入到等待陣列，或者已經有一些線程在等待鎖了。
 *
 */
public class ReentrantLockBeanchmark implements Counter {

  private volatile long count = 0;
    
  private Lock lock;
  
  public ReentrantLockBeanchmark(){
    // false：使用非公平鎖，true：就是使用公平鎖
    lock = new ReentrantLock(false);
  }
   
  @Override
  public void increment() {
    lock.lock();
    try{
      Thread t1 = Thread.currentThread();
      count ++;
    }finally{
      lock.unlock();
    }
  } // end increment()

 
  @Override
  public long getValue() {
    return count;
  }
  
}
