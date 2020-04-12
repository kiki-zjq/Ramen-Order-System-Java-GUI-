package GUI;

import Entity.Bill;
import Entity.Price;
import Entity.Customer;

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
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Pay2 extends JFrame{

	private JFrame frmRamenBuffetSystem;

	Bill bill = new Bill();
	Customer customer = new Customer();
	Price price = new Price();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay2 window = new Pay2();
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
	public Pay2(Bill bill, Price price, Customer customer) {
		this.bill = bill;
		this.customer = customer;
		this.price = price;
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
		
		JLabel lblNewLabel = new JLabel("Successful payment!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(90, 64, 361, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Ordering1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(177, 374, 176, 61);
		panel.add(btnNewButton_1);
		
		JTextPane txtpnYouAlreadyHave = new JTextPane();
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setText("Invoice printing completed!\r\n"
				+ "We have sent you SMS and email!\r\n"
				+ "Please check your SMS and email!\r\n"
				+ "Order information:"
				+ "Customer ID:" + customer.getUid() + "\r\n"
				+ "Customer Name:" + customer.getSurname() + "\r\n"
				+ bill.getPacket() + "\r\n"
				+ "\r\n"
				+ "Ramen    "+ price.getRamen() + "\r\n"
				+ "Soup   " + bill.getSoup() + "\r\n"
				+ "Noodles   " + bill.getNood() + "\r\n"
				+ "Spring onion   " + bill.getOnion() + "\r\n"
				+ "Nori   " + bill.getNori() + "\r\n"
				+ "Chashu   " + bill.getChashu() + "\r\n"
				+ "Boiled egg   " + bill.getBoiledEgg() + "\r\n"
				+ "Spiciness   " + bill.getSpiciness() + "\r\n"
				+ "\r\n"
				+ "Extra Nori   " + bill.getExtraNori() + "   " + price.getExNori() + "\r\n"
				+ "Extra boiled egg   " + bill.getExtraEgg() + "   " + price.getExEgg() + "\r\n"
				+ "Bamboo shoots   " + bill.getBambooShoot() + "   " + price.getExBamboo() + "\r\n"
				+ "Extra Chashu   " + bill.getExtraChashu() + "   " + price.getExChashu() + "\r\n"
				+ "\r\n"
				+ "Total amount:   " + bill.getPrice() + "\r\n"
				+ "Virtual stamp:   " + customer.getStamp() + "\r\n"
				+ "Click Confirm to jump to the ordering interface!");
		txtpnYouAlreadyHave.setFont(new Font("MV Boli", Font.BOLD, 22));
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setBounds(55, 125, 430, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0);
	}
}