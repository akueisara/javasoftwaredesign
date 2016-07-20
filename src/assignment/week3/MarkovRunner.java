package assignment.week3;

/**
 * Generating Random Text
 * Assignment 1: MarkovZero and MarkovOne
 * Assignment 2: MarkovFour and MarkovModel
 * 
 * Word N-Grams
 * Assignment 1: Generating Random Words with Prediction
 * Assignment 2: MarkovWordTwo
 * 
 * @author Kuei
 * @version July 20, 2016
 */

import edu.duke.*;

public class MarkovRunner {
	
	public void runMarkovOne() {
//		FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
//		st = "this is a test yes a test";
		MarkovOne markov = new MarkovOne();
//		markov.setRandom(42);
		markov.setRandom(273);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
    public void runMarkovZero() {
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(88);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
    
    public void runMarkovFour() {
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
//		markov.setRandom(25);
		markov.setRandom(371);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
    }
    
    public void runMarkovModel() {
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
//		MarkovModel markov = new MarkovModel(6);
//		markov.setRandom(38);
		MarkovModel markov = new MarkovModel(8);
		markov.setRandom(365);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
    
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 
    
    public void testGetFollows() {
    	String s = "this is just a test yes this is a simple test";
		MarkovWordOne markovWord = new MarkovWordOne(); 
		markovWord.setTraining(s); 
		System.out.print(markovWord.getFollows("test")+"\n");
		System.out.print(markovWord.getFollows("is")+"\n");
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
//        FileResource fr = new FileResource(); 
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne(); 
//        runModel(markovWord, st, 200); 
//        runModel(markovWord, st, 120, 175); 
        runModel(markovWord, st, 120, 139); 
    } 
    
    public void testGetFollowsTwo() {
    	String s = "this is just a test yes this is a simple test";
		MarkovWordTwo markovWord = new MarkovWordTwo(); 
		markovWord.setTraining(s); 
		System.out.print(markovWord.getFollows("this", "is")+"\n");
		System.out.print(markovWord.getFollows("just", "a")+"\n");
    }
    
    public void runMarkovTwo() {
      FileResource fr = new FileResource("data/confucius.txt"); 
      String st = fr.asString(); 
      st = st.replace('\n', ' '); 
      MarkovWordTwo markovWord = new MarkovWordTwo(); 
//      runModel(markovWord, st, 120, 549); 
      runModel(markovWord, st, 120, 832);
    }
    
    
	
	private void printOut(String s){
		String[] words = s.split("\\s+"); // Split a string with any whitespace chars
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
}
