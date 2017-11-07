package com.ms.ds;

import com.ms.ds.ISList;

import java.util.NoSuchElementException;

@SuppressWarnings("unused")
public class SList<T> implements ISList<T> {
	private SNode<T> head = null;
	private SNode<T> tail = null;
	private int size = 0;

	@Override
	public T getFirst() throws java.util.NoSuchElementException {
	    return head.getData();
	}
	@Override
	public T getLast() throws java.util.NoSuchElementException {
		return tail.getData();
	}
	
	@Override
	public void addFirst(T o) {
	    if (size == 0) {
	        this.head = new SNode<T>(o);
	        this.tail = head;
        } else if (size == 1) {
	        SNode<T> h = new SNode<T>(o, head);
	        this.head = h;
        } else {
	        SNode<T> temp = head;
	        this.head = new SNode<T>(o,temp);
        }
        this.size++;
    }
	@Override
	public void addLast(T o) {
	    if (size == 0) {
	        this.head = new SNode<T>(o);
	        this.tail = head;
        } else if (size == 1) {
	        // head = tail
            SNode<T> n = new SNode<T>(o);
            this.head.setNext(n);
            this.tail = n;
        } else {
            SNode<T> n = new SNode<T>(o);
            this.tail.setNext(n);
            this.tail = n;
        }
        this.size++;
    }
	@Override
	public void removeFirst() throws java.util.NoSuchElementException {
		if (head == null) {
		    throw new NoSuchElementException();
        } else if (size == 1) {
		    this.head = null;
		    this.tail = null;
        } else {
		    SNode<T> temp = head.getNext();
		    head.setNext(null);
		    head.setData(null);
		    this.head = temp;
        }
		this.size--;
	}

	@Override
    public void removeLast() throws java.util.NoSuchElementException {
	    if (tail == null) {
	        throw new NoSuchElementException();
        } else if (size == 1) {
	        this.head = null;
	        this.tail = null;
        } else {
	        SNode<T> temp = head;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            this.tail = temp;
        }
        this.size--;
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
	public java.util.Iterator<T> iterator() {
		// Do not implement for now
		return null;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("< ");
		SNode<T> node = head;
		while (node != null) {
			if (node.getData() != null) {
				sb.append(node.getData().toString() + " ");
			} else {
				sb.append("null ");
			}
			node = node.next;
		}
		sb.append(">");
		return sb.toString();
	}
	private boolean hasNext(SNode<T> n) throws IllegalArgumentException {
		return  n.getNext() == null;
	}

	private class SNode<E> {
		private SNode<E> next = null;
		private E data = null;

		private SNode() {
		    this.data = null;
		    this.next = null;
        }
        private SNode(E d) {
		    this.data = d;
		    this.next = null;
        }
		private SNode (E d, SNode<E> n) {
		    this.data = d;
		    this.next = n;
        }

		SNode<E> getNext() {
		    return next;
		}
		void setNext(SNode<E> n) {
		    this.next = n;
		}
		E getData() {
		    return data;
		}
		void setData(E o) {
			this.data = o;
		}
	}
}