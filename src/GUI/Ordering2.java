package GUI;

import Entity.Available;
import Entity.Bill;
import Dao.AvailableDao;
import Control.ControlBill;

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

public class Ordering2 extends JFrame{

	private JFrame frmRamenBuffetSystem;
	Bill bill = new Bill();
	Available available = new Available();

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ordering2 window = new Ordering2();
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
	
	public Ordering2() throws IOException {
		CheckAvailable();
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}
	
	public Ordering2(Bill bill) throws IOException {
		this.bill = bill;
		CheckAvailable();
		initialize();
		frmRamenBuffetSystem.setVisible(true);
	}
	
	public void CheckAvailable() throws IOException {
		AvailableDao ad = new AvailableDao();
		this.available = ad.getAvailableMsg();
		if(this.available.getJudgeCode() == "01") {
			System.out.println("File cannot be created!");
			System.exit(0);
		}
		if(this.available.getJudgeCode() == "10") {
			System.out.println("Cannot read anything from file!");
			System.exit(0);
		}
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
				ControlBill controlBill = new ControlBill(bill);
				if(controlBill.chkBillMsg() == 0) {
					lblNewLabel.setText("");
				}
				
				
				
				frmRamenBuffetSystem.setVisible(false);
				new Ordering3();
				
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(44, 401, 176, 61);
		panel.add(btnNewButton_1);*/
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton.setBounds(328, 401, 176, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Please choose your ingredients!(Free)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 23));
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
		
