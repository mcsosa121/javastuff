package com.ms.ds;

public interface IDlist<T> extends Iterable<T> {
	T getFirst() throws java.util.NoSuchElementException;
	T getLast() throws java.util.NoSuchElementException;
	void addFirst(T o);
	void addLast(T o);
	void removeFirst() throws java.util.NoSuchElementException;
	void removeLast() throws java.util.NoSuchElementException;
	int getSize();
	boolean isEmpty();
	String toString();
}
