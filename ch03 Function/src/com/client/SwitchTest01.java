package com.client;

import com.switchTest01.Employee;
import com.switchTest01.Payroll;
import com.switchTest01.MoneyModel.Money;

public class SwitchTest01 {

  public static void main(String [] args){
    Employee employee = new Employee();
    employee.setType(3);
    
    
    Payroll pay = new Payroll();
    Money money = pay.calculatePay(employee);
    System.out.println(money.showPay());
  } // end main
   
  
}
