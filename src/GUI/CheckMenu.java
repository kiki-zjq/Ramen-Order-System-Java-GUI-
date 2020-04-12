package GUI;

import Entity.Available;
import Entity.Price;
import Dao.PriceDao;
import Dao.AvailableDao;

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

public class CheckMenu extends JFrame{

	private JFrame frmRamenBuffetSystem;

	Available available = new Available();
	Price price = new Price();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckMenu window = new CheckMenu();
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
	public CheckMenu() throws IOException {
		PriceDao priceDao = new PriceDao();
		this.price = priceDao.getPrice();
		AvailableDao availableDao = new AvailableDao();
		this.available = availableDao.getAvailableMsg();
		if(available.getJudgeCode().equals("01")){
			System.out.println("Ah, file Available has some problem. 666666");
			System.exit(0);
		}
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
		
		JLabel lblNewLabel = new JLabel("Here is all the menu information!");
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
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new ModifyBegin();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);
		
		JTextPane txtpnYouAlreadyHave = new JTextPane();
		txtpnYouAlreadyHave.setEditable(false);
		txtpnYouAlreadyHave.setText(
						"Price(\uFFE1) of bill and status\r\n" +
						"Ramen   " + price.getRamen() + "\r\n" +
						"Soup-Tonkotsu   free   " +available.getSoupTonkotsu() + "\r\n" +
						"Soup-Shoyu   free   " +available.getSoupShoyu() + "\r\n" +
						"Soup-Shio   free   " +available.getSoupShio() + "\r\n" +
						"Noodle-Firm   free   " +available.getNoodleFirm() + "\r\n" +
						"Noodle-Medium   free   " +available.getNoodleMedium() + "\r\n" +
						"Noodle-Soft   free   " +available.getNoodleSoft() + "\r\n" +
						"Onion   free   " +available.getOnion() + "\r\n" +
						"Nori   free   " +available.getNori() + "\r\n" +
						"Chashu   free   " +available.getChashu() + "\r\n" +
						"Boiled Egg   free   " +available.getBoiledEgg() + "\r\n" +
						"Spiciness   free   " +available.getSpiciness() + "\r\n" +
						"Bamboo   free   " +available.getBamboo() + "\r\n" +
						"\r\n" +
						"Extra Nori   " + price.getExNori() + "   " + available.getNori() + "\r\n" +
						"Extra Bamboo   " + price.getExBamboo() + "   " + available.getBamboo() + "\r\n" +
						"Extra Egg   " + price.getExEgg() + "   " + available.getBoiledEgg() + "\r\n" +
						"Extra Chashu   " + price.getExChashu() + "   " + available.getChashu());
		txtpnYouAlreadyHave.setFont(new Font("MV Boli", Font.BOLD, 21));
		txtpnYouAlreadyHave.setBounds(67, 125, 405, 244);
		panel.add(txtpnYouAlreadyHave);
		
		JScrollPane scrollPane = new JScrollPane(txtpnYouAlreadyHave);
		scrollPane.setBounds(66, 125, 406, 244);
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