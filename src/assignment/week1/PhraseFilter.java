package assignment.week1;

/**
 * Assignment
 * Implementing Filters
 * 
 * @version July 7, 2016
 */

public class PhraseFilter implements Filter{
	private String indicator;
	private String phrase;

	public PhraseFilter(String i, String p) { 
		indicator = i;
		phrase = p;
	}

	public boolean satisfies(QuakeEntry qe) { 
		if(indicator.equals("start")) {
			return qe.getInfo().startsWith(phrase);
		}
		else if (indicator.equals("any")) {
			return qe.getInfo().contains(phrase);
		}
		else if (indicator.equals("end")) {
			return qe.getInfo().endsWith(phrase);
		}
		return false;
	} 
	
	
	public String getName(){
		return "PhraseFilter";
	}
}
