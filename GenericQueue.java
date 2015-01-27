// Eric Demauro
// Queue implemented using linked lists

import java.util.Iterator;

public class GenericQueue<Item> implements Iterable<Item> {
	private Node first, last;
	private int n;
	
	// node definition
	private class Node{
		Item data;
		Node next;
		
		public Node(Item dataVal){
			data = dataVal;
			next = null;
		}
	}
	
	// isEmpty
	public boolean isEmpty(){ return first == null; }
	
	// size
	public int size(){ return n; }
	
	// enqueue
	public void enqueue(Item dataVal){
		Node temp = last;
		last = new Node(dataVal);
		if(isEmpty()){
			first = last;
		} else {
			temp.next = last;
		}
		n++;
	}
	
	// dequeue
	public Item dequeue(){
		Item ret = first.data;
		first = first.next;
		if(isEmpty()){ // have to remove reference
			last = null;
		}
		n--;
		return ret;
	}
	
	// iterator
	public Iterator<Item> iterator(){ return new QueueIterator(); }
	
	private class QueueIterator implements Iterator<Item>{
		private Node cur = first;
		
		public boolean hasNext(){ return cur != null; }
		public Item next(){
			Item ret = cur.data;
			cur = cur.next;
			return ret;
		}
		public void remove(){}
	}
}
