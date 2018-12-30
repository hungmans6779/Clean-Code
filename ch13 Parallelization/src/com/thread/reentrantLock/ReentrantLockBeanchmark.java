package com.thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  ReentrantLock class�G�@�ӥi�H�Q A ��k�����o�A�æb B ��k��������C
 *  
 *  1. �ЫثD������A�u�{�����ǽШD��o������A�Ӥ@�ӫD������i�H���J�A�p�G�ꪺ���A�i�ΡA
 *     �ШD�D�����ꪺ�u�{�i�b���ݰ}�C���V�e���D�A��o����C������ synchronized �S�����ѽT�w�������ʫO�ҡC 
 *  2. �Ыؤ�����C�p�G��w�g�Q��L�u�{�����A�s���ШD�u�{�|�[�J�쵥�ݰ}�C�A�Ϊ̤w�g���@�ǽu�{�b������F�C
 *
 */
public class ReentrantLockBeanchmark implements Counter {

  private volatile long count = 0;
    
  private Lock lock;
  
  public ReentrantLockBeanchmark(){
    // false�G�ϥΫD������Atrue�G�N�O�ϥΤ�����
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
