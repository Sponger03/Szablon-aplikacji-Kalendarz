package zadan2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Zapis {
	


		public void zapisanie() {
			
			
			ArrayList<Spotkanie> spotkania = new ArrayList<Spotkanie>();
			ArrayList<Kontakt> kontakty = new ArrayList<Kontakt>();
			
			spotkania.add(new Spotkanie("2024-01-02","mecz","opis zdarzenia 1"));
			spotkania.add(new Spotkanie("2024-01-02","kino","opis zdarzenia 2"));
			spotkania.add(new Spotkanie("2024-01-03","piwo","opis zdarzenia 3"));
			spotkania.add(new Spotkanie("2024-01-04","szkola","opis zdarzenia 4"));
			spotkania.add(new Spotkanie("2024-01-05","praca","opis zdarzenia 5"));
			spotkania.add(new Spotkanie("2024-01-06","mecz2","opis zdarzenia 6"));
			spotkania.add(new Spotkanie("2024-01-07","kino2","opis zdarzenia 7"));
			spotkania.add(new Spotkanie("2024-01-08","piwo2","opis zdarzenia 8"));
			spotkania.add(new Spotkanie("2024-01-09","szkola2","opis zdarzenia 9"));
			spotkania.add(new Spotkanie("2024-01-01","praca2","opis zdarzenia 10"));
			kontakty.add(new Kontakt("Ceglowski","223456789", "122456", "true"));
			kontakty.add(new Kontakt("Banaszek","923456789","123456", "true"));
			kontakty.add(new Kontakt("Banaszyk","323456789","123457", "true"));
			kontakty.add(new Kontakt("Banaszak","523456789","123458", "true"));
			kontakty.add(new Kontakt("Banaszok","423456789","123459", "true"));
			kontakty.add(new Kontakt("Banaszuk","123456789","123450", "true"));
			kontakty.add(new Kontakt("Banaszik","723456789","123486", "true"));
			kontakty.add(new Kontakt("Banasik","123456789","123488", "true"));
			kontakty.add(new Kontakt("Banasiak","123456789","123489", "true"));
			kontakty.add(new Kontakt("Banasiek","123456789","123478", "true"));

			Collections.sort(spotkania, new SpotkanieComparator());
			Collections.sort(kontakty, new KontaktComparator());
			
			try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("kontakty.xml"))){
				outputStream.writeObject(kontakty);
			} catch (IOException k) {
				k.printStackTrace();
			}
			
			try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("spotkania.xml"))){
				outputStream.writeObject(spotkania);
			} catch (IOException s) {
				s.printStackTrace();
			}
			
			System.out.println("Spotkania:");
			for (Spotkanie s : spotkania) {
				System.out.println(s);
			}
			
			System.out.println("Kontakty:");
			for (Kontakt k : kontakty) {
				System.out.println(k);
			}
			
			
			 
			 

		}
		
		
		
}
