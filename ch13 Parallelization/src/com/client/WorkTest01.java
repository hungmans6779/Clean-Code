package com.client;

import java.util.concurrent.CountDownLatch;

import com.thread.countDownLatch.Work;

/*
 * 
 *  CountDownLatch�G�b����Ҧ����ݳo���ꪺ��������e�A�o����|�����ݫ��w�ƶq���ƥ�C
 *                  �o�ϱo�Ҧ���������������������|�A�b�P�ɶ��ҰʡC
 *                  
 *  �䤤 count �O�@�ӭp�ƾ�������l�ƼƦr�A��p��l�ƼƦr�O 2,
 *  ��@�ӽu�{�̽եΤF countDown(),�h�o�ӭp�ƾ��N�� 1�A
 *  ��u�{�եΤF await(),�h�o�ӽu�{�N���ݳo�ӭp�ƾ��� 0�A
 *  ��o�ӭp�ƾ��ܬ� 0 �ɡA�o�ӽu�{�~��ۤw�U�����u�@�C
 */
public class WorkTest01 {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    
    CountDownLatch beginSignal = new CountDownLatch(1);
    CountDownLatch endSignal = new CountDownLatch(8);
    
    System.out.println("��������������������������������������������������������������������������");
    System.out.println("beginSigna before count = "+beginSignal.getCount());
    System.out.println("endSigna   before count = "+endSignal.getCount());
    System.out.println("��������������������������������������������������������������������������");
    for(int i = 0;i < 8;i++){
      new Thread(new Work(i,beginSignal,endSignal)).start();
    } // end for(int i = 1;i <= 8;i++){
    
    
    
    try{
      System.out.println("��������������������������������������������������������������������������");
      System.out.println("beginSigna middle count = "+beginSignal.getCount());
      System.out.println("endSigna   middle count = "+endSignal.getCount());
      System.out.println("��������������������������������������������������������������������������");

      beginSignal.countDown(); // �Τ@�_�]
      endSignal.await();       // ���ݹB�ʭ���F���I

      System.out.println("beginSigna after count = "+beginSignal.getCount());
      System.out.println("endSigna   after count = "+endSignal.getCount());
      
      System.out.println("\n\n\n");
      System.out.println("���� ���G�o�e��׳����Z���t�� ����");
    }catch(Exception e){
      e.printStackTrace();
    }
    
  } // end main

  
}
