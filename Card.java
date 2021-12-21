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
public class Card {
    
    public enum Faces {
       ZERO("ZERO"),ONE("ONE"),TWO("TWO"),THREE("THREE"),FOUR("FOUR"),FIVE("FIVE"),SIX("SIX"),SEVEN("SEVEN"),EIGHT("EIGHT"),NINE("NINE"),SKIP("SKIP"),REVERSE("REVERSE"),WILD("WILD");
      public final String lable;
      
      private Faces (String s){
          lable=s;
      }
    }
    
    public enum Colour{
        BLUE("BLUE"),RED("RED"),GREEN("GREEN"),YELLOW("YELLOW"),BLACK("BLACK");
        
        public final String lable;
        
        private Colour(String c){
            lable=c;
        }
        
    }
    
    public Colour color;
    public Faces face;
    
  
    
    public Card(Colour c, Faces f){
        color=c;
        face=f;
    }
    
    public Card (){
       
        
       
    }
    
    @Override
   public String toString(){
       return color+" "+face;
   }
    
}
