package zadan2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*; 

public class TextMenu{

	public static void main(String[] args) throws SQLException {
		
		ZapisOdczyt odc = new ZapisOdczyt();
		
		String menu;
		String kont;
		String spot;
		System.out.println("Witaj w menu kalendarza! Wybierz literę z listy aby przejść dalej:");
		System.out.println("1 - Wyświetl kalendarz");
		System.out.println("2 - Dodaj kontakt");
		System.out.println("3 - Edytuj kontakt");
		System.out.println("4 - Usuń kontakt");
		System.out.println("5 - Dodaj spotkanie");
		System.out.println("6 - Edytuj kontakt");
		System.out.println("7 - Usuń spotkanie");
		System.out.println("");
		System.out.println("");
		menu = JOptionPane.showInputDialog("Twój wybór: ");
		System.out.println("");
		System.out.println("");
		switch(menu) {
		  case "1":
				System.out.println("Sortowanie kontaktów:");
				System.out.println("1 - Sortuj przez nazwe");
				System.out.println("2 - Sortuj przez telefon");
				System.out.println("3 - Sortuj przez index");

				
				System.out.println("Sortowanie wydarzeń:");
				System.out.println("a - Sortuj przez temat");
				System.out.println("b - Sortuj przez opis");
				System.out.println("c - Sortuj przez date");
				System.out.println("");
				System.out.println("");
				kont = JOptionPane.showInputDialog("Twój wybór: ");
				spot = JOptionPane.showInputDialog("Twój wybór: ");
				System.out.println("");
				System.out.println("");
				
				
				odc.wyswietl(kont, spot);
		  case "2":
			  break;
		  case "3":
			  break;
		  case "4":
			  break;
		  case "5":
			  break;
		  default:
				odc.wyswietl("1","a");
		}
		
		odc.zapis();
		


		
		DB db = new DB();
		db.openConnection();
		
		
		
		OdczytBD odczyt = new OdczytBD();
		odczyt.viewTable(DB.connect());
		
		
		ZapisOdczyt.insertTable(DB.connect());
		
		
		
		
		
		

db.closeConnection();
		

		

		 

	}

}
