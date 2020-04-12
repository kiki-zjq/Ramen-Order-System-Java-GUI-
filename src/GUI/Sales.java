package GUI;

import Entity.Statistics;
import Dao.BillDao;

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

public class Sales extends JFrame{

	private JFrame frmRamenBuffetSystem;

	Statistics statistics = new Statistics();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales window = new Sales();
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
	public Sales() throws IOException {
		BillDao billDao = new BillDao();
		statistics = billDao.getStatistic();
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
		
		JLabel lblNewLabel = new JLabel("Here is all the sales situation!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(38, 64, 470, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("State");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new StatisticsGUI(statistics);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);
		
		JTextPane txtpnYouAlreadyHave = new JTextPane();
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setText("Statistics" + "\r\n" +
				"Soup" + "\r\n" +
				"Soup-Tonkotsu      " + statistics.getSoupTonkotsu() + "\r\n" +
				"Soup-Shoyu      " + statistics.getSoupShoyu() + "\r\n" +
				"Soup-Shio      " + statistics.getSoupShio() + "\r\n" +
				"\r\n" +
				"Noodle" + "\r\n" +
				"Noodle-Soft      " + statistics.getNoodleSoft() + "\r\n" +
				"Noodle-Medium      " + statistics.getNoodleMedium() + "\r\n" +
				"Noodle-Firm      " + statistics.getNoodleFirm() + "\r\n" +
				"\r\n" +
				"Onion" + "\r\n" +
				"Onion-No      " + statistics.getOnionNo() + "\r\n" +
				"Onion-Little      " + statistics.getOnionLittle() + "\r\n" +
				"Onion-Lot      " + statistics.getOnionLot() + "\r\n" +
				"\r\n" +
				"Nori" + "\r\n" +
				"Nori-Yes      " + statistics.getNoriY() + "\r\n" +
				"Nori-No      " + statistics.getNoriN() + "\r\n" +
				"\r\n" +
				"Chashu" + "\r\n" +
				"Chashu-Yes      " + statistics.getChashuY() + "\r\n" +
				"Chashu-No      " + statistics.getChashuN() + "\r\n" +
				"\r\n" +
				"BoiledEgg" + "\r\n" +
				"BoiledEgg-Yes      " + statistics.getBoiledEggY() + "\r\n" +
				"BoiledEgg-No      " + statistics.getBoiledEggN() + "\r\n" +
				"\r\n" +
				"Spiciness" + "\r\n" +
				"Spiciness-0      " + statistics.getSpiciness0() + "\r\n" +
				"Spiciness-1      " + statistics.getSpiciness1() + "\r\n" +
				"Spiciness-2      " + statistics.getSpiciness2() + "\r\n" +
				"Spiciness-3      " + statistics.getSpiciness3() + "\r\n" +
				"Spiciness-4      " + statistics.getSpiciness4() + "\r\n" +
				"Spiciness-5      " + statistics.getSpiciness5() + "\r\n" +
				"\r\n" +
				"ExtraNori" + "\r\n" +
				"ExtraNori-Yes      " + statistics.getExtraNoriY() + "\r\n" +
				"ExtraNori-No      " + statistics.getExtraNoriN() + "\r\n" +
				"\r\n" +
				"ExtraBoiledEgg" + "\r\n" +
				"ExtraBoiledEgg-Yes      " + statistics.getBoiledEggY() + "\r\n" +
				"ExtraBoiledEgg-No      " + statistics.getBoiledEggN() + "\r\n" +
				"\r\n" +
				"BambooShoots" + "\r\n" +
				"BambooShoots-Yes      " + statistics.getBambooShootsY() + "\r\n" +
				"BambooShoots-No      " + statistics.getBambooShootsN() + "\r\n" +
				"\r\n" +
				"ExtraChashu" + "\r\n" +
				"ExtraChashu-Yes      " + statistics.getChashuY() + "\r\n" +
				"ExtraChashu-No      " + statistics.getChashuN() + "\r\n" +
				"\r\n" +
				"Pay option" + "\r\n" +
				"Cash      " + statistics.getPayOption() + "\r\n" +
				"Stamp      " + statistics.getIfFreeY() + "\r\n" +
				"\r\n" +
				"Total Bill     " + statistics.getTotalBill() + "\r\n" +
				"Total Price      " + statistics.getTotalPrice());
		txtpnYouAlreadyHave.setFont(new Font("MV Boli", Font.BOLD, 21));
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setBounds(58, 125, 430, 244);
		panel.add(scrollPane);
		txtpnYouAlreadyHave.setCaretPosition(0);
		
		JButton btnNewButton_1_1 = new JButton("Return");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Manage();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(332, 386, 176, 61);
		panel.add(btnNewButton_1_1);
	}
}