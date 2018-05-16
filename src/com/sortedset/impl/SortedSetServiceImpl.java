package com.sortedset.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.sortedset.dto.Element;
import com.sortedset.service.SortedSetService;

public class SortedSetServiceImpl implements SortedSetService  {
	
	static Map<Integer, TreeMap<Integer, Integer>> sortedSetMap = new HashMap<>();
	
	TreeMap<Integer, Integer> createSet(int setId){
		
		TreeMap<Integer, Integer> tempSet = new TreeMap<Integer, Integer>();
		
		sortedSetMap.put(setId, tempSet);
		
		return tempSet;
	}
	@Override
	public synchronized int addScore(int setId, int key, int score) {
		
		TreeMap<Integer, Integer> setName = sortedSetMap.get(setId);
		if(setName!=null){
			setName.put(key, score);
		}
		else{
		
			setName = createSet(setId);
			setName.put(key, score);
			
			//System.out.println("##" +sortedSetMap.get(setId));
			
		}
		
		return 0;
	}

	@Override
	public synchronized int removeKey(int setId, int key) {
		
		TreeMap<Integer, Integer> setName = sortedSetMap.get(setId);
		
		if(setName!=null){
			setName.remove(key);
		}		
		
		return 0;
	}

	@Override
	public int getSize(int setId) {
		
		TreeMap<Integer, Integer> setName = sortedSetMap.get(setId);
		//System.out.println("##");
		if(setName!=null){
			//System.out.println("#" + setName.size());
			return setName.size();
		}
		
		return 0;
	}

	@Override
	public int getKeyValue(int setId, int key) {
		
		TreeMap<Integer, Integer> setName = sortedSetMap.get(setId);
		
		if(setName!=null){
			Integer value = setName.get(key);
			if(value!=null){
				return value;
			}
		}
		
		return 0;
	}
	@Override
	public List<Element> getRange(List<Integer> setList, int lower, int upper) {
		
		Iterator itr = setList.iterator();
		
		while(itr.hasNext()){
			
			int setId = (int)itr.next();			
			
			TreeMap<Integer, Integer> responseSet = sortedSetMap.get(setId);
			if(responseSet!=null){
				responseSet.subMap(lower, upper);
			}
		}
		
		return null;
	}
	
	
}
