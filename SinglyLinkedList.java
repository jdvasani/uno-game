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
public class SinglyLinkedList <E> {
      private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
        // Construct an initially empty list
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }

        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }

        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (size == 0) {
            tail = head;
        }

        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);

        if (isEmpty()) {
            head = newest;
        }
        else {
            tail.setNext(newest);
        }

        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0) {
            tail = null;
        }

        return answer;
    }
    
  public String toString(){
       StringBuilder sb = new StringBuilder();
          
        Node <E> e1 = head; // save head so that we can set it back when we afre done,
    
       for(int i=0;i<size;i++)
       {     
            Card  c= (Card) head.getElement();  // casting element of E into pair
            
            sb.append(c).append("//");
           head=head.getNext();
           
               }
      
        
       head=e1;  // get back the original head
       
     
       return sb.toString() + size;
    
  }

}
