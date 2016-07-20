package assignment.week3;

/**
 * Word N-Grams
 * Assignment 2: MarkovWordTwo
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovWordTwo implements IMarkovModel  {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordTwo() {
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
		int index = myRandom.nextInt(myText.length-2);  // random word to start with
		String key1 = myText[index];
		String key2 = myText[index+1];
		sb.append(key1);
		sb.append(" ");
		sb.append(key2);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
//			System.out.print("Key \"" + key + "\" ");
		    ArrayList<String> follows = getFollows(key1, key2);
//		    System.out.println("is followed by: " + follows);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key1 = key2;
			key2 = next;
		}
		
		return sb.toString().trim();
	}	
	
	private int indexOf(String[] words, String target1, String target2, int start) {
		for(int k=start; k < words.length; k++) {
			if(words[k].equals(target1) && words[k+1].equals(target2)) {
				return k;
			}
		}
		return -1;
	}
	
	public void testIndexOf() {
		String s = "this is just a test yes this is a simple test";
		String[] words = s.split("\\s+");
        System.out.print(indexOf(words, "this", "is", 0) + "\n");
        System.out.print(indexOf(words, "is", "just", 0) + "\n");
        System.out.print(indexOf(words, "this", "is", 1) + "\n");
	}
	
	public ArrayList<String> getFollows(String key1, String key2) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		while(pos < myText.length) {
			int start = indexOf(myText, key1, key2, pos);
			if(start == -1) {
				break;
			}
			if(start >= myText.length - 1) {
				break;
			}
			String next = myText[start+2];
		    follows.add(next);
		    pos = start + 1;
		}
		return follows;
    }

}
