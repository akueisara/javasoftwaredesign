package assignment.week3;

/**
 * Generating Random Text
 * Assignment 2: MarkovFour and MarkovModel
 * 
 * Interface and Abstract Class
 * Assignment 1: IMarkovModel Interface
 * Assignment 2: AbstractMarkovModel Abstract Class
 * 
 * @author Kuei
 * @version July 11, 2016
 */

import java.util.ArrayList;
import java.util.Random;

//public class MarkovModel implements IMarkovModel {
public class MarkovModel extends AbstractMarkovModel {
//    private String myText;
//	private Random myRandom;
//	private int myOrder;
	
	public MarkovModel(int n) {
        myRandom = new Random();
        myOrder = n;
    }
	
//	public void setRandom(int seed){
//		myRandom = new Random(seed);
//	}
//	
//	public void setTraining(String s){
//		myText = s.trim();
//	}
	
//	public ArrayList<String> getFollows(String key) {
//		int len = key.length();
//		ArrayList<String> result = new ArrayList<String>();
//		for(int i=0;i<myText.length()-len;i++) {
//			if (key.equals(myText.substring(i, i+len))){
//				result.add(myText.substring(i+len, i+len+1));
//			}
//		}
//		return result;
//	}
	
	public String getRandomText(int length){
		if (myText == null) {
            return "";
        }
		StringBuffer sb = new StringBuffer();
		int index = myRandom.nextInt(myText.length()-myOrder);
		String current = myText.substring(index, index+myOrder);
		sb.append(current);
		for(int k=0; k < length-myOrder; k++){
			ArrayList<String> follows = getFollows(current);
			if(follows.size() == 0){
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			current = current.substring(1) + next;
		}
		return sb.toString();
	}
	
	@Override
	public String toString(){
		return String.format("MarkovModel of order %d", myOrder);
	}
}
