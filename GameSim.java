/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment_1;
import java.util.Random;
/**
 *
 * @author Admin
 */
public class GameSim {
    
    CircularDoublyLinkedList <Player> players;
    Deck d;
    Player myTurn;
    Card lastCard;
    static boolean sequance= true;
    
    
    public GameSim(){
        players = new CircularDoublyLinkedList();
        Player P =new Player("Pumbaa");
        Player T = new Player("Timon");
        Player N= new Player("Nala");
        Player S=  new Player("Simba");
       
        players.addFirst(P);
        players.addFirst(T);
        players.addFirst(N);
        players.addFirst(S);
        
        myTurn= S;
        
        
        d= new Deck();
        Random r = new Random();
        // shuffle it random times between  to 10
          for(int i=0;i<r.nextInt(5)+5;i++){
        d.shuffle();
        }
        
        
          for(int i =0;i<7;i++){
            P.cardsInHand.add(d.removeTop());
            T.cardsInHand.add(d.removeTop());
            N.cardsInHand.add(d.removeTop());
            S.cardsInHand.add(d.removeTop());
                 
          }
          
        lastCard = d.removeTop();
        
        if(lastCard.face.valueOf("WILD").equals(lastCard.face))
        {
            d.deck.addLast(lastCard);
            lastCard = d.removeTop();
            
            
        }
        
     }
     // this meathod will do everything in the game and will return true only when a player playes its last card 
    //and that will be the end of the game
    public boolean PlayCard(Player p){
        
        int i=0;
        // i is used to track the current element in the list
        
        System.out.println(p);
       
        for(Card c : p.cardsInHand){
            
             // checking if the colour mathch the last card
             if(lastCard.color.equals(c.color) ){
                 d.deck.addLast(lastCard);
                  lastCard= p.cardsInHand.remove(i);
                        System.out.println(p.getName()+" plays "+lastCard);
                        
                        // check if there is skip card
                   if(lastCard.face.equals(lastCard.face.valueOf("SKIP"))){
                         skipCard();
                     }
                   // check for reverse card and then change the direction 
                   if(lastCard.face.equals(lastCard.face.valueOf("REVERSE"))){
                       sequance=!sequance;
                       System.out.println(" GAME REVERSE DIRECTION");
                       
                   }
                    
                   // for the last two cards
                    if(p.cardsInHand.size()==1){
                 System.out.println(p.getName()+" YELLS UNO!!!");
             }
             if(p.cardsInHand.size()==0){
                 System.out.println(p.getName()+" WINS THE GAME!!!");
                 return true;
             }

                 getNextPlayer(sequance);
                 return false;
                
             }
            
              i++;
            }
        
         i=0;
          
          
            
            for(Card c: p.cardsInHand){
                
                 // for the wild card only if there is no match in colour and face then check for wild and 
                  //then set the colour to the first card from the hand
                  
                 
                 if(c.face.equals(c.face.valueOf("WILD"))){
                     d.deck.addLast(lastCard);
                   
                    lastCard = new Card(lastCard.color.valueOf("BLACK"), lastCard.face.valueOf("ONE")); 
                    System.out.println(p.getName()+" plays "+ p.cardsInHand.remove(i));
                   
                    
                     
                     lastCard.color=p.cardsInHand.get(0).color;
                     System.out.println(p.getName()+" CHANGES color to: "+lastCard.color);
                  
                    
                    
                     
                     
                     
                     if(p.cardsInHand.size()==1){
                 System.out.println(p.getName()+" YELLOW UNO!!!");
             }
                    if(p.cardsInHand.size()==0){
                 System.out.println(p.getName()+" WINS THE GAME!!!!");
                 return true;
             }     
                    
                    getNextPlayer(sequance);
                   
                   return false; 
                 }
               
                  i++;
             
            
            }
            
            
            
        
        i=0;
         
                for(Card c: p.cardsInHand){
                    // check for the faces of the card only if colour does not match
                    if(lastCard.face.equals(c.face)){
                        d.deck.addLast(lastCard);
                        
                        lastCard= p.cardsInHand.remove(i);
                        System.out.println(p.getName()+" plays "+lastCard);
                       
                       // for the last two card
                        if(p.cardsInHand.size()==1){
                 System.out.println(p.getName()+" YELLS UNO!!!");
             }
                         if(p.cardsInHand.size()==0){
                 System.out.println(p.getName()+" WINS THE GAME!!!!");
                 return true;
             }        
                          
                      getNextPlayer(sequance);
                      return false;  
                    }
                    i++;
                }
            
          
         
            
           
        
        
        
            Card c = d.removeTop();
            p.cardsInHand.add(c);
            
            System.out.println(p.getName()+" has no play, draws "+c);
            
            if(c.color.equals(lastCard.color) || c.face.equals(lastCard.face) ){
               lastCard=c;
               p.cardsInHand.remove(c);
               System.out.println(p.getName()+" plays "+c);
                if(lastCard.face.equals(lastCard.face.valueOf("SKIP"))){
                         skipCard();
                     }
                   if(lastCard.face.equals(lastCard.face.valueOf("REVERSE"))){
                       sequance=!sequance;
                       System.out.println(" GAME REVERSE DIRECTION");
                       
                   }
               
            }
            else if(c.color.equals(c.face.valueOf("WILD"))){
                lastCard=c;
                System.out.println(p.getName()+" plays "+c);
                lastCard.color=c.color;
                
            }
            
            
            
            
        
        
    
        getNextPlayer(sequance);
        return false;
    }
    
    // for skip card
    
    public void skipCard(){
        players.rotateForward();
        System.out.println(players.first().getName()+" misses turn");
    }
    
    
    // to get the next player 
    public void getNextPlayer(boolean b){
            if(b){
        players.rotateForward();
        myTurn = players.first();
                
    }
        else{
            players.rotateReverse();
            myTurn=players.first();
            
        }
        
    }
    
    
}
  
