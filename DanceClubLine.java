//Code initially taken from Data Structures and Algorithms in Java (6th Edition). It has been modified to remove from the bottom, and add to the top. It also has a print method and a add at method.

import java.util.*;







public class DanceClubLine<String>{





  public class DoublyLinkedList<E>{
    //Node class
    
    public class Node<E>{
      private E element;
      private Node<E> prev;
      private Node<E> next;
      public Node(E e, Node<E> p, Node<E> n){
        prev = p;
        element = e;
        next = n;
      }
      public E getElement(){return element;}
      public Node<E> getPrev(){return prev;}
      public Node<E> getNext(){return next;}
      public void setPrev(Node<E>p){prev=p;}
      public void setNext(Node<E> n) {next = n;}
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    public DoublyLinkedList(){
      header = new Node<>(null, null, null);
      trailer = new Node<>(null, header, null);
      header.setNext(trailer);
    }
      
    public int size(){return size;}
    public boolean isEmpty(){return size == 0; }

    public E first(){
      if (isEmpty()) return null;
      return header.getNext().getElement();
    }
    public E last(){
      if (isEmpty()) return null;
      return trailer.getPrev().getElement();
    }

    //adds at the top
    public void addFirst(E e){
    
      addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
      addBetween(e, trailer.getPrev(), trailer);
    }
   
    //removes from the top
    public E removeFirst(){
      if(isEmpty()){return null;}
      return remove(header.getNext());
    }
    public E removeLast(){
      if(isEmpty()) return null;
      return remove(trailer.getPrev());

    }
    //O(n)
    /*
    public E pull(){
      if(isEmpty() == true) return null;
      Node<E> prev = head.getNext();
      
      boolean done = false;
      while(done == false && size > 2){
        Node<E> next = prev.getNext();
        if (next == tail){
          done = true;

        }
        prev = next;


      }
      
      E place = tail.getElement();
      tail = prev;
      size--;
      

      return place;
    }
    */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor){
      Node<E> newest = new Node<>(e, predecessor, successor);
      predecessor.setNext(newest);
      successor.setPrev(newest);
      size++;
    }

    public E remove(Node<E> node){
      Node<E> predecessor = node.getPrev();
      Node<E> successor = node.getNext();
      predecessor.setNext(successor);
      successor.setPrev(predecessor);
      size--;
      return node.getElement();
    }


    public void replace(E data, int index){
      Node<E> next = header.getNext();
      while(index > 0){
        next = next.getNext();
        index--;

      }
      Node<E> predecessor = next.getPrev();
      Node<E> successor = next.getNext();
      addBetween(data, predecessor, successor);
      size--;
      
    }

    public void insertAt(E data, int index){
      Node<E> next = header.getNext();
      
      while(index > 0){
        next = next.getNext();
        index--;

      }
      
      Node<E> predecessor = next.getPrev();
      //Node<E> successor = next.getNext();
      //addBetween(data, predecessor, successor);
      Node<E> newest = new Node<>(data, next.getPrev(), next);
      next.getPrev().setNext(newest);
      next.setPrev(newest);
      size++;

      
    }

    
    public void removeAt(int index){
      Node<E> next = header.getNext();
      while(index > 0){
        next = next.getNext();
        index--;
      }
      //size--;
      remove(next);
    }
    

    //Added to print contents
    public void printContents(){
      int count = 1;
      Node<E> spot = header.getNext();
      System.out.println("List:");
      while(count < (size() + 1)){

        E element = spot.getElement();
        
        System.out.println(count + ": " + element);
        spot = spot.getNext();
        count++;
      }
    
    

    }
    
  }


  //DoublyLinkedList<String> queue;
  public DanceClubLine(){
  }
  ArrayList<String> customers = new ArrayList<String>();
  DoublyLinkedList<String> queue = new DoublyLinkedList();
  private int customerSize = 0;
  //}
  
  public void addToLine(String name){
    queue.addLast(name);
  }

  public void addToFront(String name){
    queue.addFirst(name);
  }

  public void replaceInLine(String name, int spot){
    queue.replace(name, spot);
  }

  public void insertInLine(String name, int spot){
    queue.insertAt(name, spot);
  }

  public void removeInLine(int spot){
    queue.removeAt(spot);
  }



  
  public ArrayList<String> letInGroup(int amount){
    ArrayList<String> list = new ArrayList<String>(amount);

    while(amount > 0){
    
      String person = queue.removeFirst();
      System.out.println(person + " has entered.");
      list.add(person);
      customers.add(person);
      customerSize++;
      amount--;
    }

    return list;
  }
  

  public String letIn(){
    String person = queue.removeFirst();
    customers.add(person);
    System.out.println(person + " has entered.");
    customerSize++;
    return person;
  }

  //Send away n amount of people where n is amount
  public void sendAway(int amount){
    while(amount > 0){
      queue.removeLast();
      System.out.println("Someone has gone home");
      amount--;
    }
  }
  
  public void printList(){
    queue.printContents();
  }

  public void printCustomers(){
    System.out.println("Current patrons: ");
    for(int i = 0; i < customers.size(); i++){
      System.out.print(customers.get(i) + ", ");
    }
    
  }
    //public E send
  public void lineSize(){
    int amount = queue.size();
    System.out.println("Number of patrons: " + amount);
  }
    

  
}




