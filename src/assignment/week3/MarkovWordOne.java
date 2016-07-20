package assignment.week3;

/**
 * Word N-Grams
 * Assignment 1: Generating Random Words with Prediction
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
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
			key = next;
		}
		
		return sb.toString().trim();
	}	
	
	private int indexOf(String[] words, String target, int start) {
		for(int k=start; k < words.length; k++) {
			if(words[k].equals(target)) {
				return k;
			}
		}
		return -1;
	}
	
	public void testIndexOf() {
		String s = "this is just a test yes this is a simple test";
		String[] words = s.split("\\s+");
		System.out.print(indexOf(words, "this", 0) + "\n");
		System.out.print(indexOf(words, "this", 3) + "\n");
		System.out.print(indexOf(words, "frog", 0) + "\n");
		System.out.print(indexOf(words, "frog", 5) + "\n");
		System.out.print(indexOf(words, "simple", 2) + "\n");
		System.out.print(indexOf(words, "test", 5) + "\n");
	}
	
	public ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		while(pos < myText.length) {
			int start = indexOf(myText, key, pos);
			if(start == -1) {
				break;
			}
			if(start >= myText.length - 1) {
				break;
			}
			String next = myText[start+1];
		    follows.add(next);
		    pos = start + 1;
		}
		return follows;
    }

}
