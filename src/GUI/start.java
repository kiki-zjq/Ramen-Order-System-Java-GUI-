package GUI;

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

public class start extends JFrame{

	private JFrame frmRamenBuffetSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start window = new start();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public start() {
		initialize();
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
		
		JButton btnNewButton_1 = new JButton("Order a meal");
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
		btnNewButton_1.setFont(new Font("Segoe Print", Font.BOLD, 21));
		btnNewButton_1.setBounds(186, 234, 176, 61);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				new Manage();
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 21));
		btnNewButton.setBounds(186, 329, 176, 61);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("What do you want to do?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 26));
		lblNewLabel.setBounds(88, 163, 361, 61);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Toroto Ramen");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(69, 39, 405, 74);
		panel.add(lblNewLabel_1);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Toroto Ramen!");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setForeground(Color.RED);
		lblWelcomeToThe.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblWelcomeToThe.setBounds(69, 110, 405, 61);
		panel.add(lblWelcomeToThe);
	}
}