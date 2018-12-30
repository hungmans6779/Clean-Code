package com.thread.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/*
 *  �������a���O
 * 
 *  1. CyclicBarrier(int parties)
 *     �o�̪� parties �]�O�@�ӭp�ƾ��A�Ҧp�A��l�Ʈ� parties �̪��p�ƬO3�A��O�֦��� CycleBarrier ��H��u�{�� parties ���p�Ƭ� 4 �N����A
 *     ���G�o�� parties �̪��p�Ʀb�B��ɷ�ե� CyclicBarries:await() �ɡA�p�ƴN�[1�A�@���[���l���ȡC
 *  2. CyclicBarrier(int parties, Runnable barrierAction)
 *     �o�̪� parties �P�W�@�Ӻc�y��k�������O�@�˪��A�o�̻ݭn�������O�ĤG�ӤJ��(Runnable barrierAction)�A
 *     �o�ӰѼƬO�@�ӹ�{ Runnable ���~�����O��A�]�N�O���� parties �[���l�ȮɴN�X�o barrierAction �����e�C
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
      System.out.println("���a "+id+" ,���b���Ĥ@��");
      cyclicBarrier.await();
      
      System.out.println("���a "+id+" ,�i�J�ĤG��");
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  
  
}
