package com.ms.ds;

public interface IArray<T> extends Iterable<T> {
	public T get(int index) throws ArrayIndexOutOfBoundsException;
	public void set(int index, T o) throws ArrayIndexOutOfBoundsException;
	public int getSize();
	public String toString();
}
