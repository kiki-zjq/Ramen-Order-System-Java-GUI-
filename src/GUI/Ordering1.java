package GUI;

import Entity.Bill;
import Entity.Price;
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

public class Ordering1 extends JFrame{

	private JFrame frmRamenBuffetSystem1;

	Bill bill = new Bill();
	Price price = new Price();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordering1 window = new Ordering1();
					window.frmRamenBuffetSystem1.setVisible(true);
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
	public Ordering1() throws IOException {
		PriceDao priceDao = new PriceDao();
		this.price = priceDao.getPrice();
		initialize();
		frmRamenBuffetSystem1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRamenBuffetSystem1 = new JFrame();
		frmRamenBuffetSystem1.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem1.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem1.setBounds(100, 100, 582, 529);
		frmRamenBuffetSystem1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(42, 378, 176, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(321, 378, 176, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please choose staple food!");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "The staple food", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(42, 152, 455, 216);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Ramen   \uFFE1" + price.getRamen());
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem1.setVisible(false);
				try {
					new Ordering2();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 28));
		btnNewButton_2.setBounds(63, 26, 331, 59);
		panel_1.add(btnNewButton_2);
	}
}