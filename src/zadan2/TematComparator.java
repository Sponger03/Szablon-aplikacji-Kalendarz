package zadan2;

import java.util.Comparator;

public class TematComparator implements Comparator<Spotkanie>{

	@Override
	public int compare(Spotkanie o1, Spotkanie o2) {
		
		return o1.getTemat().compareTo(o2.getTemat());
		
	}
}