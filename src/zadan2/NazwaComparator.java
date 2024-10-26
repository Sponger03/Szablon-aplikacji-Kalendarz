package zadan2;

import java.util.Comparator;

public class NazwaComparator implements Comparator<Kontakt>{

	@Override
	public int compare(Kontakt o1, Kontakt o2) {

			  return o1.getNazwa().compareTo(o2.getNazwa());
	
		
		
	}
}
/*	public int compare(Kontakt o1, Kontakt o2, int x) {
switch(x) {
  case 1:
	  return o1.getNazwa().compareTo(o2.getNazwa());
  case 2:
	  return o1.getTelefon().compareTo(o2.getTelefon());
  case 3:
	  String a = String.valueOf(o1.getNrIndeksu());
	  String b = String.valueOf(o2.getNrIndeksu());
	  return a.compareTo(b); 
  default:
	  return o1.getNazwa().compareTo(o2.getNazwa());
}
*/