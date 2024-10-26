package zadan2;

import java.util.Comparator;

/**
 * Sortowanie przez index
 */
	public class IndexComparator implements Comparator<Kontakt>{

		@Override
		public int compare(Kontakt o1, Kontakt o2) {

			 String a = String.valueOf(o1.getNrIndeksu());
			  String b = String.valueOf(o2.getNrIndeksu());
			  return a.compareTo(b); 
		
			
		}
	}