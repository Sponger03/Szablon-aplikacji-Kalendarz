// dodac WindowBuilder zeby swing dzialal
//Runtime add-hook do zapisywania przy zamykaniu

package zadan2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
/** 
 * Klasa odpowiadająca za okno graficzne programu 
 */

public class KalendarzGUI extends JFrame {

	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
	private ArrayList<Kontakt> kontaktyList;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JTable kontaktyTabela;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private DefaultTableModel kontaktyTableModel;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JTable wydarzeniaTabela;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private DefaultTableModel wydarzeniaTableModel;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JComboBox<String> comboBox;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JSlider slider;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JProgressBar progressBar;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JColorChooser colorChooser;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JFileChooser fileChooser;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JTextField textField, textField2, textField3;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */
    private JTextField text, text2, text3;
	/** 
	 * Klasa odpowiadająca za okno graficzne programu 
	 */

    public KalendarzGUI() {
    	kontaktyList = new ArrayList<>();
        setTitle("Kalendarz");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        // TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        
        JMenu fileMenu2 = new JMenu("Kontakty");
        JMenuItem dodajKontaktItem = new JMenuItem("Dodaj");
        JMenuItem edytujKontaktItem = new JMenuItem("Edytuj");
        JMenuItem usunKontaktItem = new JMenuItem("Usuń");
        JMenu fileMenu3 = new JMenu("Spotkania");
        JMenuItem dodajSpotkanieItem = new JMenuItem("Dodaj");
        JMenuItem edytujSpotkanieItem = new JMenuItem("Edytuj");
        JMenuItem usunSpotkanieItem = new JMenuItem("Usuń");
        
        dodajKontaktItem.addActionListener(e -> addNewContactTab(tabbedPane));
        edytujKontaktItem.addActionListener(e -> System.out.println("A"));
        usunKontaktItem.addActionListener(e -> System.out.println("A"));
        
        dodajSpotkanieItem.addActionListener(e -> System.out.println("A"));
        edytujSpotkanieItem.addActionListener(e -> System.out.println("A"));
        usunSpotkanieItem.addActionListener(e -> System.out.println("A"));
        
        openMenuItem.addActionListener(e -> fileChooser.showOpenDialog(this));
        saveMenuItem.addActionListener(e -> fileChooser.showSaveDialog(this));
        exitMenuItem.addActionListener(e -> System.exit(0));
        

        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        fileMenu2.add(dodajKontaktItem);
        fileMenu2.add(edytujKontaktItem);
        fileMenu2.add(usunKontaktItem);
        menuBar.add(fileMenu2);
        setJMenuBar(menuBar);                
                
        		
        fileMenu3.add(dodajSpotkanieItem);
        fileMenu3.add(edytujSpotkanieItem);
        fileMenu3.add(usunSpotkanieItem);
        menuBar.add(fileMenu3);
        setJMenuBar(menuBar);
                

        // FileChooser
        fileChooser = new JFileChooser();

      

        JPanel kontaktyPanel = createKontaktyPanel();
        tabbedPane.addTab("Kontakty", kontaktyPanel);

        // Dodaj Kontakt Tab
       // JPanel dodajKontaktPanel = createDodajKontaktPanel();
       // tabbedPane.addTab("Dodaj kontakt", dodajKontaktPanel);

        // Wydarzenia Tab
        JPanel wydarzeniaPanel = createWydarzeniaPanel();
        tabbedPane.addTab("Wydarzenia", wydarzeniaPanel);

        // Dodaj Wydarzenie Tab
       // JPanel dodajWydarzeniePanel = createDodajWydarzeniePanel();
       // tabbedPane.addTab("Dodaj wydarzenie", dodajWydarzeniePanel);
        
        JPanel kalendarzPanel = createKalendarzPanel();
        tabbedPane.addTab("Kalendarz", kalendarzPanel);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        
        loadContacts();
        loadEvents();
    }
// dodac to dla edytowania, usuwania + spotkania
    private void addNewContactTab(JTabbedPane tabbedPane) {
       
        JPanel dodajKontaktPanel = createDodajKontaktPanel();
		tabbedPane.addTab("Dodaj kontakt", dodajKontaktPanel);
        tabbedPane.setSelectedComponent(dodajKontaktPanel);
    }
    
    private JPanel createKalendarzPanel() {
    	 JCalendar calendar = new JCalendar();
    	    JPanel panel = new JPanel(new BorderLayout());
    	    panel.add(calendar, BorderLayout.CENTER);
    	    return panel;
		
	}

