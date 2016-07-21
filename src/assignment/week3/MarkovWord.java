package assignment.week3;

/**
 * WordGram Class
 * Assignment 2: MarkovWord with WordGram
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord(int n) {
        myRandom = new Random();
        myOrder = n;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
		WordGram key = new WordGram(myText,index,myOrder);
		sb.append(key.toString());
		sb.append(" ");
		for(int k=0; k < numWords-myOrder; k++){
//			System.out.print("Key \"" + key + "\" ");
		    ArrayList<String> follows = getFollows(key);
//		    System.out.println("is followed by: " + follows);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = key.shiftAdd(next);
		}
		
		return sb.toString().trim();
	}	
	
	private int indexOf(String[] words, WordGram target, int start) {
		for(int k=start; k < words.length - myOrder; k++) {
			WordGram wg = new WordGram(words,k,myOrder);
			if(wg.equals(target)) {
				return k;
			}
		}
		return -1;
	}
	
	public ArrayList<String> getFollows(WordGram kGram) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		while(pos < myText.length) {
			int start = indexOf(myText, kGram, pos);
			if(start == -1) {
				break;
			}
			if(start >= myText.length - 1) {
				break;
			}
			String next = myText[start+myOrder];
		    follows.add(next);
		    pos = start + 1;
		}
		return follows;
    }

}
