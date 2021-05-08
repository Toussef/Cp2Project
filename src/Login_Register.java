import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Login_Register {

	private JFrame frame;
	private JTextField txtV;
	private JTextField txtCyhTravel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Register window = new Login_Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 144, 20);
		frame.getContentPane().add(toolBar);
		
		JButton helpButton = new JButton("Help");//help button found within the toolbar.
		helpButton.addMouseListener(new MouseAdapter() {
			JTextField helpText = new JTextField();//line containing help tool tip.
			@Override
			public void mouseEntered(MouseEvent e) {
		//	JTextField helpText = new JTextField();//line containing help tool tip.
			helpText.setText("Please contact us over at CYHtravel.com");
			helpText.setBounds(10,11,158,30);
			helpText.setFont(helpText.getFont().deriveFont((9)));
			frame.getContentPane().add(helpText);
			}
			@SuppressWarnings("deprecation")
			public void mouseExited(MouseEvent e) {
			helpText.hide();
			}
			
		});
		toolBar.add(helpButton);
		
		txtV = new JTextField();
		txtV.setText("V0.1");
		txtV.setBounds(509, 370, 32, 20);
		frame.getContentPane().add(txtV);
		txtV.setColumns(10);
		
		txtCyhTravel = new JTextField();
		txtCyhTravel.setEditable(false);
		txtCyhTravel.setHorizontalAlignment(SwingConstants.CENTER);
		txtCyhTravel.setText("CYH Travel");
		txtCyhTravel.setBounds(195, 47, 124, 70);
		frame.getContentPane().add(txtCyhTravel);
		txtCyhTravel.setColumns(10);
		
		Icon logIn = new ImageIcon("loginRS.png");
		JButton loginButton = new JButton(logIn);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogInScreen l1 = new LogInScreen();
				l1.setVisible(true);
				frame.hide();
			}
		});
		loginButton.setBounds(98, 185, 100, 51);
		frame.getContentPane().add(loginButton);
		
		Icon registerPic = new ImageIcon("registerRS.jpg");
		JButton register = new JButton(registerPic);
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerPage r1 = new registerPage();
				r1.setVisible(true);
				frame.hide();
			}
		});
		register.setBounds(338, 185, 100, 51);		
		frame.getContentPane().add(register);
	}
}
