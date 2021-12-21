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
public class Die {
    
    int faces, faceValue;
    
    private int rollDie(){
        Random r = new Random();
        return r.nextInt(6)+1;
        
    }
    
}
