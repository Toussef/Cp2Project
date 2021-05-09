import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPage frame = new mainPage();
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
	public mainPage() {
		String fName = "";
		File loggedIn = new File("loggedIn.txt");
		try {
			FileReader fr = new FileReader(loggedIn);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			fName= br.readLine();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrV = new JTextArea();
		txtrV.setText("V 0.1");
		txtrV.setBounds(584, 424, 61, 22);
		contentPane.add(txtrV);
		
		JTextArea welcomeMessage = new JTextArea();
		welcomeMessage.setEditable(false);
		welcomeMessage.setLineWrap(true);
		welcomeMessage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		welcomeMessage.setText("Welcome "+fName);
		welcomeMessage.setBounds(194, 55, 237, 34);
		contentPane.add(welcomeMessage);
		
		JButton bookingButton = new JButton("Booking");
		bookingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				bookingPage p1 = new bookingPage();
				p1.setVisible(true);
			}
		});
		bookingButton.setBounds(211, 130, 202, 48);
		contentPane.add(bookingButton);
		
		JButton historyButton = new JButton("History");
		historyButton.setBounds(211, 214, 202, 48);
		contentPane.add(historyButton);
		
		JButton accountInfo = new JButton("Account Options");
		accountInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.hide();
				AccountHistory a1 = new AccountHistory();
				a1.show();
			}
		});
		accountInfo.setBounds(211, 302, 202, 48);
		contentPane.add(accountInfo);
	}

}
