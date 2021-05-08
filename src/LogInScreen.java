import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
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
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
