package GUI;

import Entity.Customer;
import Entity.Bill;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Registered2 extends JFrame{

	private JFrame frmRamenBuffetSystem;

	Bill bill = new Bill();
	Customer customer = new Customer();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registered2 window = new Registered2();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Registered2(Bill bill, Customer customer) {
		this.bill = bill;
		this.customer = customer;
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRamenBuffetSystem = new JFrame();
		frmRamenBuffetSystem.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem.setBounds(100, 100, 582, 529);
		frmRamenBuffetSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registered successfully!");
		lblNewLabel.setBounds(90, 64, 361, 66);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Pay1(bill, customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(177, 374, 176, 61);
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		panel.add(btnNewButton_1);
		
		JTextPane txtpnYouAlreadyHave = new JTextPane();
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setText(
				"Registration completed!\r\n" +
				"We have sent you SMS and email!\r\n" +
				"Please check your SMS and email!\r\n" +
				"Account information:\r\n" +
				"Name:  " + customer.getFirname() + " "+ customer.getSurname() + "\r\n" +
				"Phone:  " + customer.getMobile() + "\r\n" +
				"Email:  " + customer.getEmail() + "\r\n" +
				"Click Confirm to jump to the payment interface!");
		txtpnYouAlreadyHave.setFont(new Font("MV Boli", Font.BOLD, 22));
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(65, 120, 405, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0); 

		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setBounds(89, -23, 362, 153);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	}
}