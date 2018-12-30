package com.client;

import static com.sun.istack.internal.logging.Logger.getLogger;

import java.util.concurrent.CyclicBarrier;

import com.thread.reentrantLock.Counter;
import com.thread.reentrantLock.ReentrantLockBeanchmark;

/*
 *  �Ѿ\�Ghttp://blackgu.blogbus.com/logs/69596661.html
 *  
 *  �b�h�u�{�{�ǳ]�p���A�g�`�|�J��@�ӽu�{���ݤ@�өΦh�ӽu�{�������A�J��o�˪��������Ӧp��ѨM�H
 *  �p�G�O�@�ӽu�{���ݤ@�ӽu�{�A�h�i�H�q�L await() �� notify() �ӹ�{;
 *  �p�G�O�@�ӽu�{���ݦh�ӽu�{�A�h�N�i�H�ϥ� CountDownLatch �M CyclicBarrier �ӹ�{����n������C
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
 
  
  
  
  
  // �������O�h�����
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
      barrier.await();  // ���ݩҦ����Ƚu�{�Ы�
      barrier.await();  // ���ݩҦ����ȭp�⧹��
      long end = System.currentTimeMillis();
      
      System.out.println("count value = "+ counter.getValue());
      System.out.println("��O�ɶ�    = "+ (end - start)+" �@��.");
          
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
