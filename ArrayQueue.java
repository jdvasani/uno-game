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
public class ArrayQueue <E> implements Queue <E> {
    private static final int CAPACITY=1000;
    private E[] data;
    private int f=0;
    private int sz=0;
    
    public ArrayQueue(){
        this(CAPACITY);
    }
    public ArrayQueue(int capacity){
        data=(E[]) new Object[capacity];
    }
    
    public int size(){
        return sz;
    }
    
    public boolean isEmpty(){
        return sz==0;
    }
    
    public void enqueue(E e) throws IllegalStateException {
        if(sz == data.length) throw new  IllegalStateException("Queue is full");
        int avail = (f+sz)%data.length;
        data[avail]=e;
        sz++;
    }
    
    public E dequeue(){
        if(isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f]=null;
        f=(f+1)% data.length;
        sz--;
        return answer;
    }
    
    
    public E first(){
        if(isEmpty()){
            return null;
        }
        E answer = data[f];
                return answer;
                }
    
}
