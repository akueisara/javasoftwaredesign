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
 * WordGram Class
 * Assignment 2: MarkovWord with WordGram
 * Assignment 3: EfficientMarkovWord with WordGram
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
    
    public void runMarkovWord() {
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
//        MarkovWord markovWord = new MarkovWord(3);
        MarkovWord markovWord = new MarkovWord(5);
//        runModel(markovWord, st, 120, 643);
//        runModel(markovWord, st, 120, 621);
        runModel(markovWord, st, 120, 844);
    }
    
    public void testHashMap() {
//        String st = "this is a test yes this is really a test";
//    	String st = "this is a test yes this is really a test yes a test this is wow";
        FileResource fr = new FileResource("data/confucius.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        EfficientMarkovWord efficientMarkovWord = new EfficientMarkovWord(2);
//        EfficientMarkovWord efficientMarkovWord = new EfficientMarkovWord(3);
//        runModel(efficientMarkovWord, st, 120, 42);
//        runModel(efficientMarkovWord, st, 50, 42);
//        runModel(efficientMarkovWord, st, 50, 371);
        runModel(efficientMarkovWord, st, 50, 65);
    }
    
    public void compareMethods(){
        FileResource fr = new FileResource("data/hawthorne.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int seed = 42;
		int size = 100;
		
		double startTime = System.nanoTime();
        MarkovWord mTwo = new MarkovWord(2);
        runModel(mTwo, st, size, seed);
        double endTime = System.nanoTime();
        System.out.println("The running time of MarkovWord is " + (endTime-startTime)/ 1000000000.0 + " seconds");
		
        startTime = System.nanoTime();
		EfficientMarkovWord emw = new EfficientMarkovWord(2);
        runModel(emw, st, size, seed);
        endTime = System.nanoTime();
        System.out.println("The running time of EfficientMarkovWord is " + (endTime-startTime)/ 1000000000.0 + " seconds");
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
