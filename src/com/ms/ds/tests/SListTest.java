package com.ms.ds.tests;

import com.ms.ds.ISList;
import com.ms.ds.SList;

public class SListTest { 	
	public static void main(String[] sa) { 		
		new SListTest().doIt(); 	
	} 	
	
	private void doIt() { 		
		ISList<Integer> slist = new SList<>(); 		
		slist.addFirst(173); 		
		slist.addLast(15); 		
		slist.addLast(17); 		
		slist.addFirst(27); 		
		// The list 		
		System.out.println(slist); 		
		// The last 		
		System.out.println("First"); 		
		System.out.println(slist.getLast()); 		
		System.out.println(slist.isEmpty()); 		
		System.out.println(slist.getSize()); 		
		// The first 		
		System.out.println("Last"); 		
		System.out.println(slist.getFirst()); 		
		// Size 		
		System.out.println("Size"); 		
		System.out.println(slist.getSize()); 		
		// Remove 27 		
		System.out.println("Removing First"); 		
		slist.removeFirst(); 		
		System.out.println("New First"); 		
		System.out.println(slist.getFirst()); 		
		System.out.println(slist.getLast()); 		
		System.out.println(slist); 
		//		slist.removeFirst(); 		
		slist.removeLast(); 		
		slist.removeLast(); 		
		System.out.println(slist.getFirst()); 		
		System.out.println(slist.getLast()); 		
		System.out.println(slist); 
		//		slist.removeFirst(); 		
		slist.removeLast(); 		
		System.out.println(slist); 		
		System.out.println(slist.isEmpty()); 		
		System.out.println(slist.getSize()); 		
		System.out.println("New first"); 		
		slist.addFirst(2); 		
		System.out.println(slist.getFirst()); 		
		System.out.println(slist.getLast()); 		
		slist.addLast(5); 		
		slist.addFirst(7); 		
		System.out.println(slist); 		
		slist.removeFirst(); 		
		slist.removeFirst(); 		
		slist.removeFirst(); 		
		slist.addLast(3); 		
		slist.addFirst(2); 		
		slist.addLast(4); 		
		slist.addFirst(1); 		
		System.out.println(slist); 	
		} 
	}
