package GUI;

import Entity.Bill;
import Entity.Price;
import Dao.PriceDao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class DirectPay2 extends JFrame{

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
					DirectPay2 window = new DirectPay2();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public DirectPay2(Bill bill) throws IOException {
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
		
		JLabel lblNewLabel = new JLabel("Successful payment!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(91, 68, 361, 66);
		panel.add(lblNewLabel);
		
		JTextPane txtpnInvoicePrintingCompleted = new JTextPane();
		txtpnInvoicePrintingCompleted.setText("Invoice printing completed!\r\n"
						+ "Order information:\r\n"
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
						+ "Total amount:   " + bill.getPrice() + "\r\n"
						+ "Click Confirm to jump to the ordering interface!");
		txtpnInvoicePrintingCompleted.setFont(new Font("MV Boli", Font.BOLD, 22));
		txtpnInvoicePrintingCompleted.setEditable(false);
		txtpnInvoicePrintingCompleted.setBounds(71, 135, 403, 240);
		panel.add(txtpnInvoicePrintingCompleted);
		
		JScrollPane scrollPane = new JScrollPane(txtpnInvoicePrintingCompleted);
		scrollPane.setBounds(69, 135, 405, 240);
		panel.add(scrollPane);
		txtpnInvoicePrintingCompleted.setCaretPosition(0);
		
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
		btnNewButton_1.setBounds(185, 385, 176, 61);
		panel.add(btnNewButton_1);
	}

}
