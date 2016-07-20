package assignment.week3;

/**
 * Interface and Abstract Class
 * Assignment 2: AbstractMarkovModel Abstract Class
 * 
 * @author Kuei
 * @version July 17, 2016
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed); 
    
    public String getRandomText(int numChars);   
    
}
