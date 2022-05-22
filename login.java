import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
class login extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel user;
    JLabel password;
    JLabel email;
    JLabel str;
    JTextField jel;
    JTextField usertext;
    JTextField userpassword;
    JButton btn;
    
    public login(){
        user = new JLabel("NAME");
        password = new JLabel("PASSWORD");
        email=new JLabel("ENTER YOUR EMAIL");
        jel=new JTextField(10);
        str=new JLabel("PLEASE SIGNUP");
        usertext = new JTextField(10);
        userpassword = new JTextField(10);
        btn = new JButton("LOGIN ");       
        add(email);
          add(usertext);      
        add(password);
        add(userpassword);
        add(user);
       add(jel);          
        add (btn);
        btn.addActionListener(this);
        setSize(100,250);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("hello");
    }
    public void actionPerformed(ActionEvent fg)    
    {    	    	

    try{ 

    	DatabaseConnection ob=new DatabaseConnection();
	  Connection c = ob.con;
	
	  Statement st=(Statement) c.createStatement();
	  ResultSet rs=st.executeQuery("select * from signup where email='"+usertext.getText()+"' and password='"+userpassword.getText()+"' and name='"+jel.getText()+"'");
	//  while(rs.next()) 
	 // {
		//  if(usertext.getText().equals(rs.getString(1))&&userpassword.getText().equals(rs.getString(2))&&jel.getText().equals(rs.getString(3)))
		if(rs.next())
	  { 
			  new payment();
			  } 
		  else
		  {
			  JOptionPane.showMessageDialog(this,"invalid");
		  }
		//  }
	
	  } 
    catch(SQLException ee)
    {
    	System.out.println(ee.getMessage()); 
    } 
    }
    public static void main(String [] args){
        new login();
    }
}
