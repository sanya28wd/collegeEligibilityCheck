package javafrontendGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

//Class for login window
class CustomerLogin extends JFrame implements ActionListener {
	private JTextField usernameField, ageField;
	private JPasswordField passwordField;
	private JButton loginButton, clearButton;

	public CustomerLogin() {
		// details of the login window like tittle, size
		setTitle("Customer Login");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// the x button thing
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// details of the background panel
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setLayout(null);
		backgroundPanel.setBackground(new Color(230, 240, 255)); // rgb value for color

		// Details for the heading - WELOME
		JLabel heading = new JLabel("WELCOME TO OUR PORTAL");
		heading.setFont(new Font("Verdana", Font.BOLD, 24));
		heading.setForeground(new Color(50, 75, 190));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(50, 20, 400, 40);
		backgroundPanel.add(heading);

		JPanel formPanel = new JPanel();
		formPanel.setBounds(50, 80, 400, 220);
		formPanel.setLayout(null);
		formPanel.setBackground(Color.WHITE);
		formPanel.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 230), 2));

		// USername text thing and the box for input
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameLabel.setBounds(30, 20, 100, 25);
		formPanel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
		usernameField.setBounds(150, 20, 200, 25);
		formPanel.add(usernameField);

		// Similiar thing for age box
		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		ageLabel.setBounds(30, 70, 100, 25);
		formPanel.add(ageLabel);

		ageField = new JTextField();
		ageField.setFont(new Font("Arial", Font.PLAIN, 14));
		ageField.setBounds(150, 70, 200, 25);
		formPanel.add(ageField);

		// SIMILIAR thing for password thingy
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordLabel.setBounds(30, 120, 100, 25);
		formPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBounds(150, 120, 200, 25);
		formPanel.add(passwordField);

		// Button 1 for login
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.BOLD, 14));
		loginButton.setBounds(80, 170, 100, 30);
		loginButton.setBackground(new Color(60, 140, 230));
		loginButton.setForeground(Color.BLACK);
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(this);
		formPanel.add(loginButton);

		// Button 2 for clear - When u click this username, passowrd, age will become
		// empty
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Arial", Font.BOLD, 14));
		clearButton.setBounds(220, 170, 100, 30);
		clearButton.setBackground(new Color(230, 70, 70));
		clearButton.setForeground(Color.BLACK);
		clearButton.setFocusPainted(false);
		clearButton.addActionListener(this);
		formPanel.add(clearButton);

		backgroundPanel.add(formPanel);

		// Extra details in the bottom to make it to look nice
		JLabel footer = new JLabel("©️ 2024 College Portal | All Rights Reserved");
		footer.setFont(new Font("Arial", Font.PLAIN, 12));
		footer.setForeground(new Color(100, 100, 100));
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setBounds(50, 320, 400, 20);
		backgroundPanel.add(footer);

		add(backgroundPanel);
		setVisible(true);
	}

	@Override // when you press the button the things that will happen
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String username = usernameField.getText();
			String ageText = ageField.getText();
			String password = new String(passwordField.getPassword());

			if (!username.isEmpty() && !ageText.isEmpty() && !password.isEmpty()) { // This will check if the the boxes
																					// are empty or not
				try {// if its not empty it'll check if age is greater than 16
					int age = Integer.parseInt(ageText);
					if (age >= 16) {
						JOptionPane.showMessageDialog(this, "Login Successful!");
						dispose();
						new InputWindow();
					} else {
						JOptionPane.showMessageDialog(this, "You must be 16 or older to proceed.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {// if even one is empty this error will show
				JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == clearButton) {// if clear is pressed
			usernameField.setText("");
			ageField.setText("");
			passwordField.setText("");
		}
	}
}

//after login page, the next page where it'll take in details of the user - INPUT PAGE
class InputWindow extends JFrame implements ActionListener {
	private JTextField boardMarksField, entranceMarksField, stateField, feesField, ratingField;
	private JComboBox<String> stateBox;
	private JButton proceedButton;

	public InputWindow() {
		// Details of the window
		setTitle("Input Marks and Exam");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// first input box
		JLabel boardMarksLabel = new JLabel("Board Marks:");
		boardMarksLabel.setBounds(50, 30, 100, 25);
		add(boardMarksLabel);

		boardMarksField = new JTextField();
		boardMarksField.setBounds(180, 30, 150, 25);
		add(boardMarksField);

		// second input box
		JLabel entranceMarksLabel = new JLabel("Entrance Marks:");
		entranceMarksLabel.setBounds(50, 70, 120, 25);
		add(entranceMarksLabel);

		entranceMarksField = new JTextField();
		entranceMarksField.setBounds(180, 70, 150, 25);
		add(entranceMarksField);

		// Third input box which also a dropdown box
		JLabel stateLabel = new JLabel("State:");
		stateLabel.setBounds(50, 110, 100, 25);
		add(stateLabel);

		String[] statedrop = { "Kerala", "Karnataka", "Tamil Nadu", "Andhra Pradesh", "Maharashtra", "Telangana",
				"Chhattisgarh", "Madhya Pradesh", "Odisha" };

		stateBox = new JComboBox<>(statedrop);
		stateBox.setBounds(180, 110, 150, 25);
		add(stateBox);

		// // fourth input box
		JLabel feesLabel = new JLabel("Maximum Fees:");
		feesLabel.setBounds(50, 150, 100, 25);
		add(feesLabel);

		feesField = new JTextField();
		feesField.setBounds(180, 150, 150, 25);
		add(feesField);

		// fifth input box
		JLabel ratingLabel = new JLabel("Rating:");
		ratingLabel.setBounds(50, 190, 100, 25);
		add(ratingLabel);

		ratingField = new JTextField();
		ratingField.setBounds(180, 190, 150, 25);
		add(ratingField);

		// for the button
		proceedButton = new JButton("Proceed");
		proceedButton.setBounds(150, 280, 100, 30);
		proceedButton.addActionListener(this);
		add(proceedButton);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == proceedButton) {// will check if the button is pressed
			try {
				// store details of each input box
				double boardMarks = Double.parseDouble(boardMarksField.getText());
				double entranceMarks = Double.parseDouble(entranceMarksField.getText());
				double fees = Double.parseDouble(feesField.getText());
				double rating = Double.parseDouble(ratingField.getText());
				String statedrop = (String) stateBox.getSelectedItem();

				if (boardMarks >= 0 && entranceMarks >= 0 && fees >= 0 && rating >= 0) {
					dispose();
					new SortingWindow(boardMarks, entranceMarks, statedrop, fees, rating);
				} else {
					JOptionPane.showMessageDialog(this, "Marks, fees, and rating must be non-negative.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Please enter valid numeric values for marks, fees, and rating.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

// Next page - where user gets to choose on what basis they want the sample information filtered and sorted
class SortingWindow extends JFrame implements ActionListener {
	private JButton sortByRatingsButton, sortByFeesButton, sortbystate, sortbyscore, sortbyentrance, sortbybudget,
			sortbyentrancescore;

	private final double boardMarks;
	private final double entranceMarks, rating;
	private final String statedrop;
	private final double fees;

	public SortingWindow(double boardMarks, double entranceMarks, String statedrop, double fees, double rating) {
		this.boardMarks = boardMarks;
		this.entranceMarks = entranceMarks;
		this.fees = fees;
		this.statedrop = statedrop;
		this.rating = rating;

		setTitle("Sorting Preferences");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 2));

		sortByRatingsButton = new JButton("Sort by Ratings");
		sortByRatingsButton.addActionListener(this);
		add(sortByRatingsButton);
		sortByRatingsButton.setBackground(new Color(60, 140, 230));

		sortByFeesButton = new JButton("Sort by Fees");
		sortByFeesButton.addActionListener(this);
		add(sortByFeesButton);

		sortbystate = new JButton("Sort by State");
		sortbystate.addActionListener(this);
		add(sortbystate);

		sortbyentrance = new JButton("Filter by Board Marks");
		sortbyentrance.addActionListener(this);
		add(sortbyentrance);

		sortbyentrancescore = new JButton("Sort by Entrance Exam Score");
		sortbyentrancescore.addActionListener(this);
		add(sortbyentrancescore);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<College> colleges = CollegeData.getColleges(); // this will get the colleges from the sample data

		if (e.getSource() == sortByRatingsButton) {
			colleges = colleges.stream().filter(college -> college.getRatings() == rating)
					.sorted(Comparator.comparing(College::getRatings).reversed()).toList(); // Gives elements for the
																							// rating which was inputed
		} else if (e.getSource() == sortByFeesButton) {
			colleges = colleges.stream().filter(college -> college.getFees() <= fees)
					.sorted(Comparator.comparing(College::getFees).reversed()).toList(); // Give colleges upto to the
																							// amount which was inputed
		} else if (e.getSource() == sortbystate) {
			colleges = colleges.stream().filter(college -> college.getState() == statedrop) // Based on the dropdown box
																							// it'll give colleges for a
																							// specific state
					.sorted(Comparator.comparing(College::getState).reversed()).toList();
		} else if (e.getSource() == sortbyentrance) {
			colleges = colleges.stream().filter(college -> college.getCbseResult() <= boardMarks)// Based on the mark
																									// inputed it'll
																									// check which
																									// colleges the user
																									// is eligible
					.sorted(Comparator.comparing(College::getCbseResult).reversed()).toList();
		} else if (e.getSource() == sortbyentrancescore) {
			colleges = colleges.stream().filter(college -> college.getEntrancemark() <= entranceMarks)
					.sorted(Comparator.comparing(College::getEntrancemark).reversed()).toList();
		}

		dispose();
		new DisplayWindow(colleges);
	}
}

// Next Window - Based on previous criteria it'll display the sorted and filtered list of colleges
class DisplayWindow extends JFrame {
	public DisplayWindow(List<College> colleges) {
		setTitle("Colleges in Tabular Form");
		setSize(900, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Define column names
		String[] columnNames = { "Name", "Ratings", "Fees", "Entrance Marks", "Entrance", "CBSE Result", "State" };

		// Create data array
		Object[][] data = new Object[colleges.size()][7];
		for (int i = 0; i < colleges.size(); i++) {
			College c = colleges.get(i);
			data[i][0] = c.getName();
			data[i][1] = c.getRatings();
			data[i][2] = c.getFees();
			data[i][3] = c.getEntrancemark();
			data[i][4] = c.getEntrance();
			data[i][5] = c.getCbseResult();
			data[i][6] = c.getState();
		}

		// Create JTable
		JTable table = new JTable(new DefaultTableModel(data, columnNames));
		table.setRowHeight(25);

		// Add JScrollPane for scrolling
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}
}

// Class for colleges - sample data
class College {
	private String name;
	private double ratings;
	private int fees;
	private int entrancemark;
	private String entrance;
	private double cbseResult;
	private String state;

	public College(String name, double ratings, int fees, int entrancemark, String entrance, double cbseResult,
			String state) {
		this.name = name;
		this.ratings = ratings;
		this.fees = fees;
		this.entrancemark = entrancemark;
		this.entrance = entrance;
		this.cbseResult = cbseResult;
		this.state = state;
	}

	// Getters
	public String getName() {
		return name;
	}

	public double getRatings() {
		return ratings;
	}

	public int getFees() {
		return fees;
	}

	public int getEntrancemark() {
		return entrancemark;
	}

	public String getEntrance() {
		return entrance;
	}

	public double getCbseResult() {
		return cbseResult;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return String.format("%-30s %-10.1f %-10d %-15d %-20s %-15.1f %-15s", name, ratings, fees, entrancemark,
				entrance, cbseResult, state);
	}
}

// Class for cansolidating the sample date into a single list
class CollegeData {
	public static List<College> getColleges() {
		List<College> colleges = new ArrayList<>();
		colleges.add(new College("NIT Calicut", 4.3, 575000, 250, "JEE MAIN", 75.0, "Kerala"));
		colleges.add(new College("IIST Trivandrum", 4.1, 400000, 250, "JEE MAIN, 12TH", 75.0, "Kerala"));
		colleges.add(new College("CET Trivandrum", 4.4, 1765000, 400, "KEAM", 45.0, "Kerala"));
		colleges.add(new College("IIT Madras", 4.7, 80125, 250, "JEE ADV", 75.0, "Tamil Nadu"));
		colleges.add(new College("VIT Vellore", 4.4, 715000, 100, "VITEEE", 60.0, "Tamil Nadu"));
		colleges.add(new College("NIT Trichy", 4.4, 200000, 250, "JEE MAIN", 75.0, "Tamil Nadu"));
		colleges.add(new College("SRM University", 4.3, 1037500, 250, "SRM JEE,", 50.0, "Tamil Nadu"));
		colleges.add(new College("Anna University", 4.0, 300000, 75, "TANCET", 50.0, "Tamil Nadu"));
		colleges.add(new College("MIT Manipal", 4.2, 1500000, 200, "MET", 50.0, "Karnataka"));
		colleges.add(new College("NIT Surathkal", 4.4, 245000, 250, "JEE MAIN", 75.0, "Karnataka"));
		colleges.add(new College("IIIT Bangalore", 4.8, 270000, 250, "JEE MAIN", 75.0, "Karnataka"));
		colleges.add(new College("Christ University", 4.2, 950000, 600, "CUET", 50.0, "Karnataka"));
		colleges.add(new College("Visvesvaraya University", 4.8, 1250000, 250, " JEE MAIN", 50.0, "Karnataka"));
		colleges.add(new College("KL University", 4.4, 920000, 250, " JEE MAIN,", 60.0, "Andhra Pradesh"));
		colleges.add(new College("IIT Tirupati", 4.6, 700000, 250, "JEE ADV", 75.0, "Andhra Pradesh"));
		colleges.add(new College("GITAM University", 4.5, 1000000, 150, "GAT", 60.0, "Andhra Pradesh"));
		colleges.add(new College("IIT Bombay", 4.6, 1400000, 250, "JEE MAIN", 75.0, "Maharashtra"));
		colleges.add(new College("VNIT Nagpur", 4.1, 320000, 250, "JEE MAIN", 75.0, "Maharashtra"));
		colleges.add(new College("COEP Tec University", 4.3, 850000, 250, "JEE MAIN", 45.0, "Maharashtra"));
		colleges.add(new College("MIT WPU", 4.0, 500000, 250, "JEE MAIN", 50.0, "Maharashtra"));
		colleges.add(new College("ICT Mumbai", 4.4, 300000, 250, "JEE MAIN", 45.0, "Maharashtra"));
		colleges.add(new College("University of Hyderabad", 4.4, 700000, 600, "CUET", 55.0, "Telangana"));
		colleges.add(new College("Osmania University", 4.1, 550000, 200, "TSBIE", 50.0, "Telangana"));
		colleges.add(new College("IIIT Hyderabad", 4.3, 2500000, 250, "UGEE, JEE MAIN", 45.0, "Telangana"));
		colleges.add(new College("GITHAM University", 4.1, 1350000, 250, " JEE ADV", 50.0, "Telangana"));
		colleges.add(new College("Anurag University", 4.2, 600000, 250, "NO TEST NEEDED", 50.0, "Telangana"));
		colleges.add(new College("NIT Nagpur", 4.0, 700000, 250, "JEE ADV", 60.0, "Chhattisgarh"));
		colleges.add(new College("IIT Bhilai", 4.1, 1200000, 250, "JEE ADV", 75.0, "Chhattisgarh"));
		colleges.add(new College("Rungta College of Tech", 4.1, 250000, 250, "JEE ADV", 55.0, "Chhattisgarh"));
		colleges.add(new College("OP Jindal University Raigarh", 4.0, 460000, 250, "JEE MAIN,", 50.0, "Chhattisgarh"));
		colleges.add(new College("Amity University Raipur", 4.2, 565000, 250, "JEE ADV", 60.0, "Chhattisgarh"));
		colleges.add(new College("IIT Indore", 4.2, 900000, 250, "JEE MAIN", 75.0, "Madhya Pradesh"));
		colleges.add(new College("IIITDM Jabalpur", 4.2, 550000, 250, "JEE MAIN", 60.0, "Madhya Pradesh"));
		colleges.add(new College("Amity University Gwalior", 4.3, 950000, 250, "JEE MAIN", 75.0, "Madhya Pradesh"));
		colleges.add(new College("IES College of Technology", 4.0, 250000, 250, " JEE MAIN", 75.0, "Madhya Pradesh"));
		colleges.add(new College("NIT Rourkela", 4.3, 575000, 250, "JEE MAIN", 75.0, "Odisha"));
		colleges.add(new College("Siksha ‘O’ Anusandhan", 4.2, 875000, 250, "JEE ADV", 50.0, "Odisha"));
		colleges.add(new College("IIT Bhubaneshwar", 4.1, 900000, 250, "JEE MAIN,", 60.0, "Odisha"));
		colleges.add(new College("C.V. Raman Global University", 4.0, 650000, 250, "JEE MAIN", 70.0, "Odisha"));
		colleges.add(new College("Veer Surendra Sai University", 4.0, 150000, 250, "JEE MAIN,", 60.0, "Odisha"));
		return colleges;
	}
}

// Main class to run evrything
public class EngineeringCollegeGUI {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(CustomerLogin::new); // Makes sure that the GUI is created on correct thread
	}
}
