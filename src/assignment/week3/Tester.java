package assignment.week3;

import java.util.ArrayList;

import edu.duke.FileResource;

public class Tester {
	public void  testGetFollows() {
		String st = "this is a test yes this is a test.";
		MarkovOne markov = new MarkovOne();
		markov.setTraining(st);
		ArrayList<String> list = markov.getFollows("t");
		System.out.println("The result of calling getFollows(\"t\") : " + list + ", and its size: " + list.size());
		list = markov.getFollows("e");
		System.out.println("The result of calling getFollows(\"e\") : " + list + ", and its size: " + list.size());
		list = markov.getFollows("es");
		System.out.println("The result of calling getFollows(\"es\") : " + list + ", and its size: " + list.size());
		list = markov.getFollows(".");
		System.out.println("The result of calling getFollows(\".\") : " + list + ", and its size: " + list.size());
		list = markov.getFollows("t.");
		System.out.println("The result of calling getFollows(\"t.\") : " + list + ", and its size: " + list.size());
	}
	
	public void testGetFollowsWithFile() {
//		FileResource fr = new FileResource("data/confucius.txt");
		FileResource fr = new FileResource("data/melville.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setTraining(st);
//		ArrayList<String> list = markov.getFollows("t");
//		ArrayList<String> list = markov.getFollows("o");
		ArrayList<String> list = markov.getFollows("th");
		System.out.println(list.size());
	}
}
