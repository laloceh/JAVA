/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author eduardo
 */
public class DoublyLinkedList {
    
    private Node head;
    private int size;
    
    public DoublyLinkedList(){
        System.out.println("Calling the Constructor");
        head = null;
        size = 0;
    }
    
    /*
        Check if the list is empty
    */
    public boolean isEmpty(){
        return head == null;
    }
    
    /*
        Add a new node at Front
    */
    public void addFront(int data){
        //if (head == null){
        if (isEmpty()){
            head = new Node(data);
        }
        else{
            Node newNode = new Node(null, data, head);
            //head.previous = newNode;
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }
    
    /*
        Add a new node at the End
    */
    public void addEnd(int data){
        if (head == null){
            head = new Node(data);
        }
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            Node newNode = new Node(current, data, null);
            current.next = newNode;
        }
        size++;
    }
    
    
    /*
        Get the size of the list
    */
    public int getSize(){
        return size;
    }
    
    
    /*
        Print the List (Forward)
    */
    public void printForward(){
        Node current = head;
        while (current != null){
            System.out.print(current.getData() + ",");
            current = current.next;
        }
        System.out.println("");
    }
    
    /*
        Print the List (Backward)
    */
    public void printBackward(){
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        
        while (current != head){
            System.out.print(current.getData() + ",");
            current = current.previous;
        }
        System.out.println(current.getData());
    }
    
    
    /*
        Remove from the Front
    */
    public void removeFront(){
        if (head == null){
            return;
        }
        
        head = head.next;
        head.previous = null;
        size--;
    }
    
    /*
        Remove from the End
    */
    public void removeEnd(){
        if (head == null){
            return;
        }
        
        if (head.next == null){
            head = null;
            size--;
        }
        
        Node current = head;
        // 1 position before end
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }
    
    /*
        Insert at given position
    */
    public void insertAt(int data, int index){
        if (head == null){
            return;
        }
        
        if (index < 1 || index > size){
            return;
        }
        
        Node current = head;
        int i = 1;
        while (i < index){
            current = current.next;
            i++;
        }
        // if this is the first node
        if (current.previous == null){
            Node newNode = new Node(null, data, current);
            current.previous = newNode;
            head = newNode;
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
        if (head == null){
            return;
        }
        
        if (index < 1 || index > size){
            return;
        }
        
        Node current = head;
        int i = 1;
        while (i < index){
            current = current.next;
            i++;
        }
        if (current.next == null){
            current.previous.next = null;
        }
        else if (current.previous == null){
            current = current.next;
            current.previous = null;
            head = current;
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
        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.println("Is it empty?:" + dll.isEmpty());
        System.out.println("Size: " + dll.getSize());
        
        System.out.println("-------1--------");
        
        
        dll.addFront(5);
        dll.addFront(20);
        dll.printForward();
        System.out.println("Size: " + dll.getSize());
        
        
       
        System.out.println("-------2---------");
        
        dll.addEnd(10);
        dll.printForward();
        System.out.println("Size: " + dll.getSize());
        
        
        System.out.println("-------3--------");
        
        dll.removeFront();
        dll.printForward();
        System.out.println("Size: " + dll.getSize());
        
        
        
        System.out.println("-------4--------");
        
        dll.removeEnd();
        dll.printForward();
        System.out.println("Size: " + dll.getSize());
        
        
        
        System.out.println("-------5--------");
        
        dll.insertAt(36, 1);
        dll.insertAt(45, 2);
        dll.printForward();
        
        System.out.println("Size: " + dll.getSize());
        
        
        
        System.out.println("-------6--------");
        
        dll.removeAt(2);
        dll.printForward();
        
        System.out.println("Size: " + dll.getSize());
        
        System.out.println("--------7-------");
        
        dll.printBackward();
        
    }
    
}
