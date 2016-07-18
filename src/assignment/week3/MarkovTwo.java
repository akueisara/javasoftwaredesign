package assignment.week3;

/**
 * Generating Random Text
 * Assignment 2: MarkovFour and MarkovModel
 * 
 * @author Kuei
 * @version July 11, 2016
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovTwo implements IMarkovModel {
	private String myText;
	private Random myRandom;

	public MarkovTwo() {
		myRandom = new Random();
	}

	public void setRandom(int seed){
		myRandom = new Random(seed);
	}

	public void setTraining(String s){
		myText = s.trim();
	}

	public ArrayList<String> getFollows(String key) {
		int len = key.length();
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<myText.length()-len;i++) {
			if (key.equals(myText.substring(i, i+len))){
				result.add(myText.substring(i+len, i+len+1));
			}
		}
		return result;
	}

	public String getRandomText(int numChars){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length()-2);
		String key = myText.substring(index, index+2);
		sb.append(key);
		for(int k=0; k < numChars-2; k++){
			ArrayList<String> follows = getFollows(key);
			//				System.out.println("key " + key + " " + follows);
			if(follows.size() == 0){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next;
		}
		return sb.toString();
	}
}
