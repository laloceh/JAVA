/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlistdummy;

/**
 *
 * @author eduardo
 */
public class Node {
    
    
    public int data;
    public Node previous;
    public Node next;

    public Node(){
        this.previous = null;
        this.data = 0;
        this.next = null;
    }
    
    public Node(int data){
        this.previous = null;
        this.data = data;
        this.next = null;
    }
    
    public Node(Node previous, int data, Node next){
        this.previous = previous;
        this.data = data;
        this.next = next;
    }
    
    public int getData(){
        return this.data;
    }
    
    public void setData(int d){
        this.data = d;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public void setPrevious(Node prev){
        this.previous = prev;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public Node getPrevious(){
        return this.previous;
    }
    
    
    
}
