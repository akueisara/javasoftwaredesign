package assignment.week3;

/**
 * WordGram Class
 * Assignment 3: EfficientMarkovWord with WordGram
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
	private HashMap<WordGram, ArrayList<String>> myMap;
    
    public EfficientMarkovWord(int n) {
    	myMap = new HashMap<WordGram, ArrayList<String>>();
        myOrder = n;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
		buildMap();
		printHashMapInfo();
	}
    
    public void buildMap() {
    	for(int i=0;i<myText.length-(myOrder-1);i++) {
    		WordGram wg = new WordGram(myText,i,myOrder);
    		String next = "";
			if(i+myOrder<myText.length)
				next = myText[i+myOrder];
    		if (myMap.containsKey(wg)) {
    			myMap.get(wg).add(next);
    		}
    		else {
    			ArrayList<String> list = new ArrayList<String>();
    			list.add(next);
    			myMap.put(wg, list);
    		}
    	}
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
		    if(follows == null){
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
	
	public ArrayList<String> getFollows(WordGram kGram) {
		return myMap.get(kGram);
    }
	
	public void printHashMapInfo() {
		
		System.out.println("It has " +  myMap.size() + " keys in the HashMap");
		int maxSize = 0;
		for (WordGram wg : myMap.keySet()) {
			maxSize = Math.max(maxSize, myMap.get(wg).size());
//			System.out.printf("Key:\t[%s]\tvalues: ", wg);
//			System.out.println(myMap.get(wg));
		}
        System.out.println("The maximum number of elements following a key is " + maxSize);

		System.out.println("Keys with the maximum size value: ");
        for (WordGram wg : myMap.keySet()) {
        	if (myMap.get(wg).size()==maxSize) {
        		System.out.print(wg);
        		System.out.println(" (The follow words: " + myMap.get(wg) + ")");
        	}
        }
        
	}

}
