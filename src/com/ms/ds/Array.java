package com.ms.ds;

import java.util.Iterator;

import com.ms.ds.IArray;

public class Array<T> implements IArray<T>  {
	private Object[] theArray;
	
	public Array(int size) throws ArrayIndexOutOfBoundsException {
		if (size > 0) {
			this.theArray = new Object[size];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws ArrayIndexOutOfBoundsException {
		checkIndex(index);
		return (T) this.theArray[index];
	}

	@Override
	public void set(int index, T o) throws ArrayIndexOutOfBoundsException {
		checkIndex(index);
		this.theArray[index] = o;
	}

	@Override
	public int getSize() {
		return this.theArray.length;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		for (Object o : this.theArray) {
			if (o != null) {
				sb.append(o.toString()+" ");
			} else {
				sb.append("null ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	private void checkIndex(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > theArray.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
	
	private class ArrayIterator implements java.util.Iterator<T> {
		private int currInd = 0;
		public ArrayIterator() {
			currInd = 0;
		}
		
		@Override
		public boolean hasNext() {
			return currInd < theArray.length;
			
		}
		
		@SuppressWarnings("unchecked")
		public T next() {
			return (T) theArray[currInd++];
		}
	}

}
