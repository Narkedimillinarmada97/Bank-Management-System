import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

//import com.toedter.calendar.JMonthChooser;
//import com.toedter.calendar.JYearChooser;
//import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;



public class Admin_Transaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	Vector<Object> columnNames ;
	Vector<Object> data;
	private JTable table;
	//static Session session;
	JScrollPane scrollPane;
	private Statement stmt;
	private Connection con;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//final String username = "thahaseen.24@gmail.com"; // enter your mail id
		//final String password = "srT@0143";// enter ur password

		//Properties props = new Properties();
		//props.put("mail.smtp.auth", "true");
	//	props.put("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.host", "smtp.gmail.com");
	//	props.put("mail.smtp.port", "587");

		// session = Session.getInstance(props,
		  //new javax.mail.Authenticator() {
			//protected PasswordAuthentication getPasswordAuthentication() {
				//return new PasswordAuthentication(username, password);
			//}
		  //});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Transaction frame = new Admin_Transaction();
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
	public Admin_Transaction() {
		table = new JTable();
		 scrollPane = new JScrollPane();
		 createTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Calendar c1 = Calendar.getInstance();   // this takes current date
	   // c1.set(Calendar.DAY_OF_MONTH, 1);
	   // c1.set(Calendar.DAY_OF_MONTH, c1.getActualMaximum(Calendar.DAY_OF_MONTH));
	   // System.out.println("ssssss: "+c1.getTime()); 
	   // Date lastDayofMonth = c1.getTime();
	   // Calendar c = Calendar.getInstance();   // this takes current date
	   // c.set(Calendar.DAY_OF_MONTH, 1);
	   // System.out.println("ssssss: "+c.getTime()); 
	   // Date startdayofMonth = c.getTime();
	    
	    
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 128, 128)));
		panel.setBounds(52, 11, 857, 512);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_1.setBounds(21, 11, 826, 64);
		panel.add(panel_1);
		
		JLabel lblTransactionDetails = new JLabel("TransactionDetails");
		lblTransactionDetails.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel_1.add(lblTransactionDetails);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_2.setBounds(21, 98, 384, 292);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAmount.setBounds(10, 28, 185, 25);
		panel_2.add(lblAmount);
		
		JLabel lblFeeStatus = new JLabel("Transaction_Status");
		lblFeeStatus.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFeeStatus.setBounds(10, 208, 185, 25);
		panel_2.add(lblFeeStatus);
		
		JLabel lblCustomer_id = new JLabel("Customer_id");
		lblCustomer_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomer_id.setBounds(10, 125, 131, 25);
		panel_2.add(lblCustomer_id);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(205, 28, 156, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(205, 125, 156, 25);
		panel_2.add(textField_2);
		
		//JLabel lblMonthyear = new JLabel("Month-year");
		//lblMonthyear.setFont(new Font("Tahoma", Font.BOLD, 20));
		//lblMonthyear.setBounds(10, 74, 185, 25);
		//panel_2.add(lblMonthyear);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setDateFormatString("MMM, yyyy");
		//dateChooser.setBounds(205, 74, 156, 25);
		//panel_2.add(dateChooser);
		//dateChooser.setMinSelectableDate(startdayofMonth);
		 //dateChooser.setMaxSelectableDate(lastDayofMonth);
		//dateChooser.setDateFormatString("YYYY-MM-DD");
		//panel_2.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Incomplete", "Complete"}));
		comboBox.setBounds(205, 214, 156, 25);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_3.setBounds(415, 98, 432, 289);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		scrollPane.setBounds(27, 21, 395, 241);
		panel_3.add(scrollPane);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
				TableModel roomObj_Model = table.getModel();
				java.util.Date date_one = null;
				java.sql.Date date = null;
				SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
				String dateValue = "25-"+model.getValueAt(i,3).toString();
				
				System.out.println("Date value is: "+dateValue);
				try{
					//date = 
					date_one =inFormat.parse(dateValue);
					 date = new java.sql.Date( date_one.getTime() );
					 System.out.println("Date value is FInalllllll: "+date);
				}
				catch(Exception e123)
				{
					
				}
				
				textField.setText(roomObj_Model.getValueAt(i,0).toString());
				//dateChooser.setDate(date);
				comboBox.setSelectedItem(roomObj_Model.getValueAt(i,1).toString());
	    	    textField_2.setText(roomObj_Model.getValueAt(i,2).toString());
			}
		});
		table.setModel(new DefaultTableModel(data,columnNames));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 128)));
		panel_4.setBounds(21, 398, 826, 89);
		panel.add(panel_4);
		panel_4.setLayout(null);
		System.out.println("aaaa");
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					// SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
					 //String oDate = dateFormat.format(dateChooser.getDate());
					 //System.out.println("&&&&&&oDate: "+oDate);
					 String feeStatus =  comboBox.getSelectedItem().toString();
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"system","ammu"); 
				
					
				System.out.println("aaajjhhga");
				PreparedStatement stmt=con.prepareStatement("insert into TransactionDetails(fee,fee_status,Resident_id,month_year)values(?,?,?,?)");
				//stmt.setInt(1,); 
				
				stmt.setString(1,textField.getText());
				//stmt.setString(4,oDate);
				stmt.setString(3,textField_2.getText());
				//stmt.setString(4,textField_3.getText());
				stmt.setString(2,feeStatus);
				System.out.println("*Before **SRT****i: "+stmt);
				int i=stmt.executeUpdate();  

				System.out.println("***SRT****i: "+i);
				if(i>0) {
					createTable();
					JOptionPane.showMessageDialog(null,"Inserted Sucessfully");
					/*textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_4.setText("");
					*/
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Inserted not Sucessfully");
				}					  
				con.close();  
				}
			
				
				
			catch(Exception e1){ System.out.println(e1);} 
		

		}
	});


			
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(30, 22, 135, 38);
		panel_4.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system","ammu"); 
					 String feeStatus =  comboBox.getSelectedItem().toString();
					// SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
					// String oDate = dateFormat.format(dateChooser.getDate());
					String query = "UPDATE fees1 SET fee='"+textField.getText()+"',fee_status='"+feeStatus+"' WHERE resident_id = "+textField_2.getText()+" AND month_year="+"'"+"'";

					System.out.println("SRT****Update is entered"+ query);
					//+"'AND month_year='"+oDate+'\''
					 Statement st = con.createStatement();
					// int i = st.executeUpdate(query);
					// System.out.println("SRT****Update result"+ i);
					 //if(i > 0)
					// Statement st = con.createStatement();
					 if((st.executeUpdate(query)) == 1)
			         
					
			         {
						 createTable();
						  JOptionPane.showMessageDialog(null, "Data Updated Succefully"); 
						 /* textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_4.setText("");
						*/	
							
							
			         }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "Data Not updated");
					 }
					
				}
				catch(Exception e12){ System.out.println(e12);} 

			}
		});

			
		
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBounds(196, 22, 135, 38);
		panel_4.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(table.getSelectedRow() == -1)
				{
					if(table.getRowCount() == 0)
					{
						JOptionPane.showMessageDialog(null,"No Data to delete","Room Record",JOptionPane.OK_OPTION);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Select a row to delete","Room Record",JOptionPane.OK_OPTION);
					}
				}
				else
				{
					
					int index = table.getSelectedRow();
					int x = Integer.parseInt(table.getValueAt(index, 2).toString());
					String month_YearVal = table.getValueAt(index, 3).toString();
					System.out.println("Delete Row: "+x);
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");  
						  
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
								"system","ammu"); 
						
							
						String sqldel = "delete from fees1 where resident_id  = "+x+" AND month_year = "+"'"+month_YearVal+"'";
						System.out.println("***sqldel: "+sqldel);
						 Statement stmtdel = con.createStatement();
					    	//ResultSet rsdel = stmtdel.executeQuery( sqldel );
					    	int d = stmtdel.executeUpdate(sqldel);
					    	if(d > 0)
					    	{
					    		JOptionPane.showMessageDialog(null,"Deleted Successfully");
					    		textField.setText("");
								//textField_1.setText("");
								textField_2.setText("");
								
								
					    	}
					    	else
					    	{
					    		JOptionPane.showMessageDialog(null,"Not Deleted");
					    	}
					}
					catch(Exception e2)
					{
						
					}

					
					model.removeRow(table.getSelectedRow());
					
					
				}
			}
			
		});
			
		
			
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(348, 22, 135, 38);
		panel_4.add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent e) {
				Menu ad = new Menu();
				frame.setVisible(true);
				dispose();

			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(499, 22, 135, 38);
		panel_4.add(btnBack);
	}
	private static String createQuery(int length) {
		String query = "select email_Id  from residents WHERE resident_id IN (";
		StringBuilder queryBuilder = new StringBuilder(query);
		for( int i = 0; i< length; i++){
			queryBuilder.append(" ?");
			if(i != length -1) queryBuilder.append(",");
		}
		queryBuilder.append(")");
		return queryBuilder.toString();
	}
	public void createTable()
	{
		 columnNames = new Vector<Object>();
	     data = new Vector<Object>();
	    try{
	    	//Utility u = new Utility();
    		//Connection con= u.getconnection();
    	
    	//PreparedStatement stmt=con.prepareStatement("select * from staff");
    	 String sql = "Select * from fees1";
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
		
		
		catch(Exception e1){ System.out.println(e1);}
	    table.setModel(new DefaultTableModel(data,columnNames));
		
		scrollPane.setViewportView(table);


	}
}