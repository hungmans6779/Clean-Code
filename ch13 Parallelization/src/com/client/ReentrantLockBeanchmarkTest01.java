package com.client;

import static com.sun.istack.internal.logging.Logger.getLogger;

import java.util.concurrent.CyclicBarrier;

import com.thread.reentrantLock.Counter;
import com.thread.reentrantLock.ReentrantLockBeanchmark;

/*
 *  參閱：http://blackgu.blogbus.com/logs/69596661.html
 *  
 *  在多線程程序設計中，經常會遇到一個線程等待一個或多個線程的場景，遇到這樣的場景應該如何解決？
 *  如果是一個線程等待一個線程，則可以通過 await() 或 notify() 來實現;
 *  如果是一個線程等待多個線程，則就可以使用 CountDownLatch 和 CyclicBarrier 來實現比較好的控制。
 *  
 */
public class ReentrantLockBeanchmarkTest01 {
  
  private int threadNum;
  
  private Counter counter;
  
  private CyclicBarrier barrier;
  
   
  public ReentrantLockBeanchmarkTest01(Counter counter,int threadNum){
    this.counter = counter;
    this.threadNum = threadNum;
    
    barrier = new CyclicBarrier(threadNum + 1);
  }
 
  
  
  
  
  // 內部類別多執行緒
  class TestThread extends Thread{
    
    private Counter counter;
    
    public TestThread(final Counter counter){
      this.counter = counter;  
    }
    
    public void run(){
      try{
        barrier.await();
        for(int i=0;i<100;i++){
          counter.increment(); 
        }
        barrier.await();
      }catch(Exception e){
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    } // end run
    
  } // end  class TestThread
  
  
  
  
 
  public void test(){
    try{
      for(int i =0 ;i < threadNum;i++){
        new TestThread(counter).start(); 
      }
      
      long start = System.currentTimeMillis();
      barrier.await();  // 等待所有任務線程創建
      barrier.await();  // 等待所有任務計算完成
      long end = System.currentTimeMillis();
      
      System.out.println("count value = "+ counter.getValue());
      System.out.println("花費時間    = "+ (end - start)+" 毫秒.");
          
    }catch(Exception e){
      e.printStackTrace();
    }
  } // end test
  
  
  

  
  /**
   * @param args
   */
  public static void main(String[] args) {
    new ReentrantLockBeanchmarkTest01(new ReentrantLockBeanchmark(),5000).test();
  }
  
  
  
  
  

}
