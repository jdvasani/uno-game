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
public class CircularDoublyLinkedList <E> {
    
    private static class Node<E>
    {
    private E element;
    private Node<E> prev;
    private Node<E> next;
    public Node (E e, Node<E> p, Node<E> n)
    {
        element=e;
        prev=p;
        next=n;
    }
            public E getElement(){
                return element;
            }
            
            public Node<E> getPrev(){
                return prev;
            }
            
            public Node<E> getNext(){           
                return next;
            }
            
            public void setNext(Node<E> n){
                next=n;
            }
            
            public void setPrev(Node<E> p){
               prev=p;
            }
            
}
    
private Node<E> trailer;
private int size =0;

public CircularDoublyLinkedList(){
   
    trailer = new Node<> (null,null,null);
    trailer.setNext(trailer);
}

public int size(){
    return size;
}

public boolean isEmpty() {
    return size==0;
}

public E first()
{
    if(isEmpty()){
        return null;
    }
    
    return trailer.getNext().getElement();
}

public E last(){
    if(isEmpty()){
        return null;
    }
    return trailer.getPrev().getElement();
}

public void addFirst(E e){
    addBetween(e,trailer,trailer.getNext());
}

public void addLast(E e){
    addBetween(e,trailer.getPrev(),trailer);
}

public E removeFirst() {
    if(isEmpty()) return null;
    return remove(trailer.getNext());
}

public E removeLast(){
    if(isEmpty()) return null;
    
    return remove(trailer.getPrev());
}

public void rotateForward(){
    Node <E> e = trailer.getNext();
   E ele= remove(e);
   addBetween(ele,trailer.getPrev(),trailer);
}

public void rotateReverse(){
    Node <E> e = trailer.getPrev();
    E ele= remove(e);
    addBetween(ele,trailer,trailer.getNext());
}


private void addBetween (E e, Node<E> predecessor, Node<E> successor){
    Node<E> newest = new Node<> (e,predecessor,successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
}

private E remove(Node<E> node){
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    
    size--;
    
    return node.getElement();
}
}
