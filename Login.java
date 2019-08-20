import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setBounds(166, 13, 88, 28);
		contentPane.add(lblLoginPage);
		
		JButton btnAdminlogin = new JButton("AdminLogin");
		btnAdminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin ad=new AdminLogin();
				ad.setVisible(true);
				
			}
		});
		btnAdminlogin.setBounds(136, 83, 130, 25);
		contentPane.add(btnAdminlogin);
		
		JButton btnCustomerlogin = new JButton("CustomerLogin");
		btnCustomerlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogin ad=new CustomerLogin();
				ad.setVisible(true);
			}
		});
		btnCustomerlogin.setBounds(136, 154, 130, 25);
		contentPane.add(btnCustomerlogin);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 175, 175));
		panel.setBounds(0, 0, 432, 253);
		contentPane.add(panel);
	}
}
