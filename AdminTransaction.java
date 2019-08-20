import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import javax.swing.DefaultComboBoxModel;

public class AdminTransaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	/**
	 * @wbp.nonvisual location=-6,534
	 */
	private final JComboBox comboBox = new JComboBox();
	private Connection con;
	private JComboBox cb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTransaction frame = new AdminTransaction();
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
	public AdminTransaction() {
		
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
    	 String sql = "Select * from TransactionDetails";
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
		setBounds(100, 100, 711, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransactiondetails = new JLabel("TransactionDetails");
		lblTransactiondetails.setBounds(145, 13, 123, 27);
		contentPane.add(lblTransactiondetails);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(24, 51, 56, 16);
		contentPane.add(lblAmount);
		
		JLabel lblCustomerid = new JLabel("Customer_id");
		lblCustomerid.setBounds(24, 96, 114, 16);
		contentPane.add(lblCustomerid);
		
		JLabel lblBeneficiary_id = new JLabel("Beneficiary_id");
		lblBeneficiary_id.setBounds(24, 141, 114, 16);
		contentPane.add(lblBeneficiary_id);
		
		textField = new JTextField();
		textField.setBounds(170, 48, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 93, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 138, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				try{
					String Account_type =  comboBox.getSelectedItem().toString();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					PreparedStatement ps=con.prepareStatement("insert into TransactionDetails(Amount,Customer_id,Beneficiary_id,Account_type) values(?,?,?,?)");
					System.out.println("sdfdfgf");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					System.out.println("sdfdfgf");
					ps.setString(4,Account_type);
					System.out.println("sdfdfgf"+Account_type);
					
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
			
		btnInsert.setBounds(12, 268, 97, 25);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String Account_type =  comboBox.getSelectedItem().toString();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					
					PreparedStatement ps=con.prepareStatement("delete from TransactionDetails where Customer_id=?");
							
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
		btnDelete.setBounds(241, 268, 90, 25);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			private PreparedStatement stmt;

			public void actionPerformed(ActionEvent e) {
				try{
					String comboBox_1 =  comboBox.getSelectedItem().toString();
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
					PreparedStatement ps=con.prepareStatement("update TransactionDetails set amount=?,Beneficiary_id=?,Account_type=? where Customer_id=?");
					ps.setString(1,textField.getText());
					
					ps.setString(2,textField_2.getText());
					
					ps.setString(3,textField_1.getText());
					
					stmt.setString(4,comboBox_1);
					
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"updated successfully");
						//dispose();
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
		btnUpdate.setBounds(121, 268, 97, 25);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu ad=new Menu();
				ad.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(121, 339, 97, 25);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(343, 13, 350, 336);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 0, 326, 323);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
	    	    
			}
		});
		table.setModel(new DefaultTableModel(data,columnNames));
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblAccounttype = new JLabel("Account_type");
		lblAccounttype.setBounds(24, 186, 85, 16);
		contentPane.add(lblAccounttype);
		
		JComboBox combobox = new JComboBox();
		combobox.setModel(new DefaultComboBoxModel(new String[] {"FixedAccount", "CurrentAccount", "SavingsAccount"}));
		combobox.setBounds(170, 183, 116, 22);
		contentPane.add(combobox);
		try {
        	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	//System.out.println("driver established");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ammu");
	//System.out.println("pwd checked");
        
	Statement st = con.createStatement();
        	String c = "Select * from AdminTransaction";
        	ResultSet res = st.executeQuery(c);
	
	//while(res.next())
	//{
	//cb.addItem(res.getString("name"));
	
	//}
	
}
catch (Exception d) {
}
}
	}
	

