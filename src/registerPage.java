import java.io.*;
import java.util.*;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		//clist.removeAll(); when ne need to clear the list.
		System.out.println(clist.sequentialID());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 383);
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
		
		JCheckBox loyaltyBox = new JCheckBox("Have you used CYH before?");
		loyaltyBox.setBounds(368, 54, 227, 23);
		contentPane.add(loyaltyBox);
		
		ArrayList<String> countries = new ArrayList<String>();
		try {
			File country = new File("countries.txt");
			FileReader fr = new FileReader(country);
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine()!=null) {
				String c = br.readLine().trim();
				countries.add(c);
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox nationalityBox = new JComboBox(countries.toArray());
		nationalityBox.setBounds(207, 250, 101, 22);
		contentPane.add(nationalityBox);
	
	JButton doneButton = new JButton("All Done!");
	doneButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int age  =(Integer) ageBox.getSelectedItem();
			String nationality = (String) nationalityBox.getSelectedItem();
			Person newC = new Consumer(firstName.getText(),lastName.getText(),age, nationality,txtrEmail.getText(),String.valueOf(passwordField.getPassword()),false,10.0);
			clist.addConsumer((Consumer) newC);
			((Consumer) newC).setId(clist.sequentialID());
			if(loyaltyBox.isSelected()) {
				((Consumer) newC).setLoyalCustomer(true);
			}
			try {
				FileWriter fw = new FileWriter(dataFile);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(((Consumer) newC).getId()+"\n");
				bw.write(newC.getFirstName()+"\n");
				bw.write(newC.getLastName()+"\n");
				bw.write(newC.getAge()+"\n");
				bw.write(newC.getNationality()+"\n");
				bw.write(((Consumer) newC).getEmailAddress()+"\n");
				bw.write(((Consumer) newC).getPassword()+"\n");
				if(((Consumer) newC).isLoyalCustomer()==true) {
					bw.write("true\n");
				}else {
					bw.write("false\n");
				}
				bw.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			} catch (InvalidPasswordException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	doneButton.setBounds(207, 312, 89, 23);
	contentPane.add(doneButton);
}
}
