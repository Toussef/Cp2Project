import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class LogInScreen extends JFrame {

	private JPanel contentPane;
	private JTextField emailInput;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInScreen frame = new LogInScreen();
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
	public LogInScreen() {
		File dataList = new File("logInDetails.txt");
		Person clist = new Consumer();
		try {
			Scanner scan = new Scanner(dataList);
			//FileReader fr = new FileReader(dataList);
			@SuppressWarnings("resource")
			//BufferedReader br = new BufferedReader(fr);
			int idCounter=0;
			
			while(scan.hasNextLine()) {
			((Consumer)clist).addConsumer(new Consumer(null, null, 12,null, null, null,false, 0 ));
			//System.out.println(br.readLine());
			//System.out.println(scan.nextLine());
			((Consumer)clist).get(idCounter).setId(Integer.valueOf(scan.nextLine()));
			((Consumer)clist).get(idCounter).setFirstName(scan.nextLine());
			((Consumer)clist).get(idCounter).setLastName(scan.nextLine());
			((Consumer)clist).get(idCounter).setAge(Integer.valueOf(scan.nextLine()));
			((Consumer)clist).get(idCounter).setNationality(scan.nextLine());
			((Consumer)clist).get(idCounter).setEmailAddress(scan.nextLine());
			((Consumer)clist).get(idCounter).setPassword(scan.nextLine());
			String loyalityC = scan.nextLine();
			if(loyalityC.equals("true")) {
				((Consumer)clist).get(idCounter).setLoyalCustomer(true);
			}else {
				((Consumer)clist).get(idCounter).setLoyalCustomer(false);
			}
			idCounter+=1;
		
			}
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println(((Consumer)clist).get(0).toString()); works woohoo :D
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 120, 30);
		contentPane.add(toolBar);
		
		JButton helpButton = new JButton("Help");//help button found within the toolbar.
	
		helpButton.addMouseListener(new MouseAdapter() {
			JTextField helpText = new JTextField();//line containing help tool tip.
			@Override
			public void mouseEntered(MouseEvent e) {
		//	JTextField helpText = new JTextField();//line containing help tool tip.
			helpText.setText("Please contact us over at CYHtravel.com");
			helpText.setBounds(10,11,158,40);
			helpText.setFont(helpText.getFont().deriveFont((9)));
			contentPane.add(helpText);
			}
			@SuppressWarnings("deprecation")
			public void mouseExited(MouseEvent e) {
			helpText.hide();
			}
			
		});
		toolBar.add(helpButton);
		
		emailInput = new JTextField();
		emailInput.setHorizontalAlignment(SwingConstants.CENTER);
		emailInput.setBounds(176, 109, 218, 22);
		contentPane.add(emailInput);
		emailInput.setColumns(10);
		
		JTextArea emailBox = new JTextArea();
		emailBox.setEditable(false);
		emailBox.setText("Email");
		emailBox.setBounds(176, 76, 45, 22);
		contentPane.add(emailBox);
		
		JTextArea passBox = new JTextArea();
		passBox.setText("Password");
		passBox.setEditable(false);
		passBox.setBounds(176, 142, 84, 22);
		contentPane.add(passBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 175, 218, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log-in!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void mouseClicked(MouseEvent e) {
				File loggedIn = new File("loggedIn.txt");
				int size = ((Consumer)clist).sequentialID();
				String email = emailInput.getText();
				char[] pass = passwordField.getPassword();
				
				System.out.println(email+"\n"+pass);
				System.out.println(((Consumer)clist).get(0).toString());
				for(int i = 0;i<size;i++) {
					try {
						char[] correctPass = ((Consumer)clist).get(i).getPassword().toCharArray();

						if(email.equalsIgnoreCase(((Consumer)clist).get(i).getEmailAddress())&&Arrays.equals(pass,correctPass)) {
							FileWriter fw = new FileWriter(loggedIn);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(((Consumer)clist).get(i).toString());
							bw.close();
							contentPane.setVisible(false);
							mainPage m1 = new mainPage();
							m1.setVisible(true);
						}else {
							throw new wrongEmailPassException();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (wrongEmailPassException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.toString());
					} catch (InvalidPasswordException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(229, 237, 89, 23);
		contentPane.add(btnNewButton);
		
		JTextArea txtrV = new JTextArea();
		txtrV.setText("V 0.1");
		txtrV.setEditable(false);
		txtrV.setBounds(495, 313, 54, 22);
		contentPane.add(txtrV);
	}
}
