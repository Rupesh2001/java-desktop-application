import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

class payment extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel cid;
    JTextField ci;
    JLabel ecn;
    JTextField cn;
    JLabel ea;
    JTextField a;
    JLabel date;
    JTextField jtd;
    JLabel el;
   JTextField email;
    JButton pay;
    JButton tran; 


    public payment()
    {
        cid=new JLabel("ENTER CUSTOMER ID");
        ci=new JTextField(20);
        ecn=new JLabel("ENTER CUSTOMER NAME");
        cn=new JTextField(20);
        date=new JLabel("ENTER TRANSACTION DATE");
        jtd=new JTextField(10);
        ea=new JLabel("ENTER AMOUNT IN RS.");
        a=new JTextField(10);
        el=new JLabel("ENTER YOUR EMAIL");
        email=new JTextField(20);
        pay=new JButton("payment");
        tran=new JButton("SEE TRANSACTION");


          add(cid); 
          add(ci); 
          add(ecn); 
          add(cn);
         add(date);
         add(jtd);
          add(ea); 
          add(a);
          add(el);
          add(email);
          add(pay); 
          add(tran);
        pay.addActionListener(this);
        tran.addActionListener(this);
        setSize(235,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==pay)
    	{
    		 try{ 

    		    	DatabaseConnection ob=new DatabaseConnection();
    			  Connection c = ob.con;
    			
    			  Statement st=(Statement) c.createStatement();
        		//ResultSet rs=st.executeQuery("select * from transaction"); 
        		String customerid=ci.getText();
        		String customername=cn.getText();
        		//String name=jfname.getText();
        		String date=jtd.getText();
        		 String amount=a.getText();
        		String e =email.getText();
        		
       		
       	    	st.executeUpdate("insert into transaction values('"+customerid+"','"+customername+"','"+date+"','"+amount+"','"+e+"')");
       	    	
       	    	new term();
      			  
       		}
    	
    		catch(Exception e)
    		{
    			System.out.println("message "+e);
    			}
    		}
    	if(ae.getSource()==tran)
    	{
    		new transaction();
    	}		
        		
    		
        	
    	
    }
   
    
    public static void main(String [] args)
    {
        new payment();
    }
}



