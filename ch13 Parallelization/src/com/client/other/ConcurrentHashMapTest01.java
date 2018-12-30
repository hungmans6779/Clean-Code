package com.client.other;

import java.util.Enumeration;

import java.util.concurrent.ConcurrentHashMap;

/*
 *  ConcurrentHashMap 實作的表現都優於 HashMap 類別，這個類別允許同步的存取行為，
 *  而且，它還有一些方法，支援非安全執行緒的常見複合操作。
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
