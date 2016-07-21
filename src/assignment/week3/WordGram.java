package assignment.week3;

/**
 * WordGram Class
 * Assignment 1: Complete WordGram
 * Assignment 3: EfficientMarkovWord with WordGram
 * 
 * @author Kuei
 * @version July 20, 2016
 */

public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for(int k=0; k < myWords.length; k++) {
        	ret += myWords[k] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // compare me to other
        if(this.length() != other.length())
        	return false;
        for(int k=0; k < myWords.length; k++) {
        	if(!myWords[k].equals(other.wordAt(k))) {
        		return false;
        	}
        }
        return true;

    }

    public WordGram shiftAdd(String word) {	       
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        String[] newWords = new String[this.length()];
        for (int i=0;i<newWords.length-1;i++) {
        	newWords[i] = this.wordAt(i+1);
        }
        newWords[newWords.length-1] = word;
        WordGram out = new WordGram(newWords, 0, newWords.length);
        return out;
    }
    
    public int hashCode() {
    	return toString().hashCode();
    }
}