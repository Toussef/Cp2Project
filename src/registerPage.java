import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registerPage extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerPage frame = new registerPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registerPage() {
		File dataFile = new File("logInDetails.txt");// to read or write from file
		Consumer clist = new Consumer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtrWelcome.setText("Welcome!");
		txtrWelcome.setEditable(false);
		txtrWelcome.setBounds(207, 11, 101, 33);
		contentPane.add(txtrWelcome);
		
		firstName = new JTextField();
		firstName.setText("First Name");
		firstName.setBounds(207, 55, 101, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setText("Last Name");
		lastName.setColumns(10);
		lastName.setBounds(207, 86, 101, 20);
		contentPane.add(lastName);
		
		
		ArrayList<Integer> ageAdder = new ArrayList<Integer>();
		for(int i = 1;i<=100;i++) {
			ageAdder.add(i);
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox ageBox = new JComboBox(ageAdder.toArray());
		ageBox.setBounds(254, 117, 54, 22);
		contentPane.add(ageBox);
		
		JTextArea txtrAge = new JTextArea();
		txtrAge.setEditable(false);
		txtrAge.setText("Age");
		txtrAge.setBounds(207, 117, 31, 23);
		contentPane.add(txtrAge);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("Email");
		txtrEmail.setBounds(207, 151, 101, 20);
		contentPane.add(txtrEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 219, 101, 20);
		contentPane.add(passwordField);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setText("Password:");
		txtrPassword.setBounds(207, 188, 76, 20);
		contentPane.add(txtrPassword);
		
		JButton doneButton = new JButton("All Done!");
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consumer newC = new Consumer();
			}
		});
		doneButton.setBounds(207, 292, 89, 23);
		contentPane.add(doneButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Have you used CYH before?");
		chckbxNewCheckBox.setBounds(207, 251, 179, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
