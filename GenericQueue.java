// Eric Demauro
// Queue implemented using linked lists

import java.util.Iterator;

public class GenericQueue<Item> implements Iterable<Item> {
	private Node first, last;
	private int n;
	
	private class Node{ // node definition
		Item data;
		Node next;
		
		public Node(Item dataVal){
			data = dataVal;
			next = null;
		}
	}
	
	public boolean isEmpty(){ return first == null; }
	
	public int size(){ return n; }
	
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
	
	public Item dequeue(){
		Item ret = first.data;
		first = first.next;
		if(isEmpty()){ // have to remove reference
			last = null;
		}
		n--;
		return ret;
	}
	
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
