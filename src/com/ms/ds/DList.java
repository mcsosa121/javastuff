package com.ms.ds;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ms.ds.IDlist;

public class DList<T> implements IDlist<T>{
	private int size = 0;
	private DNode<T> head = null;
	private DNode<T> tail = null;

	

	@Override
	public T getFirst() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLast() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(T o) {
		DNode<T> temp = new DNode(o);
		head.setPrev(temp);
		temp.setNext(head);
		
		
	}

	@Override
	public void addLast(T o) {
		DNode<T> temp = new DNode(o);
		tail.setNext(temp);
		temp.setPrev(tail);
		this.tail = temp;
	}

	@Override
	public void removeFirst() throws NoSuchElementException {
		DNode<T> temp = head.getNext();
		temp.setPrev(null);
		head.setNext(null);
		head.setData(null);
		this.head = temp;
	}

	@Override
	public void removeLast() throws NoSuchElementException {
		DNode<T> temp = tail.getPrev();
		temp.setNext(null);
		tail.setPrev(null);
		tail.setData(null);
		this.tail = temp;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}
	@Override
	public Iterator<T> iterator() {
		return new DListIterator();
	}
	// Iterator
	private class DListIterator extends DList<T> implements java.util.Iterator<T> {
		private DNode<T> curr = null;
		private DNode<T> next = null;
		public DListIterator() {
			if (!isEmpty()) {
				if (size == 1) {
					curr = head;
					next = null;
				} else {
					curr = head;
					next = head.getNext();
				}
			}
		}
		@Override
		public boolean hasNext() {
			return next != null;
		}
		@Override
		public T next() {
			curr = next;
			if (curr.getNext() != null) {
				next = curr.getNext();
			}
			DNode<T> node = curr;
			return curr.getData();
		}
	}
	// DNode
	private class DNode<E> {
		private E data = null;
		private DNode<E> prev = null;
		private DNode<E> next = null;
		
		private DNode() {
			this.data = null;
			this.prev = null;
			this.next = null;
		}
		
		private DNode(E o) {
			this.data = o;
		}
		
		private DNode(E o, DNode<E> p, DNode<E> n) {
			this.data = o;
			this.prev = p;
			this.next = n;
		}
		
		E getData() {
			return data;
		}
		
		void setData(E o) {
			this.data = o;
		}
		
		DNode<E> getPrev() {
			return prev;
		}
		
		void setPrev(DNode<E> p) {
			this.prev = p;
		}
		
		DNode<E> getNext() {
			return next;
		}
		
		void setNext(DNode<E> n) {
			this.next = n;
		}
	}
}
