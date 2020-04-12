package GUI;

import Entity.Bill;
import Entity.Price;
import Control.ControlBill;
import Dao.PriceDao;

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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Ordering4 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	
	Bill bill = new Bill();
	Price price = new Price();


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordering4 window = new Ordering4();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Ordering4(Bill bill) throws IOException {
		PriceDao priceDao = new PriceDao();
		ControlBill cb = new ControlBill(bill);
		this.price = priceDao.getPrice();
		this.bill = cb.setBillMsg(bill);
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
		
		JButton btnNewButton_1 = new JButton("Eat-in");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setPacket("Eat-in");
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 28));
		btnNewButton_1.setBounds(42, 378, 141, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Ordering3(bill);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 28));
		btnNewButton.setBounds(356, 378, 141, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please check the order!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(90, 89, 361, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(68, 24, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Take-out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setPacket("Take-out");
				frmRamenBuffetSystem.setVisible(false);
				new Login1(bill);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnNewButton_1_1.setBounds(205, 378, 141, 61);
		panel.add(btnNewButton_1_1);
		
		JTextPane txtpnOrderInformation = new JTextPane();
		txtpnOrderInformation.setFont(new Font("MV Boli", Font.BOLD, 22));
		txtpnOrderInformation.setText("Order information:\r\n"
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
		txtpnOrderInformation.setBounds(42, 146, 451, 222);
		panel.add(txtpnOrderInformation);
		
		JScrollPane scrollPane = new JScrollPane(txtpnOrderInformation);
		scrollPane.setBounds(42, 146, 451, 222);
		panel.add(scrollPane);
		txtpnOrderInformation.setCaretPosition(0);
	}
}