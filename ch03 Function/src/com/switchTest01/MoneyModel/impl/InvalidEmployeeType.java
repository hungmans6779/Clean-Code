package com.switchTest01.MoneyModel.impl;

import com.switchTest01.MoneyModel.Money;

public class InvalidEmployeeType implements Money {
 
  public InvalidEmployeeType(int type){
 
  }
 
  
  public String showPay(){
    return "InvalidEmployeeType";
  }
  
  
}
