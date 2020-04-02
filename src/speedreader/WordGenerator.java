package speedreader;

import java.util.Scanner;
import java.io.File;

public class WordGenerator {
	
	// +--------+---------------------
	// | Fields |
	// +--------+
	private int wordCount = 0;
	private int sentenceCount = 0;
	private Scanner scr;
	
	// +-------------+-----------------------------------------
	// | Constructor |
	// +-------------+
	
	public WordGenerator(String filename) throws Exception{
		this.scr = new Scanner(new File(filename));
		
	} // WordGenerator(String)
	
	// +---------+--------------------------------------------
	// | Methods |
	// +---------+
	public boolean hasNext() {
		return scr.hasNext();
	} // hasNext()
	
	public String next() {
		String next = null;
		if(hasNext()) {
			wordCount++;
			next = scr.next();
			if(sentenceEnd(next))
				sentenceCount++;
		}
		return next;
	} // next()
	
	public static boolean sentenceEnd(String word) {
		char endChar = word.charAt(word.length() - 1);
		return (endChar == '.') || (endChar == '?') || (endChar == '!');
	} // sentenceEnd(String)
	
	public int getWordCount() {
		return wordCount;
	} // getWordCount()
	
	public int getSentenceCount() {
		return sentenceCount;
	} // getSentenceCount()
	
} // Class WordGenerator
