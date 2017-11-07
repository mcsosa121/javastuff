package com.ms.ds.tests;

import com.ms.ds.Array;
import com.ms.ds.IArray;

public class ArrayTest {
		public static void main(String[] sa) {
			new ArrayTest().testIt();
		}
		
		private void testIt() {
			IArray<Integer> array = new Array<Integer>(6);
			System.out.println(array);
			System.out.println(array.get(0));
			for (int i=0; i<array.getSize(); i++) {
				array.set(i, i);
			}
			
			for (Integer j : array) {
				System.out.println(j);
			}
		}
}
