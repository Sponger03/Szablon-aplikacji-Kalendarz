package zadan2;

import java.util.Comparator;

/**
 * Sortowanie przez date
 */
public class DataComparator implements Comparator<Spotkanie>{

	@Override
	public int compare(Spotkanie o1, Spotkanie o2) {
		
		return o1.getOpis().compareTo(o2.getOpis());
		
	}
}