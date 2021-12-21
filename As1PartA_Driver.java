/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_1;

/**
 *
 * @author Admin
 */
public class As1PartA_Driver {
    public static void main(String [] args){
        System.out.println("Let's play UNO");
        
        GameSim g = new GameSim();
        
        System.out.println("First Card:\n"+ g.lastCard);
       // System.out.println(g.d);
       boolean winner=false;
       while(!winner){
           winner=g.PlayCard(g.myTurn);
           
       }
       
     
       
    }
    
}
