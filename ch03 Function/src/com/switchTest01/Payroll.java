package com.switchTest01;

import com.switchTest01.MoneyModel.Money;
import com.switchTest01.MoneyModel.impl.CommissionedPay;
import com.switchTest01.MoneyModel.impl.HourlyPay;
import com.switchTest01.MoneyModel.impl.InvalidEmployeeType;
import com.switchTest01.MoneyModel.impl.SalariedPay;

public class Payroll {

  private final int COMMISSIONED = 1;
  private final int HOURLY = 2;
  private final int SALARIED = 3;
  
  
  
  public Money calculatePay(Employee e){
    switch(e.type){
       case COMMISSIONED:
           return calculateCommissionedPay(e);
       case HOURLY:
         return calculateHourlyPay(e);
       case SALARIED:
         return calculateSalariedPay(e);  
       default:
          return new InvalidEmployeeType(1);
    }  
  } // end calculatePay
   
  
 
  
  private Money calculateCommissionedPay(Employee e){
    return new CommissionedPay();
  }
   
  private Money calculateHourlyPay(Employee e){
    return new HourlyPay();
  }
   
  private Money calculateSalariedPay(Employee e){
    return new SalariedPay();
  }
   
  
  
}
