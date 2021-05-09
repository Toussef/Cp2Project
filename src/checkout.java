import java.io.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class checkout extends JFrame {

	private JPanel contentPane;
	private JTextField cardNameField;
	private JTextField textField;
	private JTextField expBox;
	private JTextField ccvBox;
	private JTextField priceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkout frame = new checkout();
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
	public checkout() {
		File bookings = new File("bookings.txt");
		double totalPrice = 0;
		String familyCheck = "";
		try {
			Scanner scan = new Scanner(bookings);
			for(int i = 0;i<4;i++) {
				scan.nextLine();
			}
			int members = Integer.valueOf(scan.nextLine());
			totalPrice = members*250.5;
			familyCheck = scan.nextLine();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		if(familyCheck.equals("true")) {
			totalPrice = totalPrice*0.9;//apply a 10% discount for families.
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrCheckoutTime = new JTextArea();
		txtrCheckoutTime.setEditable(false);
		txtrCheckoutTime.setText("Checkout time!");
		txtrCheckoutTime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtrCheckoutTime.setBounds(203, 11, 170, 28);
		contentPane.add(txtrCheckoutTime);
		
		JTextArea fNameTxt = new JTextArea();
		fNameTxt.setEditable(false);
		fNameTxt.setText("Name Found on Card:");
		fNameTxt.setBounds(36, 64, 175, 28);
		contentPane.add(fNameTxt);
		
		cardNameField = new JTextField();
		cardNameField.setBounds(36, 119, 175, 28);
		contentPane.add(cardNameField);
		cardNameField.setColumns(10);
		
		JTextArea cardTypetxt = new JTextArea();
		cardTypetxt.setText("Card Type:");
		cardTypetxt.setEditable(false);
		cardTypetxt.setBounds(419, 64, 114, 28);
		contentPane.add(cardTypetxt);
		
		String [] cards = {"MasterCard","Visa","American Express"};
		JComboBox cardCombo = new JComboBox(cards);
		cardCombo.setBounds(419, 119, 101, 22);
		contentPane.add(cardCombo);
		
		JTextArea CardNumbertxt = new JTextArea();
		CardNumbertxt.setText("Card Number:");
		CardNumbertxt.setEditable(false);
		CardNumbertxt.setBounds(36, 199, 101, 28);
		contentPane.add(CardNumbertxt);
		
		textField = new JTextField();
		textField.setBounds(36, 259, 170, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea expTxt = new JTextArea();
		expTxt.setText("Card Expiry Date:");
		expTxt.setEditable(false);
		expTxt.setBounds(383, 199, 141, 28);
		contentPane.add(expTxt);
		
		expBox = new JTextField();
		expBox.setBounds(395, 259, 114, 28);
		contentPane.add(expBox);
		expBox.setColumns(10);
		
		JTextArea CCVtxt = new JTextArea();
		CCVtxt.setText("CCV code:");
		CCVtxt.setEditable(false);
		CCVtxt.setBounds(36, 322, 114, 22);
		contentPane.add(CCVtxt);
		
		ccvBox = new JTextField();
		ccvBox.setBounds(36, 366, 114, 28);
		contentPane.add(ccvBox);
		ccvBox.setColumns(10);
		priceTxt = new JTextField(String.valueOf(totalPrice));
		priceTxt.setEditable(false);
		priceTxt.setBounds(302, 351, 96, 20);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton pButton = new JButton("Complete Purchase");
		pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Purchase confirmed! Stay safe and see you soon!");
				contentPane.setVisible(false);
				mainPage m1 = new mainPage();
				m1.setVisible(true);
			}
		});
		pButton.setBounds(444, 350, 127, 23);
		contentPane.add(pButton);
		
	}	
}
