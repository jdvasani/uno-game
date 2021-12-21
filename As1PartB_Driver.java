/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_1;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class As1PartB_Driver {
    
    public static void main(String [] args){
       
        Scanner s = new Scanner(System.in);
        int input;
        Account ac = new Account();
        int price;
        int numOfShare;
        boolean exit = true;
        
        do{
              System.out.println("make a selection:\n 1. Buy shares\n 2. Sell shares\n 3. Quit");
              input=s.nextInt();
        switch(input){
            case 1: System.out.println("Enter the number of the share to buy:");
                    numOfShare=s.nextInt();
                    System.out.println("Enter the price per share:");
                    price=s.nextInt();
                    ac.buyShares(numOfShare, price);
                     System.out.println("total number of share: "+ac.getTotalShare());
                     System.out.println("total share values: $"+ac.getTOtalValue());
                     System.out.println("------------------------------------");
                     
                    break;
                    
            case 2: System.out.println("Enter the number of the shares to sell");
                    numOfShare=s.nextInt();
                    System.out.println("Enter the price per share:");
                    price=s.nextInt();
                    int gainOrLoss =ac.sellShares(numOfShare, price);
                    if(gainOrLoss>=0){
                        System.out.println("Capital gain: $"+gainOrLoss);
                    }
                    else{
                        System.out.println("Capital loss: $"+gainOrLoss);
                    }
                     System.out.println("total number of share: "+ac.getTotalShare());
                    
                     System.out.println("total share values: $"+ac.getTOtalValue());
                     System.out.println("------------------------------------");
                     
                    break;
                    
            case 3 :  exit=false;
                     System.out.println("Program has ended");
                     break;
            default : System.out.println("please make a valid selection");
           } 
        
         
                            
            
        } while(exit); 
    }
    
}
