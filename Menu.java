import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonAccount = new JButton("Account");
		buttonAccount.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent arg0) {
				CustomerDetails.main(new String[]{});
				 frame.dispose();
				
			}
		});
		buttonAccount.setBounds(176, 33, 135, 25);
		contentPane.add(buttonAccount);
		
		JButton btnAccounttype = new JButton("Account_type");
		btnAccounttype.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent arg0) {
				CustomerDetails.main(new String[]{});
				 
			}
		});
		btnAccounttype.setBounds(176, 99, 135, 25);
		contentPane.add(btnAccounttype);
		
		JButton btnTransactionDetails = new JButton("TransactionDetails");
		btnTransactionDetails.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent e) {
			AdminTransaction.main(new String[]{});
				 frame.dispose();	
			}
		});
		btnTransactionDetails.setBounds(176, 178, 135, 25);
		contentPane.add(btnTransactionDetails);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin.main(new String[]{});
				dispose();	
			}
		});
		btnBack.setBounds(196, 250, 101, 25);
		contentPane.add(btnBack);
	}
}
