package lab6.cscd211linkedlist;
import java.util.*;
/**
 * The LinkedList class with a dummy head node
 * @NOTE All preconditions will be met and all parameters will be final
 */
public class LinkedList<T extends Comparable <? super T>>
{
	/**
	 * The private Node class as discussed in class
	 */
   private class Node
   {
	   /**
	    * The Node class data element as T which is a generic that is Comparable
	    */
      public T data;
      
      /**
       * The Node class next reference for the singly linked list
       */
      public Node next;
      
      /**
       * The node class constructor that only takes the data item
       * @param data Representing the data 
       */
      public Node(final T data)
      {
    	  this.data = data;
    	  this.next = null;

      }
      
      /**
       * The node class constructor that takes the data item and the next
       * reference 
       * @param data Representing the data
       * @param next Representing the next reference
       */
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   /**
    * The Class Level Head reference that allows us access to the list
    */
   private Node head;
   
   /**
    * The variable size that is a convenience for us
    */
   private int size;
   
   /**
    * Constructs an empty list.<br>
    * Dummy Head Node
    */
   public LinkedList()
   {
      this.head = new Node(null);
      this.size=0;
   }
   
   /**
    * Returns the number of elements in this list.
    *
    * @return int  - Representing the size
    */
   public int size()
   {
      int y=0;
      for(int i =0; i<=size; i++){
         y=i;
      }
      return y;
   }
   
   /**
    * Removes all of the elements from this list. 
    * The list will be empty after this call returns.    
    */
   public void clear()
   {
      this.head.next = null;
      size = 0;
   
   }
   
   /**
    * Inserts the specified element at the beginning of this list.
    *
    * @param item The item to add
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addFirst(final T item)
   {
      if(item == null)
         throw new IllegalArgumentException("Item is null");
      Node newNode = new Node(item);
      newNode.next = head.next;
      head.next = newNode;
      size++;
   }
   /**
    * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    *
    * @param item The item to find
    * @return int - The index if found or -1
    *
    * @throws IllegalArgumentException if item is null
    */
   public int indexOf(final T item)
   {
      Node curr = this.head;
      int i=0;
      for(int y =0; y<=size; y++){
         if(String.valueOf(curr.data).equals(String.valueOf(item)))
            return y-1;
         curr=curr.next;
      }

      return i;

   }
   
   
   /** 
    * Removes and returns the first element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeFirst()
   {
      if(size == 0)
         throw new NoSuchElementException("List is empty");
      if(size == 0)
         return null;
      else {
         Node temp = head.next;
         head = head.next;
         size--;
         return temp.data;
      }

   }
   
   /** 
    * Removes and returns the last element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeLast()
   {
      if(size == 0)
         throw new NoSuchElementException("List is empty");
      Node current = this.head;
      if(size == 0)
         return null;
      else{
         for(int i = 0; i<size; i++) {
            current = current.next;
         }
         current.next=null;
         size--;
      }
      return current.data;

   }
   
   /**
    * Removes the element at the specified position in this list. 
    * Shifts any subsequent elements to the left (subtracts one from their indices). 
    * Returns the element that was removed from the list.
    *
    * @param index The index of the element to be removed
    * @return T - The element previously at the specified position
    *
    * @throws IndexOutOfBoundsException - if the index is out of range (index less than 0 || index greater than or equal to size())
    */   
   public T remove(final int index)
   {
      if(index<0||index>=size)
         throw new IndexOutOfBoundsException("Index is out of bounds");
      if(index < 0 || index >= size)
         return null;
      else if (index == 0)
         return removeFirst();
      else if(index == size-1)
         return removeLast();
      else{
         Node prev = head.next;
         for(int i =1; i<index; i++)
            prev=prev.next;
         Node curr = prev.next;
         prev.next = curr.next;
         size--;
         return curr.data;
      }
   }
   
   /**
    * Inserts the specified element at the specified position in this list. 
    * Shifts the element currently at that position (if any) and any subsequent 
    * elements to the right (adds one to their indices).
    *
    * @param index The index at which the specified element is to be inserted
    * @param item The element to be inserted
    *
    * @throws IndexOutOfBoundsException if the index is out of range (index less than 0 || index greater than size())
    * @throws IllegalArgumentException if item is null
    */
   public void add(final int index, final T item)
   {
      if(size == 0)
         addFirst(item);
      else if(index>= size)
         addLast(item);
      else {
         Node curr = head;
         for (int i = 0; i < index; i++) {
            curr = curr.next;
         }
         Node temp = curr.next;
         curr.next = new Node(item);
         (curr.next).next = temp;
         size++;
      }


   }
   
   /**
    * Removes the last occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeLastOccurrence(final T item) {

      Node curr = this.head;
      int index = -1;
      if(this.contains(item)) {
         for (int i = 0; i <= size; i++) {
            if (String.valueOf(curr.data).equals(String.valueOf(item))) {
               index = i-1;
            }
            curr = curr.next;
         }
         this.remove(index);
         return true;
      }
      else{
         return false;
      }
   }

   /**
    * Removes the first occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeFirstOccurrence(final T item) {

      if(this.contains(item)){
         this.remove(this.indexOf(item));
         return true;
      }
      else {
         return false;
      }
   }

   /**
    * Appends the specified element to the end of this list.
    * 
    * @param item The element to be added to this list
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addLast(final T item)
   {
      if (item == null)
         throw new IllegalArgumentException("Invalid item");

      if (this.size == 0)
         this.addFirst(item);
      else
      {
         Node node = new Node(item);

         Node curr = this.head.next;
         while (curr.next != null)
            curr = curr.next;
         curr.next = node;
         this.size++;
      }

   }

   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String - Representing the contents of the list
    */
   public String toString()
   {
      String t ="[";
      Node curr = head.next;
      for(int i =0; i<size; i++){
         t += String.valueOf(curr.data);
         if(i!=size-1)
            t += ",";
         curr=curr.next;
      }
      t+= "]";

      return t;
   }
   
   /**
    * Returns true if this list contains the specified element. 
    * More formally, returns true if and only if this list contains at 
    * least one element AKA first occurrance
    *
    * @param item The element whose presence in this list is to be tested
    * @return boolean - true if this list contains the specified element
    *
    * @throws IllegalArgumentException if item is null
    */
   public boolean contains(final T item)
   {
      Node curr = this.head;
      for(int i=0; i<=size; i++){
         if(String.valueOf(curr.data).equals(String.valueOf(item)))
            return true;
         curr=curr.next;
      }


      return false;
   }
   
   

}