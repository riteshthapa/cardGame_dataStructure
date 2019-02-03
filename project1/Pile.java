package project1;

import java.util.NoSuchElementException;

/*
 * Written by - Ritesh Thapa
 * Prof. Tim Gegg-Harrison
 * Project 01
 * 
 * 1/25/2018
 * 
 */

public class Pile<AnyType> implements Iterable<AnyType> {
	
	public static class Node<AnyType> { 

		/*
		 *  constructor
		 */
		public Node(AnyType d, Node<AnyType> n) { 
            data = d;
            next = n;
        }      
        
        /*
         * every node has 2 fields data(info) & next(reference)
         */
        private AnyType data;
        protected Node<AnyType> next;
    }

	protected int theSize;
	protected Node<AnyType> head;
	
	public Pile() {
        clear();
    }
	
	/*
	 * gets the size the pile 
	 */
	
	 public int size () {
		 int size = 0;
		 Node<AnyType> Cur = head;
		 while(Cur != null){
			 Cur = Cur.next;
			 size++;     
		 }
		 return size;
	 }

	/*
	 * indicates whether the pile is empty or not
	 */
	public boolean isEmpty() {
		 return size() == 0;
    }

	/*
	 *  should make the pile empty
	 */
	public void clear() { 
		head = null;
		theSize = 0;
	}
	
	/*
	 *  inserts the given elements at the beginning of the pile
	 */
	public void add(AnyType x){
      head = new Node<AnyType>(x, head);
	}

	private AnyType getFirst() {
		if(head == null) throw new NoSuchElementException();
		return head.data;
	}
	
	/*
	 * should return the first element of the pile and remove it from the pile
	 * 
	 */ 
	public AnyType remove(){
	   AnyType tmp = getFirst();
	   head = head.next;
	   return tmp;
	}
	
	/*
	 *  adds value as per the given index 
	 */
	public void addIndexVal(int index, AnyType x) {
		// TODO Auto-generated method stub
		if(index > size()) {
            throw new IndexOutOfBoundsException();
        }
    	if (index == 0) {
    		head = new Node<>(x, head);
    	}
    	else {
    		Node<AnyType> current = head;
            for(int i = 0; i < index - 1; ++i) {
            	current = current.next;
            }
            current.next = new Node<>(x, current.next);
    	}
        theSize++;
	}

	/*
	 * removes value as per the given index
	 */
	public AnyType removeIndexVal(int index) {
		AnyType data;
    	if(index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    	if (index == 0) {
    		data = head.data;
    		head = head.next;
    	} else {
			Node<AnyType> prev = null;
    		Node<AnyType> current = head;
            for(int i = 0; i < index; ++i) {
				prev = current;
				current = prev.next;
            }
            data = current.data;
            prev.next = current.next;
    	}
        theSize--;        
        return data;
    }
	
	
	
	// add last 
	 public void addLast(AnyType item)
	   {
	      if( head == null)
	         add(item);
	      else
	      {
	         Node<AnyType> tmp = head;
	         while(tmp.next != null) tmp = tmp.next;

	         tmp.next = new Node<AnyType>(item, null);
	      }
	   }
	
	
	
	
	
	/*
	 *  Pile_iterator
	 */
	public java.util.Iterator<AnyType> iterator() {
        return new PileIterator();
    }

    private class PileIterator implements java.util.Iterator<AnyType> {
        private Node<AnyType> current;
        
        public PileIterator() {
        	current = head;
        }
        
        public boolean hasNext() {
            return current != null;
        }
        
        public AnyType next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }                  
            AnyType nextItem = current.data;
            current = current.next;
            return nextItem;
        }
    }
}