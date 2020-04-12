package GUI;

import Entity.Price;
import Dao.PriceDao;
import Control.ControlPrice;

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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ModifyMenu1 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JTextField textField_2;

	Price price = new Price();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyMenu1 window = new ModifyMenu1();
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
	public ModifyMenu1() throws IOException {
		PriceDao priceDao = new PriceDao();
		this.price = priceDao.getPrice();
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
		
		JLabel lblNewLabel = new JLabel("Please write down the price you want to modify!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 90, 528, 66);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(67, 10, 405, 74);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1_1 = new JButton("Return");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new ModifyBegin();
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(332, 386, 176, 61);
		panel.add(btnNewButton_1_1);
		
		/*JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new ModifyMenu1();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);*/
		
		JLabel lblNewLabel_2 = new JLabel("Name: Roman");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2.setBounds(38, 180, 285, 38);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		/*textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		textField.setFont(new Font("MV Boli", Font.BOLD, 22));
		textField.setBounds(147, 297, 176, 38);
		textField.setText(String.valueOf(price.getRamen()));
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(332, 297, 176, 38);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Before");
		lblNewLabel_2_3.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_3.setBounds(166, 240, 93, 38);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_5 = new JLabel("After");
		lblNewLabel_2_5.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_5.setBounds(368, 240, 93, 38);
		panel.add(lblNewLabel_2_5);
		
		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtpnPrice.setText("Price(\uFFE1):");
		txtpnPrice.setEditable(false);
		txtpnPrice.setBackground(SystemColor.control);
		txtpnPrice.setBounds(38, 297, 132, 38);
		panel.add(txtpnPrice);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				PriceDao priceDao = new PriceDao();
				if(!textField_2.getText().isEmpty())
					price.setRamen(Double.parseDouble(textField_2.getText()));
				try {
					ControlPrice controlPrice = new ControlPrice();
					controlPrice.chgPriceData(price);
					priceDao.setPrice(price);
					new ModifyMenu1();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);
	}
}