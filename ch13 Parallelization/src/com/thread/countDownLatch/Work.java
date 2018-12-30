package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/*  
 *  ����"�B�ʭ�"���O
 *  
 *  CountDownLatch�G�b����Ҧ����ݳo���ꪺ��������e�A�o����|�����ݫ��w�ƶq���ƥ�C
 *                  �o�ϱo�Ҧ���������������������|�A�b�P�ɶ��ҰʡC
 *    
 *  �䤤 count �O�@�ӭp�ƾ�������l�ƼƦr�A��p��l�ƼƦr�O 2,
 *  ��@�ӽu�{�̽եΤF countDown(),�h�o�ӭp�ƾ��N�� 1�A
 *  ��u�{�եΤF await(),�h�o�ӽu�{�N���ݳo�ӭp�ƾ��� 0�A
 *  ��o�ӭp�ƾ��ܬ� 0 �ɡA�o�ӽu�{�~��ۤw�U�����u�@�C
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
      System.out.println("work "+id+",�_�]             ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
      System.out.println("work "+id+" ��F���I�I�I�I   ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
      endSignal.countDown();
      System.out.println("work "+id+" �~�򰵥��Ʊ�...  ,beginSignal count = "+beginSignal.getCount()+", endSigna count = "+endSignal.getCount());
     
    }catch(Exception e){
      e.printStackTrace();
    }
  } // end run

  
}
