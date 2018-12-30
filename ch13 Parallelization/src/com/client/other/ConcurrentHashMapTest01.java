package com.client.other;

import java.util.Enumeration;

import java.util.concurrent.ConcurrentHashMap;

/*
 *  ConcurrentHashMap ��@����{���u�� HashMap ���O�A�o�����O���\�P�B���s���欰�A
 *  �ӥB�A���٦��@�Ǥ�k�A�䴩�D�w����������`���ƦX�ާ@�C
 */
public class ConcurrentHashMapTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    ConcurrentHashMap chm = new ConcurrentHashMap();
    for(int i=1; i<=100;i++){
      chm.put("key"+i,i);
    }
    System.out.print("chm size = "+chm.size());
    System.out.println("\n");
    Enumeration e = chm.elements(); 
    while(e.hasMoreElements()){
      System.out.println(e.nextElement());
    } // end 
    
  } // end main

  
}
