package GUI;

import Entity.Bill;
import Entity.Customer;
import Dao.CustomerDao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Login2 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;

	Bill bill = new Bill();
	Customer customer = new Customer();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 window = new Login2();
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
	public Login2(Bill bill) {
		this.bill= bill;
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
		
		JLabel lblNewLabel = new JLabel("Please enter your membership number!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 140, 528, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 56, 405, 74);
		panel.add(lblNewLabel_1);
		
		/*JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDao customerDao = new CustomerDao();
				try {
					customer = customerDao.getCustMsg(lblNewLabel_1.getText());
					if(customer.getJudgeCode().equals("000")){
						frmRamenBuffetSystem.setVisible(false);
						new Pay1(bill, customer);
					}
					if(customer.getJudgeCode().equals("110")){
						System.out.println("Oh my god! We cannot find customer file...");
						System.exit(0);
					}
					if(customer.getJudgeCode().equals("111")){
						lblNewLabel.setText("This userID does not exit");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(49, 366, 176, 61);
		panel.add(btnNewButton_1);*/
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(314, 366, 176, 61);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD, 24));
		textField.setBounds(68, 236, 405, 65);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDao customerDao = new CustomerDao();
				try {
					customer = customerDao.getCustMsg(textField.getText());
					if(customer.getJudgeCode().equals("000")){
						frmRamenBuffetSystem.setVisible(false);
						new Pay1(bill, customer);
					}
					if(customer.getJudgeCode().equals("110")){
						System.out.println("Oh my god! We cannot find customer file...");
						System.exit(0);
					}
					if(customer.getJudgeCode().equals("111")){
						lblNewLabel.setText("This userID does not exit");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(49, 366, 176, 61);
		panel.add(btnNewButton_1);

	}
}