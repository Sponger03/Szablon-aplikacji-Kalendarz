package zadan2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/** 
 * Klasa odpowiadająca za zapisywanie i oczytywanie danych z XML i dodawanie danych do bazy 
 */
public class ZapisOdczyt {
	


		public static ArrayList<Spotkanie> odczytaniespot() {
			
			ArrayList<Spotkanie> spotkania = new ArrayList<Spotkanie>();
			
			
			
			try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("spotkania.xml"))){
				spotkania = (ArrayList<Spotkanie>)inputStream.readObject();
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return spotkania;
		}
		
		public static ArrayList<Kontakt> odczytaniekont() {
			
			ArrayList<Kontakt> kontakty = new ArrayList<Kontakt>();
			
			try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("kontakty.xml"))){
				kontakty = (ArrayList<Kontakt>)inputStream.readObject();
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return kontakty;
		}
		

		
		
		
		public void wyswietl(String kont, String spot) {
			ArrayList<Spotkanie> spotkania = odczytaniespot();
			
			switch(spot) {
			default:
				Collections.sort(spotkania, new TematComparator());
				break;
			case "b":
				Collections.sort(spotkania, new OpisComparator());
				break;
			case "c":
				Collections.sort(spotkania, new DataComparator());
				break;
			}
			
			for (Spotkanie s : spotkania) {
				System.out.println(s.toString());
			}
			
			
			
			

			
			
			ArrayList<Kontakt> kontakty = odczytaniekont();
			
			switch(kont) {
			default:
				Collections.sort(kontakty, new NazwaComparator());
				break;
			case "2":
				Collections.sort(kontakty, new TelComparator());
				break;
			case "3":
				Collections.sort(kontakty, new IndexComparator());
				break;
			}
			
			for (Kontakt k : kontakty) {
				System.out.println(k.toString());
			}
			
			
		
		}
		
		public void zapis() {
			ArrayList<Kontakt> kontakty = odczytaniekont();

			   try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("kontakty.xml"))){
	                outputStream.writeObject(kontakty);
	            } catch (IOException k) {
	                k.printStackTrace();
	            }
	            
			   ArrayList<Spotkanie> spotkania = odczytaniespot();


	            
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
		
		 public static void insertTable(Connection con) throws SQLException {
			 
				ArrayList<Spotkanie> spotkania = odczytaniespot();
				ArrayList<Kontakt> kontakty = odczytaniekont();
				
				
				String query1 = "DELETE FROM kontakty";
             PreparedStatement preparedStmt1 = con.prepareStatement(query1);
             preparedStmt1.execute();
				String query2 = "DELETE FROM spotkania";
             PreparedStatement preparedStmt2 = con.prepareStatement(query2);
             preparedStmt2.execute();
             String query3 = "ALTER SEQUENCE kontakty_id_kontaktu_seq RESTART WITH 1";
				PreparedStatement preparedStmt3 = con.prepareStatement(query3);
				preparedStmt3.execute();
				String query4 = "ALTER SEQUENCE spotkania_id_spotkania_seq RESTART WITH 1";
				PreparedStatement preparedStmt4 = con.prepareStatement(query4);
				preparedStmt4.execute();
             
				for (Spotkanie spotkanie : spotkania) {
                 String query = "INSERT INTO spotkania (data, temat, opis) VALUES (?, ?, ?)";
                 PreparedStatement preparedStmt = con.prepareStatement(query);
                 LocalDate localDate = spotkanie.getData();
                 Date sqlDate = Date.valueOf(localDate);
                 preparedStmt.setDate(1, sqlDate);
                 preparedStmt.setString(2, spotkanie.getTemat());
                 preparedStmt.setString(3, spotkanie.getOpis());
                 preparedStmt.execute();
             }
				
				
				for (Kontakt kontakt : kontakty) {
	                String query = "INSERT INTO kontakty (nazwa, telefon, nrindeksu, znajomy) VALUES (?, ?, ?, ?)";
	                PreparedStatement preparedStmt = con.prepareStatement(query);
	                preparedStmt.setString(1, kontakt.getNazwa());
	                preparedStmt.setString(2, kontakt.getTelefon());
	                preparedStmt.setInt(3, kontakt.getNrIndeksu());
	                preparedStmt.setBoolean(4, kontakt.isCzyZnajomy());
	                preparedStmt.execute();
	            }
	                
	

}}
