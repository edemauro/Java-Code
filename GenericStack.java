// Eric Demauro

import java.util.Iterator;

public class GenericStack<Item> implements Iterable<Item>{
	private Item[] data; // array to hold stack items
	private int; // number of elements in array
	
	// ctor
	public GenericStack(int maxSize){
		data = (Item[]) new Object[maxSize]; // have to cast.
		n = 0;
	}
	
	// isEmpty
	public boolean isEmpty(){ return n == 0; }
	
	// size of array
	public int size(){ return n; }
	
	// push
	public void push(Item dataVal){ 
		if(n == data.length){
			resize();
		}
		data[n++] = dataVal; 
	}
	
	// pop
	public Item pop(){ return data[--n]; }
	
	// resize
	private void resize(){
		Item[] temp = (Item[]) new Object[2*data.length];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	// iterator
	public Iterator<Item> iterator() { return new StackIterator(); }
	
	private class StackIterator implements Iterator<Item>{
		private int i = n;
		
		public boolean hasNext(){ return i > 0; }
		public Item next(){ return data[--i]; }
		public void remove(){}
	}
}

