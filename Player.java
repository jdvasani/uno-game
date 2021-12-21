/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_1;

import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Player {
    private String name;
    public ArrayList <Card> cardsInHand;
    
    public Player(String n){
        this.name=n;
        cardsInHand = new ArrayList();
    }
    
    public Card playCard(int i){
        
        return cardsInHand.remove(i);
        
    }
    
    public String getName(){
        return name;
    }
    
    public String toString(){
        String str="";
        for(Card c: cardsInHand){
            str=str+c+", ";
        }
        return "("+name+"'s Hand: "+str+")";
    }
    
}
