package zadan2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// dodac spotkania + dodac do arraylisty wyniki
public class OdczytBD {
	 public static void viewTable(Connection con) {
		    String query = "select * from kontakty";
		    try (Statement stmt = con.createStatement()) {
		      ResultSet rs = stmt.executeQuery(query);
		      while (rs.next()) {
		        int ID = rs.getInt("id_kontaktu");
		        String nazwa = rs.getString("nazwa");
		        String tel = rs.getString("telefon");
		        int index = rs.getInt("nrindeksu");
		        boolean znaj = rs.getBoolean("znajomy");
		        System.out.println(ID + ", " + nazwa + ", " + tel +
		                           ", " + index + ", " + znaj);
		      }
		    } catch (SQLException e) {
		      System.out.println(e);
		    }
		  }
	 

}
