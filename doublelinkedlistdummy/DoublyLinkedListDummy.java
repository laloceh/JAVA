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
public class DoublyLinkedListDummy {
    
    private Node head;
    private Node tail;
    private int size;
    
    
    /*
        Constructor
    */
    public DoublyLinkedListDummy(){
        System.out.println("Calling the Constructor");
        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
       
    }
    
    /*
        Check if the list is empty
    */
    public boolean isEmpty(){
        return head.next == tail;
    }
    
    /*
        Get the size of the list
    */
    public int getSize(){
        return size;
    }
    
    /*
        Add a new node at Front
    */
    public void addFront(int data){
        if (isEmpty()){
            
            Node newNode = new Node(head, data, tail);
            head.next = newNode;
            tail.previous = newNode;
        }
        else{
            Node newNode = new Node(head, data, head.next);
            head.next.previous = newNode;
            head.next = newNode;
        }
        size++;
    }
    
    /*
        Add a new node at the End
    */
    public void addEnd(int data){
        if (isEmpty()){
            Node newNode = new Node(head, data, tail);
            head.next = newNode;
            tail.previous = newNode;
        }
        else{
            Node newNode = new Node(tail.previous, data, tail);
            tail.previous.next = newNode;
            tail.previous = newNode;
        }
        size++;
    }
    
    
    /*
        Print the List (Forward)
    */
    public void printForward(){
        Node current = head.next;
        while (current != tail){
            System.out.print(current.getData() + ",");
            current = current.next;
        }
        System.out.println("");
    }
    
    
    /*
        Print the List (Backward)
    */
    public void printBackward(){
        Node current = tail.previous;
        while (current != head){
            System.out.print(current.getData() + ",");
            current = current.previous;
        }
        System.out.println("");
    }
    
    
    /*
        Remove from the Front
    */
    public void removeFront(){
        if (isEmpty()){
            return;
        }
        
        head.next = head.next.next;
        head.next.previous = head;
        size--;
    }
    
    /*
        Remove from the End
    */
    public void removeEnd(){
        if (isEmpty()){
            return;
        }
        
        tail.previous = tail.previous.previous;
        tail.previous.next = tail;
        size--;
    }
    
    
    /*
        Insert at given position
    */
    public void insertAt(int data, int index){
        if (isEmpty()){
            return;
        }
        
        if (index < 1 || index > size){
            System.out.println("[INFO] position out of range!");
            return;
        }
        
        Node current = head.next;
        int i = 1;
        while (i < index){
            current = current.next;
            i++;
        }
        // if this is the first node
        if (current.previous == head){
            Node newNode = new Node(head, data, current);
            current.previous = newNode;
            head.next = newNode;
        }
        else{
            Node newNode = new Node(current.previous, data, current);
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }
    
    /*
        Remove from given position
    */
    public void removeAt(int index){
        if (isEmpty()){
            return;
        }
        
        if (index < 1 || index > size){
            System.out.println("[INFO] position out of range!");
            return;
        }
        
        Node current = head.next;
        int i = 1;
        while (i < index){
            current = current.next;
            i++;
        }
        // If this is the last node
        if (current.next == tail){
            current.previous.next = tail;
            tail.previous = current.previous;
        }
        // if this is the first node
        else if (current.previous == head){
            head.next = current.next;
            current.next.previous = head;
        }
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DoublyLinkedListDummy dlld = new DoublyLinkedListDummy();
        System.out.println("Is it empty?:" + dlld.isEmpty());
        System.out.println("Size: " + dlld.getSize());
        
        System.out.println("--------1-------");
        
        
        dlld.addFront(5);
        dlld.addFront(20);
        dlld.printForward();
        System.out.println("Size: " + dlld.getSize());
        
        
        
        System.out.println("--------2-------");
        
        dlld.addEnd(10);
        dlld.printForward();
        System.out.println("Size: " + dlld.getSize());
        
        
        
        System.out.println("--------3-------");
        
        dlld.removeFront();
        dlld.printForward();
        System.out.println("Size: " + dlld.getSize());
        
        
        
        System.out.println("--------4-------");
        
        dlld.removeEnd();
        dlld.printForward();
        System.out.println("Size: " + dlld.getSize());
        
        
        
        System.out.println("--------5-------");
        
        dlld.insertAt(36, 1);
        dlld.insertAt(45, 2);
        dlld.printForward();
        
        System.out.println("Size: " + dlld.getSize());
       
        
        
        System.out.println("--------6-------");
        
        dlld.removeAt(2);
        dlld.printForward();
        
        System.out.println("Size: " + dlld.getSize());
        
        System.out.println("--------7-------");
        
        dlld.printBackward();
        
    }
    
}
