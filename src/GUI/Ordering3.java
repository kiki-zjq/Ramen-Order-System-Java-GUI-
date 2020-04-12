package GUI;

import Entity.Bill;
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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Ordering3 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	
	Bill bill = new Bill();
	Price price = new Price();
	Available available = new Available();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordering3 window = new Ordering3();
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
	public Ordering3(Bill bill) throws IOException {
		PriceDao priceDao = new PriceDao();
		this.price = priceDao.getPrice();
		AvailableDao availableDao = new AvailableDao();
		this.available = availableDao.getAvailableMsg();
		this.bill = bill;
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
		
		/*JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Ordering4();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(44, 401, 176, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Ordering2();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(328, 401, 176, 61);
		panel.add(btnNewButton);*/
		
		JLabel lblNewLabel = new JLabel("Please choose your ingredients!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(36, 42, 455, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 0, 405, 74);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ingredients area", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(42, 95, 462, 296);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Extra Nori");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 21, 142, 28);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Extra boiled egg");
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(10, 59, 199, 28);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Bamboo shoots");
		lblNewLabel_2_2.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setBounds(10, 97, 199, 28);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Extra Chashu");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2_2_1.setBounds(10, 135, 180, 28);
		panel_1.add(lblNewLabel_2_2_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox.setBounds(300, 21, 68, 27);
		comboBox.addItem("No");
		if(available.getNori().equals("true")) comboBox.addItem("Yes");
		panel_1.add(comboBox);
	
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_1.setBounds(300, 59, 68, 27);
		comboBox_1.addItem("No");
		if(available.getBoiledEgg().equals("true"))comboBox_1.addItem("Yes");
		panel_1.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_2.setBounds(300, 98, 68, 27);
		comboBox_2.addItem("No");
		if(available.getBamboo().equals("true"))comboBox_2.addItem("Yes");
		panel_1.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_3.setBounds(300, 135, 68, 28);
		comboBox_3.addItem("No");
		if(available.getChashu().equals("true"))comboBox_3.addItem("Yes");
		panel_1.add(comboBox_3);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("");
		textPane.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane.setEditable(false);
		textPane.setBounds(378, 21, 67, 28);
		textPane.setText(bill.getExtraNori());
		if(textPane.getText().isEmpty() || available.getNori().equals("false"))
			textPane.setText("No");
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_1.setEditable(false);
		textPane_1.setBounds(378, 59, 67, 28);
		textPane_1.setText(bill.getExtraEgg());
		if(textPane_1.getText().isEmpty() || available.getBoiledEgg().equals("false"))
			textPane_1.setText("No");
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_2.setEditable(false);
		textPane_2.setBounds(378, 97, 67, 28);
		textPane_2.setText(bill.getBambooShoot());
		if(textPane_2.getText().isEmpty() || available.getBamboo().equals("false"))
			textPane_2.setText("No");
		panel_1.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_3.setEditable(false);
		textPane_3.setBounds(378, 135, 67, 28);
		textPane_3.setText(bill.getExtraChashu());
		if(textPane_3.getText().isEmpty() || available.getChashu().equals("false"))
			textPane_3.setText("No");
		panel_1.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setFont(new Font("MV Boli", Font.BOLD, 19));
		textPane_4.setBackground(SystemColor.control);
		textPane_4.setEditable(false);
		textPane_4.setBounds(219, 21, 67, 28);
		textPane_4.setText("\uFFE1" + price.getExNori());
		panel_1.add(textPane_4);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setFont(new Font("MV Boli", Font.BOLD, 19));
		textPane_1_1.setBackground(SystemColor.control);
		textPane_1_1.setEditable(false);
		textPane_1_1.setBounds(219, 59, 67, 28);
		textPane_1_1.setText("\uFFE1" + price.getExEgg());
		panel_1.add(textPane_1_1);
		
		JTextPane textPane_2_1 = new JTextPane();
		textPane_2_1.setFont(new Font("MV Boli", Font.BOLD, 19));
		textPane_2_1.setBackground(SystemColor.control);
		textPane_2_1.setEditable(false);
		textPane_2_1.setBounds(219, 97, 67, 28);
		textPane_2_1.setText("\uFFE1" + price.getExBamboo());
		panel_1.add(textPane_2_1);
		
		JTextPane textPane_3_1 = new JTextPane();
		textPane_3_1.setFont(new Font("MV Boli", Font.BOLD, 19));
		textPane_3_1.setBackground(SystemColor.control);
		textPane_3_1.setEditable(false);
		textPane_3_1.setBounds(219, 135, 67, 28);
		textPane_3_1.setText("\uFFE1" + price.getExChashu());
		panel_1.add(textPane_3_1);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText((String)comboBox.getSelectedItem());
			}
		});
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_1.setText((String)comboBox_1.getSelectedItem());
			}
		});
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_2.setText((String)comboBox_2.getSelectedItem());
			}
		});
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_3.setText((String)comboBox_3.getSelectedItem());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setExtraNori(textPane.getText());
				bill.setExtraEgg(textPane_1.getText());
				bill.setBambooShoot(textPane_2.getText());
				bill.setExtraChashu(textPane_3.getText());
				
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Ordering4(bill);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(44, 401, 176, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Ordering2(bill);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(328, 401, 176, 61);
		panel.add(btnNewButton);
	}
}