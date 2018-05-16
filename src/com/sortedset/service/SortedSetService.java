package com.sortedset.service;

import java.util.List;

import com.sortedset.dto.Element;

public interface SortedSetService {

	int addScore(int setId, int key, int score);
	int removeKey(int setId, int key);
	int getSize(int setId);
	int getKeyValue(int setId, int key);
	List<Element> getRange(List<Integer> setList, int lower, int upper);
}