	private JPanel createKontaktyPanel() {
        kontaktyTableModel = new DefaultTableModel(new String[]{"Nazwa", "Telefon", "Index", "Znajomy"}, 0);
        kontaktyTabela = new JTable(kontaktyTableModel);
        JScrollPane tableScrollPane = new JScrollPane(kontaktyTabela);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createDodajKontaktPanel() {
        textField = new JTextField(15);
        textField2 = new JTextField(15);
        textField3 = new JTextField(15);

        textField.setToolTipText("Wpisz nazwę kontaktu");
        textField2.setToolTipText("Wpisz telefon");
        textField3.setToolTipText("Wpisz numer indeksu");

        JButton addButton = new JButton("Dodaj kontakt");
        addButton.addActionListener(e -> addContacts());

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nazwa:"));
        panel.add(textField);
        panel.add(new JLabel("Tel:"));
        panel.add(textField2);
        panel.add(new JLabel("Index:"));
        panel.add(textField3);
        panel.add(addButton);

        return panel;
    }

    private JPanel createWydarzeniaPanel() {
        wydarzeniaTableModel = new DefaultTableModel(new String[]{"Temat", "Opis", "Data"}, 0);
        wydarzeniaTabela = new JTable(wydarzeniaTableModel);
        JScrollPane tableScrollPane = new JScrollPane(wydarzeniaTabela);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(tableScrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createDodajWydarzeniePanel() {
        text = new JTextField(15);
        text2 = new JTextField(15);
        text3 = new JTextField(15);

        text.setToolTipText("Wpisz temat wydarzenia");
        text2.setToolTipText("Wpisz opis wydarzenia");
        text3.setToolTipText("Wpisz datę w formacie yyyy-MM-dd");

        JButton addButton = new JButton("Dodaj wydarzenie");
        addButton.addActionListener(e -> addEvent());

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Temat:"));
        panel.add(text);
        panel.add(new JLabel("Opis:"));
        panel.add(text2);
        panel.add(new JLabel("Data:"));
        panel.add(text3);
        panel.add(addButton);

        return panel;
    }

    private void loadContacts() {
        kontaktyTableModel.setRowCount(0);
        kontaktyList.clear(); //

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kalendarz", "postgres", "aeh");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM kontakty")) {

            while (resultSet.next()) {
                String nazwa = resultSet.getString("nazwa");
                String telefon = resultSet.getString("telefon");
                int index = resultSet.getInt("nrindeksu");
                String indeks = String.valueOf(index);
                boolean znajomy = resultSet.getBoolean("znajomy");
                String znaj = String.valueOf(znajomy);
                // Dodanie danych do listy kontaktyList
                kontaktyList.add(new Kontakt(nazwa, telefon, indeks, znaj));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Aktualizacja tabeli
        for (Kontakt kontakt : kontaktyList) {
            kontaktyTableModel.addRow(new Object[]{kontakt.getNazwa(), kontakt.getTelefon(), kontakt.getNrIndeksu(), kontakt.isCzyZnajomy()});
        }
    }

    private void addContacts() {
        String name = textField.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nazwa nie może być pusta", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tel = textField2.getText();
        int index = Integer.parseInt(textField3.getText());

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kalendarz", "postgres", "aeh");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO kontakty (nazwa, telefon, nrindeksu, znajomy) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, name);
            statement.setString(2, tel);
            statement.setInt(3, index);
            statement.setBoolean(4, true);
            statement.executeUpdate();

            loadContacts();
            JOptionPane.showMessageDialog(this, "Dodano kontakt", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadEvents() {
        wydarzeniaTableModel.setRowCount(0);
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kalendarz", "postgres", "aeh");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM spotkania")) {

            while (resultSet.next()) {
                String temat = resultSet.getString("temat");
                String opis = resultSet.getString("opis");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                wydarzeniaTableModel.addRow(new Object[]{temat, opis, data});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addEvent() {
        String temat = text.getText();
        if (temat.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Temat nie może być pusty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String opis = text2.getText();
        LocalDate parsedDate = parseDate(text3.getText());
        if (parsedDate == null) {
            JOptionPane.showMessageDialog(this, "Błędny format daty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Date data = Date.valueOf(parsedDate);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Kalendarz", "postgres", "aeh");
             PreparedStatement statement = connection.prepareStatement("INSERT INTO spotkania (temat, opis, data) VALUES (?, ?, ?)")) {

            statement.setString(1, temat);
            statement.setString(2, opis);
            statement.setDate(3, data);
            statement.executeUpdate();

            loadEvents();
            JOptionPane.showMessageDialog(this, "Dodano wydarzenie", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	/** 
	 * Zmiena date z bazy danych na localdate
	 * @param dateStr - String daty
	 * @return Zwraca zamienioną date
	 */
    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
	/** 
	 * Główna metoda programu
	 * @param args Argumenty maina
	 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KalendarzGUI app = new KalendarzGUI();
            app.setVisible(true);
        });
    }
}
