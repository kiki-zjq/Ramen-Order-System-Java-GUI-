package GUI;

import Dao.BillDao;
import Dao.ReceiptDao;
import Entity.Bill;
import Entity.Price;
import Dao.PriceDao;
import Entity.Customer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DirectPay extends JFrame{

	private JFrame frmRamenBuffetSystem;

	Bill bill = new Bill();
	Price price = new Price();
	Customer customer = new Customer();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectPay window = new DirectPay();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public DirectPay(Bill bill) throws IOException {
		this.customer.setFirname("null");
		this.customer.setSurname("null");
		this.bill = bill;
		PriceDao priceDao = new PriceDao();
		price = priceDao.getPrice();
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	private void initialize() {
		frmRamenBuffetSystem = new JFrame();
		frmRamenBuffetSystem.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem.setBounds(100, 100, 582, 529);
		frmRamenBuffetSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setToolTipText("123");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Toroto Ramen");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(69, 10, 405, 74);
		panel.add(lblNewLabel_2);
		
		JTextPane txtpnOrderInformation = new JTextPane();
		txtpnOrderInformation.setFont(new Font("MV Boli", Font.BOLD, 22));
		txtpnOrderInformation.setText("Order information:"
				+ bill.getPacket() + "\r\n"
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
				+ "Total amount:   " + bill.getPrice());
		txtpnOrderInformation.setEditable(false);
		txtpnOrderInformation.setBounds(79, 96, 377, 376);
		panel.add(txtpnOrderInformation);
		
		JScrollPane scrollPane = new JScrollPane(txtpnOrderInformation);
		scrollPane.setBounds(69, 120, 405, 244);
		panel.add(scrollPane);
		txtpnOrderInformation.setCaretPosition(0);
		
		JLabel lblNewLabel = new JLabel("Please select the mode of payment!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(33, 59, 471, 66);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Cash/card");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					bill.setIfFree("No");
					bill.setPayoption("cash");
					BillDao billDao = new BillDao();
					billDao.saveBillMsg(bill);
					new DirectPay2(bill);
					ReceiptDao receiptDao = new ReceiptDao();
					receiptDao.setReceipt(bill, customer);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 25));
		btnNewButton_1_1.setBounds(52, 386, 176, 61);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 25));
		btnNewButton.setBounds(360, 386, 133, 61);
		panel.add(btnNewButton);
	}
}
