import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.DropMode;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class registerPage extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;

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
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setText("First Name");
		txtrFirstName.setEditable(false);
		txtrFirstName.setBounds(207, 82, 101, 22);
		contentPane.add(txtrFirstName);
		
		JTextArea txtrLastName = new JTextArea();
		txtrLastName.setText("Last Name");
		txtrLastName.setEditable(false);
		txtrLastName.setBounds(207, 146, 101, 22);
		contentPane.add(txtrLastName);
		
		firstName = new JTextField();
		firstName.setBounds(207, 115, 101, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(207, 179, 101, 20);
		contentPane.add(lastName);
		
		
		JComboBox<String> ageBox = new JComboBox<String>();
		
		ageBox.setBounds(241, 210, 28, 22);
		contentPane.add(ageBox);
	}
}
