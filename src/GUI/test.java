package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

public class test extends JFrame {

	private JFrame frmRamenBuffetSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		frmRamenBuffetSystem = new JFrame();
		frmRamenBuffetSystem.setBackground(UIManager.getColor("Button.background"));
		frmRamenBuffetSystem.setTitle("Ramen Buffet System");
		frmRamenBuffetSystem.setBounds(100, 100, 582, 529);
		frmRamenBuffetSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRamenBuffetSystem.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setToolTipText("123");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Statistic Page", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistic Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(126, 137, 299, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Toroto Ramen");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(69, 39, 405, 74);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Hottest Dish");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(120, 185, 120, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblFeature = new JLabel("Favorite Spiciness");
		lblFeature.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblFeature.setBounds(120, 225, 157, 27);
		panel.add(lblFeature);
		
		JLabel lblPayment = new JLabel("Total Turnover");
		lblPayment.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblPayment.setBounds(120, 265, 120, 27);
		panel.add(lblPayment);
		
		JLabel lblToroto = new JLabel("Toroto");
		lblToroto.setForeground(Color.BLUE);
		lblToroto.setFont(new Font("Arial", Font.ITALIC, 15));
		lblToroto.setBounds(318, 189, 89, 27);
		panel.add(lblToroto);
		
		JLabel lblSpeciesegg = new JLabel("Very Spices");
		lblSpeciesegg.setForeground(Color.BLUE);
		lblSpeciesegg.setFont(new Font("Arial", Font.ITALIC, 15));
		lblSpeciesegg.setBounds(318, 226, 89, 27);
		panel.add(lblSpeciesegg);
		
		JLabel label = new JLabel("$1000");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(318, 266, 89, 27);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(79, 126, 395, 259);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnNewButton.setBounds(150, 398, 257, 47);
		panel.add(btnNewButton);
		
	}

}
