package assignment.week3;

/**
 * Interface and Abstract Class
 * Assignment 2: AbstractMarkovModel Abstract Class
 * 
 * @author Kuei
 * @version July 17, 2016
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
	protected int myOrder;
	
	public AbstractMarkovModel() {
		myRandom = new Random();
    }
    
    public AbstractMarkovModel(int n) {
        myRandom = new Random();
        myOrder = n;
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    public void setRandom(int seed)
    {
    	myRandom = new Random(seed);
    }
 
    abstract public String getRandomText(int numChars);
    
	protected ArrayList<String> getFollows(String key) {
		int len = key.length();
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<myText.length()-len;i++) {
			if (key.equals(myText.substring(i, i+len))){
				result.add(myText.substring(i+len, i+len+1));
			}
		}
		return result;
	}
}
