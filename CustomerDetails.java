import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CustomerDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Vector<Object> columnNames ;
	Vector<Object> data;
	private JTable table;
	private JTextField textField_5;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails frame = new CustomerDetails();
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
	public CustomerDetails()
	
	{
		Vector<Object> columnNames = new Vector<Object>();
	    Vector<Object> data = new Vector<Object>();
	    try{
	    	//Utility u = new Utility();
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system","ammu"); 
			//int i=stmt.executeUpdate(); 
    		//Connection con= u.getconnection();
    	
    	//PreparedStatement stmt=con.prepareStatement("select * from staff");
    	 String sql = "Select * from CustomerDetails";
         Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery( sql );
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        for (int i = 1; i <= columns; i++)
        {
            columnNames.addElement( md.getColumnName(i) );
        }
        while (rs.next())
        {
            Vector<Object> row = new Vector<Object>(columns);
 
            for (int i = 1; i <= columns; i++)
            {
                row.addElement( rs.getObject(i) );
            }
 
            data.addElement( row );
        }
        rs.close();
        stmt.close();
        con.close();
    	}
		
		
		catch(Exception e1){ System.out.println(e1);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(3, 379, 97, 25);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					PreparedStatement ps=con.prepareStatement("insert into CustomerDetails(Customer_Name,Customer_id,Password,Ph_no,Email_id,Address,Account_type) values(?,?,?,?,?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,passwordField.getText());
					ps.setString(4,textField_2.getText());
					ps.setString(5,textField_3.getText());
					ps.setString(6,textField_4.getText());
					ps.setString(7,textField_5.getText());
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"inserted successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"inserted  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				
				}
			});
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(12, 439, 97, 25);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					PreparedStatement ps=con.prepareStatement("update CustomerDetails set Customer_Name=?,Password=?,Ph_no=?,Email_id=?,Address=?,Account_type=? where Customer_id=?");
					ps.setString(1,textField.getText());
					
					ps.setString(2,passwordField.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
					ps.setString(6,textField_5.getText());
					ps.setString(7,textField_1.getText());
					
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"updated successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"updated not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				

				
			}
		});
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(168, 379, 97, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					
					PreparedStatement ps=con.prepareStatement("delete from CustomerDetails where Customer_id=?");
							
					ps.setString(1,textField_1.getText());
					//ps.setString(3,textField_2.getText());
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"deleted successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"deleted not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(168, 439, 97, 25);
		btnBack.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent e) {
				Menu ad=new Menu();
				ad.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		JLabel lblCustomerdetails = new JLabel("CustomerDetails");
		lblCustomerdetails.setBounds(168, 13, 93, 25);
		contentPane.add(lblCustomerdetails);
		
		JPanel panel = new JPanel();
		panel.setBounds(3, 35, 399, 325);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAccounttype = new JLabel("Account_type");
		lblAccounttype.setBounds(33, 285, 76, 16);
		panel.add(lblAccounttype);
		
		JLabel lblCustomername = new JLabel("Customer_Name");
		lblCustomername.setBounds(33, 13, 106, 16);
		panel.add(lblCustomername);
		
		JLabel lblCustomer_id = new JLabel("Customer_id");
		lblCustomer_id.setBounds(33, 53, 103, 16);
		panel.add(lblCustomer_id);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 95, 56, 16);
		panel.add(lblPassword);
		
		JLabel lblPhno = new JLabel("Ph_no");
		lblPhno.setBounds(33, 140, 56, 16);
		panel.add(lblPhno);
		
		JLabel lblEmailid = new JLabel("Email_id");
		lblEmailid.setBounds(33, 186, 56, 16);
		panel.add(lblEmailid);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(33, 238, 56, 16);
		panel.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(271, 10, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 50, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(271, 92, 116, 22);
		panel.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setBounds(271, 137, 116, 22);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(271, 183, 116, 22);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(271, 235, 116, 22);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(271, 282, 116, 22);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(3, 364, 282, 100);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(449, 67, 315, 278);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 274, 224);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
				TableModel roomObj_Model = table.getModel();
				
				textField.setText(roomObj_Model.getValueAt(i,0).toString());
	    	    textField_1.setText(roomObj_Model.getValueAt(i,1).toString());
	    	    textField_2.setText(roomObj_Model.getValueAt(i,2).toString());
	    	    textField_3.setText(roomObj_Model.getValueAt(i,3).toString());
	    	    textField_4.setText(roomObj_Model.getValueAt(i,4).toString());
	    	
	    	    
				

									
				
			}
		});
		table.setModel(new DefaultTableModel(data,columnNames));
		
		
		scrollPane.setViewportView(table);
	}
}
