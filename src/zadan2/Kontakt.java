package zadan2;

import java.io.Serializable;
import java.util.Arrays;

/** 
 * Klasa kontaktu 
 */
public class Kontakt implements Comparable<Kontakt>, Serializable {
	
	/** 
	 * Konstruktor tworzący nowy obiekt Kontakt z danymi osoby
	 * @param nazwa Nazwa osoby
	 * @param telefon Numer telefonu osoby
	 * @param nrIndeksu Numer indeksu osoby
	 * @param czyZnajomy Informacja czy osoba jest znajomym
	 */
	public Kontakt(String nazwa, String telefon, String nrIndeksu, String czyZnajomy) {
		setNazwa(nazwa);
		setTelefon(telefon);
		setNrIndeksu(nrIndeksu);
		setCzyZnajomy(czyZnajomy);
	}

	/** 
	 * Zwraca nazwę kontaktu
	 * @return Nazwa kontaktu
	 */
	String getNazwa() {
		return nazwa;
	}

	/** 
	 * Ustawia nazwę kontaktu
	 * @param nazwa Nowa nazwa kontaktu
	 */
	void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	/** 
	 * Zwraca numer telefonu kontaktu
	 * @return Numer telefonu kontaktu
	 */
	String getTelefon() {
		return telefon;
	}

	/** 
	 * Ustawia numer telefonu kontaktu
	 * @param telefon Nowy numer telefonu kontaktu
	 */
	void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/** 
	 * Zwraca numer indeksu osoby w kontakcie
	 * @return Numer indeksu osoby
	 */
	int getNrIndeksu() {
		return nrIndeksu;
	}

	/** 
	 * Ustawia numer indeksu osoby w kontakcie
	 * @param nrIndeksu Nowy numer indeksu osoby
	 */
	void setNrIndeksu(String nrIndeksu) {
		int index = Integer.parseInt(nrIndeksu);
		this.nrIndeksu = index;
	}

	/** 
	 * Sprawdza, czy osoba z kontaktu jest znajomym
	 * @return True jeśli osoba jest znajomym, False w przeciwnym przypadku
	 */
	boolean isCzyZnajomy() {
		return czyZnajomy;
	}

	/** 
	 * Ustawia informację, czy osoba z kontaktu jest znajomym
	 * @param czyZnajomy Informacja o znajomości osoby
	 */
	void setCzyZnajomy(String czyZnajomy) {
		this.czyZnajomy = Boolean.parseBoolean(czyZnajomy);
	}

	/** 
	 * Zwraca spotkania, do których należy osoba z kontaktu
	 * @return Tablica spotkań, do których należy osoba
	 */
	Spotkanie[] getSpotkania() {
		return spotkania;
	}

	/** 
	 * Ustawia spotkania, do których należy osoba z kontaktu
	 * @param spotkania Nowa tablica spotkań
	 */
	void setSpotkania(Spotkanie[] spotkania) {
		this.spotkania = spotkania;
	}
	
	/** 
	 * Nazwa osoby w kontakcie
	 */
	private String nazwa;
	/** 
	 * Numer telefonu osoby w kontakcie 
	 */
	private String telefon;
	/** 
	 * Numer indeksu osoby z kontaktu
	 */
	private int nrIndeksu;
	/** 
	 * Czy osoba z kontaktu jest znajomym
	 */
	private boolean czyZnajomy;
	/** 
	 * Do jakich spotkań należy osoba
	 */
	private Spotkanie[] spotkania;
	
	@Override
	public String toString() {
		return "Kontakt [nazwa=" + nazwa + ", telefon=" + telefon + ", nrIndeksu=" + nrIndeksu + ", czyZnajomy="
				+ czyZnajomy + ", spotkania=" + Arrays.toString(spotkania) + "]";
	}

	@Override
	public int compareTo(Kontakt other) {
		int result = this.getNazwa().compareTo(other.getNazwa());
		return result;
	}
	}
	