		JLabel lblNewLabel_2 = new JLabel("Soup");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 21, 142, 28);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Noodles");
		lblNewLabel_2_1.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(10, 59, 142, 28);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Spring onion");
		lblNewLabel_2_2.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setBounds(10, 97, 142, 28);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nori");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2_2_1.setBounds(10, 135, 142, 28);
		panel_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Chashu");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_2_2_1_1.setBounds(10, 173, 142, 28);
		panel_1.add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Boiled egg");
		lblNewLabel_2_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_2.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_2_1_2.setBounds(10, 211, 142, 28);
		panel_1.add(lblNewLabel_2_2_1_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox.setBounds(153, 21, 142, 27);
		if(available.getSoupTonkotsu().equals("true")) comboBox.addItem("Tonkotsu");
		if(available.getSoupShoyu().equals("true"))comboBox.addItem("Shoyu");
		if(available.getSoupShio().equals("true"))comboBox.addItem("Shio");
		panel_1.add(comboBox);
	
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_1.setBounds(153, 59, 142, 27);
		if(available.getNoodleSoft().equals("true"))comboBox_1.addItem("Soft");
		if(available.getNoodleMedium().equals("true"))comboBox_1.addItem("Medium");
		if(available.getNoodleFirm().equals("true"))comboBox_1.addItem("Firm");
		panel_1.add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_2.setBounds(153, 98, 142, 27);
		if(available.getOnion().equals("true")) {
			comboBox_2.addItem("No-please");
			comboBox_2.addItem("Just-a-little");
			comboBox_2.addItem("A-lot!");
		}
		panel_1.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_3.setBounds(153, 135, 142, 28);
		if(available.getNori().equals("true")) {
			comboBox_3.addItem("Yes");
			comboBox_3.addItem("No");
		}
		panel_1.add(comboBox_3);
		
		JComboBox<String> comboBox_3_1 = new JComboBox<String>();
		comboBox_3_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_3_1.setBounds(153, 173, 142, 28);
		if(available.getChashu().equals("true")) {
			comboBox_3_1.addItem("Yes");
	    	comboBox_3_1.addItem("No");
		}
		panel_1.add(comboBox_3_1);
		
		JComboBox<String> comboBox_3_2 = new JComboBox<String>();
		comboBox_3_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_3_2.setBounds(153, 211, 142, 28);
		if(available.getBoiledEgg().equals("true")) {
			comboBox_3_2.addItem("Yes");
	    	comboBox_3_2.addItem("No");
		}
		panel_1.add(comboBox_3_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane.setEditable(false);
		textPane.setBounds(318, 21, 127, 28);
		textPane.setText(bill.getSoup());
		if((available.getSoupShio().equals("false")) && (available.getSoupTonkotsu().equals("false"))
				&& (available.getSoupShoyu().equals("false")))
			textPane.setText("Conventional");
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_1.setEditable(false);
		textPane_1.setBounds(318, 59, 127, 28);
		textPane_1.setText(bill.getNood());
		if((available.getNoodleFirm().equals("false")) && (available.getNoodleMedium().equals("false"))
				&& (available.getNoodleSoft().equals("false")))
			textPane_1.setText("Conventional");
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_2.setEditable(false);
		textPane_2.setBounds(318, 97, 127, 28);
		textPane_2.setText(bill.getOnion());
		if(available.getOnion().equals("false"))
			textPane_2.setText("No-Onion");
		panel_1.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_3.setEditable(false);
		textPane_3.setBounds(318, 135, 127, 28);
		textPane_3.setText(bill.getNori());
		if(available.getNori().equals("false"))
			textPane_3.setText("No-Nori");
		panel_1.add(textPane_3);
		
		JTextPane textPane_3_1 = new JTextPane();
		textPane_3_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_3_1.setEditable(false);
		textPane_3_1.setBounds(318, 173, 127, 28);
		textPane_3_1.setText(bill.getChashu());
		if(available.getChashu().equals("false"))
			textPane_3_1.setText("No-Chashu");
		panel_1.add(textPane_3_1);
		
		JTextPane textPane_3_2 = new JTextPane();
		textPane_3_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_3_2.setEditable(false);
		textPane_3_2.setBounds(318, 211, 127, 28);
		textPane_3_2.setText(bill.getBoiledEgg());
		if(available.getBoiledEgg().equals("false"))
			textPane_3_2.setText("No-BoiledEgg");
		panel_1.add(textPane_3_2);
		
		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Spiciness");
		lblNewLabel_2_2_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_2_1.setFont(new Font("MV Boli", Font.BOLD, 22));
		lblNewLabel_2_2_1_2_1.setBounds(10, 249, 142, 28);
		panel_1.add(lblNewLabel_2_2_1_2_1);
		
		JComboBox<String> comboBox_3_2_1 = new JComboBox<String>();
		comboBox_3_2_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		comboBox_3_2_1.setBounds(153, 249, 142, 28);
		if(available.getSpiciness().equals("true")) {
			comboBox_3_2_1.addItem("0(No)");
	    	comboBox_3_2_1.addItem("1");
	    	comboBox_3_2_1.addItem("2");
	    	comboBox_3_2_1.addItem("3");
	    	comboBox_3_2_1.addItem("4");
	    	comboBox_3_2_1.addItem("5(Max)");
		}
		panel_1.add(comboBox_3_2_1);
		
		JTextPane textPane_3_2_1 = new JTextPane();
		textPane_3_2_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		textPane_3_2_1.setEditable(false);
		textPane_3_2_1.setBounds(318, 249, 127, 28);
		textPane_3_2_1.setText(bill.getSpiciness());
		if(available.getSpiciness().equals("false"))
			textPane_3_2_1.setText("No-Spiciness");
		panel_1.add(textPane_3_2_1);
		
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
		comboBox_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_3_1.setText((String)comboBox_3_1.getSelectedItem());
			}
		});
		comboBox_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_3_2.setText((String)comboBox_3_2.getSelectedItem());
			}
		});
		comboBox_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_3_2_1.setText((String)comboBox_3_2_1.getSelectedItem());
			}
		});
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setForeground(new Color(255, 20, 147));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bill.setSoup(textPane.getText());
				bill.setNood(textPane_1.getText());
				bill.setOnion(textPane_2.getText());
				bill.setNori(textPane_3.getText());
				bill.setChashu(textPane_3_1.getText());
				bill.setBoiledEgg(textPane_3_2.getText());
				bill.setSpiciness(textPane_3_2_1.getText());
				
				ControlBill controlBill = new ControlBill(bill);
				
				if(controlBill.chkBillMsg() == 0) {
					lblNewLabel.setText("Please select all options");
				}
				else {
					frmRamenBuffetSystem.setVisible(false);
					try {
						new Ordering3(bill);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnNewButton_1.setBounds(44, 401, 176, 61);
		panel.add(btnNewButton_1);
	}
}