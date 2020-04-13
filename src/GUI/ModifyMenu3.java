package GUI;

import Entity.Price;
import Entity.Available;
import Dao.AvailableDao;
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

public class ModifyMenu3 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	Price price = new Price();
	Available available = new Available();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyMenu3 window = new ModifyMenu3();
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
	public ModifyMenu3() throws IOException {
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frmRamenBuffetSystem = new JFrame();
		frmRamenBuffetSystem.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem.setBounds(100, 100, 582, 529);
		frmRamenBuffetSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem.getContentPane().setLayout(null);

		PriceDao priceDao = new PriceDao();
		AvailableDao availableDao = new AvailableDao();
		price = priceDao.getPrice();
		available = availableDao.getAvailableMsg();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please select the menu that needs to be modified!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 73, 528, 66);
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

			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);*/
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2.setBounds(38, 140, 93, 38);
		panel.add(lblNewLabel_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MV Boli", Font.BOLD, 26));
		comboBox.setBounds(123, 140, 241, 38);
	    comboBox.addItem("Extra_Nori");
	    comboBox.addItem("Extra_Boiled_Egg");
	    comboBox.addItem("Bamboo_Shoots");
	    comboBox.addItem("Extra_Chashu");
	    comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				lblNewLabel.setText("Please select the menu that needs to be modified!");
				try {
					textField.setText(priceDao.searchPrice(price, (String)comboBox.getSelectedItem()));
					textField_1.setText(availableDao.searchState(available, (String)comboBox.getSelectedItem()));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		panel.add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status:");
		lblNewLabel_2_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_2.setBounds(38, 319, 132, 38);
		panel.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setEditable(false);
		/*textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		textField.setFont(new Font("MV Boli", Font.BOLD, 22));
		textField.setBounds(166, 245, 93, 38);
		textField.setText(priceDao.searchPrice(price, (String)comboBox.getSelectedItem()));
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.text);
		textField_1.setEditable(false);
		/*textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		textField_1.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_1.setColumns(10);
		textField_1.setBounds(166, 319, 93, 38);
		textField_1.setText(availableDao.searchState(available, (String)comboBox.getSelectedItem()));
		panel.add(textField_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		comboBox_2.setBounds(280, 319, 108, 38);
		comboBox_2.addItem("true");
	    comboBox_2.addItem("false");
		panel.add(comboBox_2);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_2.setColumns(10);
		textField_2.setBounds(280, 245, 228, 38);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(SystemColor.text);
		textField_3.setEditable(false);
		textField_3.setFont(new Font("MV Boli", Font.BOLD, 26));
		textField_3.setColumns(10);
		textField_3.setBounds(415, 319, 93, 38);
		panel.add(textField_3);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText((String)comboBox_2.getSelectedItem());
			}
		});
		
		JLabel lblNewLabel_2_3 = new JLabel("Now");
		lblNewLabel_2_3.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_3.setBounds(166, 188, 93, 38);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Change");
		lblNewLabel_2_4.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_4.setBounds(280, 188, 93, 38);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("After");
		lblNewLabel_2_5.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel_2_5.setBounds(415, 188, 93, 38);
		panel.add(lblNewLabel_2_5);
		
		JTextPane txtpnPrice = new JTextPane();
		txtpnPrice.setFont(new Font("MV Boli", Font.BOLD, 18));
		txtpnPrice.setText("Price(\uFFE1):");
		txtpnPrice.setEditable(false);
		txtpnPrice.setBackground(SystemColor.control);
		txtpnPrice.setBounds(38, 245, 132, 38);
		panel.add(txtpnPrice);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControlPrice controlPrice = new ControlPrice();
					if(!textField_2.getText().isEmpty() || !textField_3.getText().isEmpty()) {
						if (!textField_2.getText().isEmpty() && controlPrice.chkPriceData(textField_2.getText()) != -1.00)
							price = priceDao.changePrice(price, (String) comboBox.getSelectedItem(), Double.parseDouble(textField_2.getText()));
						if (!textField_3.getText().isEmpty())
							available = availableDao.changeState(available, (String) comboBox.getSelectedItem(), textField_3.getText());
						controlPrice.chgPriceData(price);
						if (priceDao.setPrice(price) == 1)
							lblNewLabel.setText(comboBox.getSelectedItem() + " price/state has been changed!");
						if (availableDao.setAvailable(available) == 1)
							lblNewLabel.setText(comboBox.getSelectedItem() + " price/state has been changed!");
						textField.setText(priceDao.searchPrice(price, (String) comboBox.getSelectedItem()));
						textField_1.setText(availableDao.searchState(available, (String) comboBox.getSelectedItem()));
						if(controlPrice.chkPriceData(textField_2.getText()) == -1.00 && !textField_2.getText().isEmpty())
							lblNewLabel.setText("Please enter the correct price format.");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(38, 386, 176, 61);
		panel.add(btnNewButton_1);
	}
}