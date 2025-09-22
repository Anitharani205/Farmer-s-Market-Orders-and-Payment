package com.kce.market.model;

public class Payment {
       public double amount;
       public boolean status;
       
       public Payment(double amount)
       {
    	   this.amount = amount;
    	   this.status = false;
       }
       
       public boolean pay(double payAmount )
       {
    	   if(payAmount >= amount)
    	   {
    		   status=true;
    		   System.out.println("payment Successful");
    		   return true;
    	   }
    	   System.out.println("payment is not done");
    	   return false;
    	   
       }
}
