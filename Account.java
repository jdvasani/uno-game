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
public class Account {
    Queue <Integer> shares;
    int runningTotal;
    int runningShare;
    
    public Account(){
        runningTotal=0;
        runningShare=0;
        shares = new ArrayQueue <>();
    }
    
    public void buyShares(int n, int p){
        for(int i =0;i<n;i++){
            runningTotal=runningTotal+p;
            
            shares.enqueue(p);
        }
        runningShare=runningShare+n;
    }
    
    public int sellShares(int n, int p){
        int total=0;
        for(int i=0;i<n;i++){
            total=total+shares.dequeue();
        }
        runningTotal=runningTotal-total;
        runningShare=runningShare-n;
        return n*p-total;
    }
    
    public int getTOtalValue(){
        return runningTotal;
    }
    
    public int getTotalShare(){
        return runningShare;
    }
    
}
