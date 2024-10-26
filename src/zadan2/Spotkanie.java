package zadan2;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Arrays;

/** 
 * Klasa reprezentująca spotkanie
 */
class Spotkanie implements Comparable<Spotkanie>, Serializable {
	
	/** 
	 * Konstruktor tworzący nowe spotkanie z danymi terminu, tematu i opisu
	 * @param termin Termin spotkania w formacie yyyy-MM-dd
	 * @param nazwa Temat spotkania
	 * @param desc Opis spotkania
	 */
	public Spotkanie (String termin, String nazwa, String desc) {
		setData(termin);
		setTemat(nazwa);
		setOpis(desc);
}
	
	/** 
	 * Zwraca datę spotkania
	 * @return Data spotkania
	 */
	LocalDate getData() {
		return data;
	}

	/** 
	 * Ustawia datę spotkania
	 * @param termin Data spotkania w formacie yyyy-MM-dd
	 */
	void setData(String termin) {
		LocalDate data = LocalDate.parse(termin);
		this.data = data;
	}

	/** 
	 * Zwraca temat spotkania
	 * @return Temat spotkania
	 */
	String getTemat() {
		return temat;
	}

	/** 
	 * Ustawia temat spotkania
	 * @param temat Temat spotkania
	 */
	void setTemat(String temat) {
		this.temat = temat;
	}

	/** 
	 * Zwraca opis spotkania
	 * @return Opis spotkania
	 */
	String getOpis() {
		return opis;
	}

	/** 
	 * Ustawia opis spotkania
	 * @param opis Opis spotkania
	 */
	void setOpis(String opis) {
		this.opis = opis;
	}

	/** 
	 * Zwraca osoby uczestniczące w spotkaniu
	 * @return Tablica obiektów klasy Kontakt reprezentujących osoby uczestniczące w spotkaniu
	 */
	Kontakt[] getOsoby() {
		return osoby;
	}

	/** 
	 * Ustawia osoby uczestniczące w spotkaniu
	 * @param osoby Tablica obiektów klasy Kontakt reprezentujących osoby uczestniczące w spotkaniu
	 */
	void setOsoby(Kontakt[] osoby) {
		this.osoby = osoby;
	}

	/** 
	 * Data spotkania
	 */
	LocalDate data;
	
	/** 
	 * Temat spotkania
	 */
	String temat;
	
	/** 
	 * Opis spotkania
	 */
	String opis;
	
	/** 
	 * Osoby uczestniczące w spotkaniu
	 */
	Kontakt[] osoby;
	
	@Override
	public String toString() {
		return "Spotkanie [data=" + data + ", temat=" + temat + ", opis=" + opis + ", osoby=" + Arrays.toString(osoby)
				+ "]";
	}

	
	@Override
	public int compareTo(Spotkanie other) {
		int result = this.getData().compareTo(other.getData());
		return result;
	}
}