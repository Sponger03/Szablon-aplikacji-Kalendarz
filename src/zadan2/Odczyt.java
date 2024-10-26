package zadan2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Odczyt {
	


		public void odczytanie() {
			
			ArrayList<Spotkanie> spotkania = new ArrayList<Spotkanie>();
			ArrayList<Kontakt> kontakty = new ArrayList<Kontakt>();
			
			
			try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("spotkania.xml"))){
				spotkania = (ArrayList<Spotkanie>)inputStream.readObject();
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			for (Spotkanie s : spotkania) {
				System.out.println(s.toString());
			}
			
			
			try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("kontakty.xml"))){
				kontakty = (ArrayList<Kontakt>)inputStream.readObject();
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			for (Kontakt k : kontakty) {
				System.out.println(k.toString());
			}
			
			
		
		}
	

}
