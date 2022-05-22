import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class term extends JFrame implements ActionListener //ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel name;
	JTextField name1;
    JLabel lgender;
    JRadioButton r1;
    JRadioButton r2;
    ButtonGroup gender;
    JLabel te;
    JTextField tac;
    JButton submit;
    public term()
    {
    	name=new JLabel("enter your email");
    	name1=new JTextField(20);
        lgender = new JLabel("TERM AND CONDITION: ");
        r1 = new JRadioButton("AGREE");
        r2 = new JRadioButton("NOT AGREE");
        gender = new ButtonGroup();
        gender.add(r1);
        gender.add(r2);
        te=new JLabel("FEEDBACK:");
        tac=new JTextField(20);
        submit=new JButton("submit");
        add(name);
        add(name1);
        add(lgender);
        add(r1);
        add(r2);
        add(te);
        add(tac);
        add(submit);
        submit.addActionListener(this);
        setSize(350,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new term();
    }
    public void actionPerformed(ActionEvent fg)
    {
    	 try{ 

    	    	DatabaseConnection ob=new DatabaseConnection();
    		  Connection c = ob.con;
    		
    		  Statement st=(Statement) c.createStatement();
		   
		   ResultSet rs=st.executeQuery("select * from transaction");  
		    
		   while(rs.next())
		   { 
			   if(name1.getText().equals(rs.getString(5)))
			   {
			   if(r2.isSelected())
               {
                   JOptionPane.showMessageDialog(this,"you cannot transfer amount if you click NOT AGREE button");
               }
               
               if(r1.isSelected())
               {
                   JOptionPane.showMessageDialog(this,"congrulation! your amount is successfully transfer in "+rs.getString(1));
               }
			   }
		   }
		  
		}  
		catch(SQLException ee){System.out.println(ee.getMessage());
		}
               


      
    }
}
