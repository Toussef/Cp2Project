import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Button;
import javax.swing.JButton;

public class bookingPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookingPage frame = new bookingPage();
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
	@SuppressWarnings("unchecked")
	public bookingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrLetsBookShall = new JTextArea();
		txtrLetsBookShall.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txtrLetsBookShall.setText("Let's book, shall we placeholder?");
		txtrLetsBookShall.setEditable(false);
		txtrLetsBookShall.setBounds(197, 0, 287, 28);
		contentPane.add(txtrLetsBookShall);
		
		JTextArea firstName = new JTextArea();
		firstName.setEditable(false);
		firstName.setBounds(43, 63, 132, 28);
		contentPane.add(firstName);
		
		JTextArea lastName = new JTextArea();
		lastName.setEditable(false);
		lastName.setBounds(255, 63, 132, 28);
		contentPane.add(lastName);
		
		JTextArea ageBox = new JTextArea();
		ageBox.setBounds(495, 63, 61, 28);
		contentPane.add(ageBox);
		
		JTextArea currentCbox = new JTextArea();
		currentCbox.setEditable(false);
		currentCbox.setText("Current country:");
		currentCbox.setBounds(43, 133, 132, 28);
		contentPane.add(currentCbox);
		
		ArrayList<String> countries = new ArrayList<String>();
		File countriesF = new File("countries.txt");
		try {
			FileReader fr = new FileReader (countriesF);
			BufferedReader br = new BufferedReader(fr);
			
			while(br.readLine()!=null) {
				String c = br.readLine().trim();
				countries.add(c);
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		@SuppressWarnings({ "rawtypes" })
		JComboBox currentC = new JComboBox(countries.toArray());
		currentC.setBounds(64, 172, 81, 28);
		contentPane.add(currentC);
		
		JTextArea destinationBox = new JTextArea();
		destinationBox.setText("Destination Country");
		destinationBox.setEditable(false);
		destinationBox.setBounds(255, 133, 172, 28);
		contentPane.add(destinationBox);
		
		@SuppressWarnings("rawtypes")
		JComboBox destinationC = new JComboBox(countries.toArray());
		destinationC.setBounds(281, 172, 81, 28);
		contentPane.add(destinationC);
		
		JTextArea membersBox = new JTextArea();
		membersBox.setEditable(false);
		membersBox.setText("Members:");
		membersBox.setBounds(487, 133, 69, 28);
		contentPane.add(membersBox);
		ArrayList<Integer> mems = new ArrayList<Integer>();//to add the numbers using iteration
		for(int i = 1;i<=10;i++) {
			mems.add(i);
		}
		JComboBox membersCBox = new JComboBox(mems.toArray());
		membersCBox.setBounds(495, 175, 49, 22);
		contentPane.add(membersCBox);
		
		JCheckBox familyChecl = new JCheckBox("Family?");
		familyChecl.setBounds(582, 138, 74, 23);
		contentPane.add(familyChecl);
		
		JButton checkoutBtn = new JButton("Checkout");
		checkoutBtn.setBounds(197, 266, 89, 23);
		contentPane.add(checkoutBtn);
		
		JButton paypalBtn = new JButton("PayPal");
		paypalBtn.setBounds(395, 266, 89, 23);
		contentPane.add(paypalBtn);
	}
}
