package wordCount.store;

import java.util.ArrayList;
import java.util.List;


public class Results {
	private long wordCount;
	private long charCount;
	private long distinctWordCount;
	private List<String> maxWords;
	private int maxFreq;
	
	/**
	 * Constructor of class results
	 * intializes data members to 0.
	 */
	public Results() {
		
		this.wordCount = 0;
		this.charCount = 0;
		this.distinctWordCount = 0;
		this.maxWords = new ArrayList();
		this.maxFreq = 0;
	}
	
	 /**
	  * 
	  * @return maxFreq
	  */
	public int getMaxFreq() {
		return maxFreq;
	}

	/**
	 * 
	 * @param maxFreq
	 * 			maxFreq to set
	 */
	public void setMaxFreq(int maxFreq) {
		this.maxFreq = maxFreq;
	}

	/**
	 * This method adds a word to the array list
	 * of words with maxFreq
	 * @param word
	 */
	public void addWord(String word)
	{
		this.maxWords.add(word);
	}
	
	
	/**
	 * This method returns all words in maxwords in a string 
	 * @return wordlist
	 */
	public String getMaxWords() {
		StringBuilder wordlist = new StringBuilder();
		for(String s: this.maxWords)
		{
			wordlist.append(s);
			wordlist.append(",");
		}
		return wordlist.toString();
	}
	/**
	 * This method returns all words in maxwords in a string 
	 * @return wordlist
	 */
	@Override
	public String toString() {
		if (maxWords.isEmpty()) {
			return "";
		}
		StringBuilder listAsString = new StringBuilder();
		maxWords.stream().forEach(word -> {
			listAsString.append(word).append(",");
		});
		return listAsString.substring(0, listAsString.length() - 1);
	}

	public void setMaxWords(List<String> maxWords) {
		this.maxWords = maxWords;
	}

	public long getWordCount() {
		return wordCount;
	}
	public void setWordCount(long wordCount) {
		this.wordCount = wordCount;
	}
	public long getCharCount() {
		return charCount;
	}
	public void setCharCount(long charCount) {
		this.charCount = charCount;
	}
	public long getDistinctWordCount() {
		return distinctWordCount;
	}
	public void setDistinctWordCount(long distinctWordCount) {
		this.distinctWordCount = distinctWordCount;
	}

	public void clearMaxWords() {
		maxWords.clear();
	}

	
}
