package GUI;

import Entity.Bill;
import Entity.Customer;
import Entity.Price;
import Dao.PriceDao;
import Dao.CustomerDao;
import Dao.BillDao;
import Dao.ReceiptDao;

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

public class Pay1 extends JFrame{

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
					Pay1 window = new Pay1();
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
	public Pay1(Bill bill, Customer customer) throws IOException {
		this.customer = customer;
		this.bill = bill;
		PriceDao priceDao = new PriceDao();
		price = priceDao.getPrice();
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
		
		JLabel lblNewLabel = new JLabel("Please select the mode of payment!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(34, 64, 471, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Use stamps");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setStamp(customer.getStamp() - 10);
				CustomerDao customerDao = new CustomerDao();
				bill.setIfFree("Yes");
				bill.setPayoption("stamp");
				try {
					BillDao billDao = new BillDao();
					billDao.saveBillMsg(bill);
					ReceiptDao receiptDao = new ReceiptDao();
					receiptDao.setReceipt(bill, customer);
					if(customerDao.saveCustomer(customer) == 0){
						System.out.println("Ah, your program crash because of your customer file!");
						System.exit(0);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frmRamenBuffetSystem.setVisible(false);
				new Pay2(bill, price, customer);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		//btnNewButton_1.setBounds(23, 379, 176, 61);
		btnNewButton_1.setBounds(209, 379, 176, 61);
		if(customer.getStamp() < 10)  btnNewButton_1.setVisible(false);
		panel.add(btnNewButton_1);
		
		JTextPane txtpnYouAlreadyHave = new JTextPane();
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setText(
				"Order information:\r\n"
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
						+ "10 stamps can pay a bill!");
		txtpnYouAlreadyHave.setFont(new Font("MV Boli", Font.BOLD, 22));
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 25));
		btnNewButton.setBounds(392, 379, 133, 61);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Cash/card");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setStamp(customer.getStamp() + 1);
				CustomerDao customerDao = new CustomerDao();
				bill.setIfFree("No");
				bill.setPayoption("cash");
				bill.setUid("000000");
				try {
					BillDao billDao = new BillDao();
					billDao.saveBillMsg(bill);
					ReceiptDao receiptDao = new ReceiptDao();
					receiptDao.setReceipt(bill, customer);
					if(customerDao.saveCustomer(customer) == 0){
						System.out.println("Ah, your program crash because of your customer file!");
						System.exit(0);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				frmRamenBuffetSystem.setVisible(false);
				new Pay2(bill, price, customer);
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		//btnNewButton_1_1.setBounds(209, 379, 176, 61);
		btnNewButton_1_1.setBounds(23, 379, 176, 61);
		panel.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(67, 125, 405, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0);
	}
}