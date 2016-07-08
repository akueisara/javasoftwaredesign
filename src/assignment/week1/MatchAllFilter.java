package assignment.week1;

import java.util.ArrayList;

public class MatchAllFilter implements Filter {
	private ArrayList<Filter> filters;
	public MatchAllFilter() {
		filters = new ArrayList<Filter>();
	}
	public void addFilter(Filter f){
		filters.add(f);
	}
	// fields and constructors elided
	public boolean satisfies(QuakeEntry qe){
		for(Filter f: filters){
			if(!f.satisfies(qe)){
				return false;
			}
		}
		return true;
	}
	
	public String getName(){
		StringBuilder s = new StringBuilder();
		for(Filter f: filters){
			s.append(f.getName()+ " ");
		}
		return s.toString();
	}
}
