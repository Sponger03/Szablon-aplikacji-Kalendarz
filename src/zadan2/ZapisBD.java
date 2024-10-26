package zadan2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


public class ZapisBD {
	
		 public static void insertTable(Connection con) throws SQLException {
			 
				ArrayList<Spotkanie> spotkania = new ArrayList<Spotkanie>();
				ArrayList<Kontakt> kontakty = new ArrayList<Kontakt>();
				
				String query1 = "DELETE FROM kontakty";
                PreparedStatement preparedStmt1 = con.prepareStatement(query1);
                preparedStmt1.execute();
				String query2 = "DELETE FROM spotkania";
                PreparedStatement preparedStmt2 = con.prepareStatement(query2);
                preparedStmt2.execute();
                
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
	                
	                
			

	}
}



