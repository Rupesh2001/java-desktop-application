import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//email
    JLabel jlemail;
    JTextField jfemail;
    
    //password
    JLabel jlpwd;
    JTextField jfpwd;
    
    //name
    JLabel jlname;
    JTextField jfname;

   //dob
    JLabel jdate;
    JTextField jdob;

    //gender
    JLabel jlgender;
    JRadioButton r1;
    JRadioButton r2;
    ButtonGroup gender;

    

    //submit
    JButton submit;
    
   
    public signup(){        
        //email
        jlemail = new JLabel("email : ");
        jfemail = new JTextField(20);
        add(jlemail);
        add(jfemail);

        //password
        jlpwd = new JLabel("password : ");
        jfpwd = new JTextField(20);
        add(jlpwd);
        add(jfpwd);

        //name
        jlname = new JLabel("name : ");
        jfname= new JTextField(20);
        add(jlname);
        add(jfname);
        
        //dob
        jdate=new JLabel("enter date year/month/day");
        jdob=new JTextField(20);
        add(jdate);
        add(jdob);
       

        //gender
        jlgender = new JLabel("gender : ");
        r1 = new JRadioButton("male");
        r1.setActionCommand("male");
        r2 = new JRadioButton("female");
        r2.setActionCommand("female");
        gender = new ButtonGroup();
        gender.add(r1);
        gender.add(r2);
        add(jlgender);
        add(r1);
        add(r2);

        

        //submit
        submit = new JButton("submit");
        add (submit);
        submit.addActionListener(this);

        setSize(250,500);
        setVisible(true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==submit)
    	{
    		 try{ 

    		    	DatabaseConnection ob=new DatabaseConnection();
    			  Connection c = ob.con;
    			
    			  Statement st=(Statement) c.createStatement();
    		
    		String em=jfemail.getText();
    		String p=jfpwd.getText();
    		String name=jfname.getText();
    		String date=jdob.getText();
    		String gen=gender.getSelection().getActionCommand();
    		ResultSet rs=st.executeQuery("select * from signup"); 
    		 while(rs.next())
			   { 
    				if(jfemail.getText().equals(rs.getString(1)))
    				{
    					JOptionPane.showMessageDialog(this,"Email already taken.","Alert",JOptionPane.WARNING_MESSAGE);     
    				}
			  
			   }
    	    	st.executeUpdate("insert into signup values('"+em+"','"+p+"','"+name+"','"+date+"','"+gen+"')");
    	    	JOptionPane.showMessageDialog(this,"successfully recorded");
   			  
    		}
    		catch(Exception ee)
    		{
    			System.out.print("message"+ee);
    		}
    		
    		 
    	}
    }

    public static void main(String []a){
        new signup();
    }
}

