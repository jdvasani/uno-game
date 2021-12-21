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
public class Deck extends Card{
    
    SinglyLinkedList <Card> deck;
    
    public Deck()
    {
        deck= new SinglyLinkedList <> ();
        
        
        for(Colour a : Colour.values())
        {      
            
             for(Faces f : Faces.values()){
                
               
                         Card c = new Card(a,f);
                         
                      if(a.valueOf("BLACK").equals(a)){
                            
                              if(f.valueOf("WILD").equals(f)){
                                  
                                 deck.addFirst(c);
                                 deck.addFirst(c);
                                 deck.addFirst(c);
                                 deck.addFirst(c);
                                }
                        }  
                      else
                        { 
                            if(!f.valueOf("WILD").equals(f)){
                               deck.addFirst(c);
                                deck.addFirst(c);
                            }
                        }
                     
                 }
              
                     
           }
    }
    
    public void shuffle(){
        SinglyLinkedList <Card> auxiliary1 = new SinglyLinkedList <>();
        SinglyLinkedList <Card> auxiliary2 = new SinglyLinkedList <> ();
        
        for(int i=0;i<50;i++)
        {
            auxiliary1.addFirst(deck.removeFirst());
            
        }
        for(int i=0;i<50;i++){
            auxiliary2.addFirst(deck.removeFirst());
        }
        for(int i=0;i<50;i++){
            deck.addFirst(auxiliary1.removeFirst());
            deck.addFirst(auxiliary2.removeFirst());
        }
    }
    
    public Card removeTop(){
        
        return deck.removeFirst();
    }
             
              
                  public String toString(){
                   return deck.toString();
                  }
                  
}
        
            
        
        
    
   

