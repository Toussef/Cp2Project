import java.io.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountHistory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountHistory frame = new AccountHistory();
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
	public AccountHistory() {
		File loginDeets = new File("loggedIn.txt");
		String name = "";
		String age = "";
		String email = "";
		String nationality = "";
		String loyal = "";
		try {
			Scanner scan = new Scanner(loginDeets);
			scan.nextLine();
			String fname = scan.nextLine();
			String lname = scan.nextLine();
			name = fname+ " "+ lname;
			age = scan.nextLine();
			nationality = scan.nextLine();
			email = scan.nextLine();
			scan.nextLine();
			loyal = scan.nextLine();
			scan.close();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea nameBox = new JTextArea("Your Name: "+name);
		nameBox.setEditable(false);
		nameBox.setBounds(45, 52, 167, 34);
		contentPane.add(nameBox);
		
		JTextArea ageBox = new JTextArea("Age: "+ age);
		ageBox.setEditable(false);
		//ageBox.setText("Age:");
		ageBox.setBounds(282, 52, 167, 34);
		contentPane.add(ageBox);
		
		JTextArea mailBox = new JTextArea("Email: "+email);
		mailBox.setEditable(false);
		mailBox.setBounds(45, 127, 167, 34);
		contentPane.add(mailBox);
		
		JTextArea nationalityBox = new JTextArea("Nationality: "+nationality);
		nationalityBox.setEditable(false);
		nationalityBox.setBounds(282, 127, 167, 34);
		contentPane.add(nationalityBox);
		
		JTextArea loyalCus = new JTextArea("Loyal status: "+loyal);
		loyalCus.setBounds(157, 212, 172, 34);
		contentPane.add(loyalCus);
		
		JButton btnNewButton = new JButton("Back to Main Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.hide();
				mainPage p1 = new mainPage();
				p1.show();
			}
		});
		btnNewButton.setBounds(182, 278, 123, 34);
		contentPane.add(btnNewButton);
	}

}
