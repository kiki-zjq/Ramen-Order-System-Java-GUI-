package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Manage extends JFrame{

	private JFrame frmRamenBuffetSystem;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage window = new Manage();
					window.frmRamenBuffetSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public Manage() {
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
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Welcome to Ramen Hall", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 10, 548, 472);
		frmRamenBuffetSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Toroto Ramen");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Ink Free", Font.PLAIN, 60));
		lblNewLabel_2.setBounds(69, 39, 405, 74);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to the management interface!");
		// 其实这里是，如果前面加入了那个login的话，我们肯定有一个txt包含了管理员信息，如果里面存储了管理员的名字的话，
		// 这个JLabel的文字部分可以动态生成。 String Name = "xxxx"; new JLabel(Name);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel_3.setBounds(10, 124, 528, 61);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("View statistics");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new Sales();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 21));
		btnNewButton.setBounds(177, 319, 185, 61);
		panel.add(btnNewButton);
		
		JButton btnModifyTheMenu = new JButton("Check the menu");
		btnModifyTheMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRamenBuffetSystem.setVisible(false);
				try {
					new CheckMenu();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnModifyTheMenu.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnModifyTheMenu.setBounds(177, 218, 185, 61);
		panel.add(btnModifyTheMenu);
	}

}
