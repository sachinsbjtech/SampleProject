package com.sbj.nonlinearDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceSimilarity2 {

	public static void main(String[] args) {
		String words1[] = {"great", "acting", "skills"};
		String words2[] = {"fine", "drama", "talent"};
		String pairs[][] = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
		System.out.println(new SentenceSimilarity2().checkSentenceSimilarity(words1, words2, pairs));
	}
	
	public boolean checkSentenceSimilarity(String word1[], String word2[], String pairs[][]) {
		boolean isSentenseSimilar = false;
		if(word1.length == word2.length) {
			List<String> word1List = Arrays.asList(word1);
			List<String> word2List = Arrays.asList(word2);
			if(pairs.length == 0 ) {
				// check if similar words present in both array
				isSentenseSimilar = word1List.containsAll(word2List);
			}else {
				for(int i = 0; i < word1.length ; i++) {
					int firstWordIndex = findIndexOfSubSetItem(word1[i], pairs);
					int secondWordIndex = findIndexOfSubSetItem(word2[i], pairs);
					if(firstWordIndex == secondWordIndex) {
						// words are similar
						isSentenseSimilar = true;
						continue;
					}
					else if(firstWordIndex !=-1 && secondWordIndex != -1) {
						isSentenseSimilar = checkIfWordsSimilarity(firstWordIndex, secondWordIndex, pairs);
						if(!isSentenseSimilar) {
							break;
						}
					}else {
						isSentenseSimilar = false;
						break;
					}
				}
			}
				
		}
		return isSentenseSimilar;
	}
	
	private boolean checkIfWordsSimilarity(int firstWordIndex, int secondWordIndex, String[][] pairs) {
		// Compare firstWordIndex List and secondWordIndex List has Transitive similarity
		List<String> firstIndexPair = Arrays.asList(pairs[firstWordIndex]);
		List<String> secondIndexPair = Arrays.asList(pairs[secondWordIndex]);
		for(String item : firstIndexPair) {
			if(secondIndexPair.contains(item)) {
				return true;
			}
		}
		return false;
	}

	private int findIndexOfSubSetItem(String word, String pairs[][]) {
		for(int i =0; i< pairs.length; i++) {
			for(int j =0 ; j < pairs[i].length ; j++) {
				if(word.equals(pairs[i][j])) {
					return i;
				}
			}
		}
		return -1;
	}

}
