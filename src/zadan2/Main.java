package zadan2;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (args.length > 0) {
            switch (args[0].toLowerCase()) {
                case "-gui":
                    KalendarzGUI.main(args);
                    break;
                case "-txt":
                    TextMenu.main(args);
                    break;
                default:
                    System.out.println("Nieznany argument: " + args[0]);
                    System.out.println("Użyj '-gui' aby uruchomić interfejs graficzny lub '-txt' aby uruchomić wersję tekstową.");
                    break;
            }
        } else {
            System.out.println("Nie podano argumentu.");
            System.out.println("Użyj 'gui' aby uruchomić interfejs graficzny lub 'text' aby uruchomić wersję tekstową.");
        }
    }
}