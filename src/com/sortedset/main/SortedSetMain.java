package com.sortedset.main;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sortedset.impl.SortedSetServiceImpl;
import com.sortedset.service.SortedSetService;

public class SortedSetMain {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		boolean flag = true;
		
		SortedSetService sortedSetService = new SortedSetServiceImpl();
		
		while(flag==true){
			
			ExecutorService execService = Executors.newCachedThreadPool();
			
			int n = in.nextInt();
			
			int index = in.nextInt();
				
			Runnable threadTemp = null;
				switch(index){
				
					case 1:
						
						int setId = in.nextInt();
						int key = in.nextInt();
						int score = in.nextInt();
						
						threadTemp = new Runnable() {
						    public void run() {
						        try {
						        	
						        System.out.println(sortedSetService.addScore(setId, key, score));

						        } catch (Exception e) {
						            System.out.println("Exception thrown " + e);
						        }
						    }
						 };
						
						//System.out.println(sortedSetService.addScore(setId, key, score));
						break;
						
					case 2:
						int setId2 = in.nextInt();
						int key2 = in.nextInt();
						threadTemp = new Runnable() {
						    public void run() {
						        try {
						        	
									
						        System.out.println(sortedSetService.removeKey(setId2, key2 ));

						        } catch (Exception e) {
						            System.out.println("Exception thrown " + e);
						        }
						    }
						 };
						
						//System.out.println(sortedSetService.removeKey(setId, key));
						break;
					
					case 3:
						int setId3 = in.nextInt();
						
						threadTemp = new Runnable() {
						    public void run() {
						        try {
						        	
						        System.out.print("1 ");
						        System.out.println(sortedSetService.getSize(setId3));

						        } catch (Exception e) {
						            System.out.println("Exception thrown " + e);
						        }
						    }
						 };
						
						//System.out.println(sortedSetService.getSize(setId));
						break;
						
					case 4:
						int setId4 = in.nextInt();
						int key4 = in.nextInt();
						threadTemp = new Runnable() {
						    public void run() {
						        try {						        	
						        System.out.print("1 ");
						        System.out.println(sortedSetService.getKeyValue(setId4, key4 ));

						        } catch (Exception e) {
						            System.out.println("Exception thrown " + e);
						        }
						    }
						 };
						
						//System.out.println(sortedSetService.getKeyValue(setId, key));
						break;
					
					case 6:
						
						flag = false;
						break;					
				
				}
				if(threadTemp!=null)
					execService.execute(threadTemp);
				
				if(!flag)
					execService.shutdown();
		}
		
	}

}
