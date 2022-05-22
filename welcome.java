import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class welcome extends JFrame implements ActionListener
{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel w;
    JButton login;
    JButton signup;
    JButton tran;
    public welcome()
        {
            
            w=new JLabel("WELCOME TO MONEY TRANSFER");
           // w.setBounds(150,150,50,50);
            login=new JButton("LOGIN");
            login.setBackground(Color.green);
            signup=new JButton("SIGNUP");
           // login.setBounds(200,50,150,25);
           // signup.setBounds(200,100,150,25);
            signup.setBackground(Color.green);
            tran=new JButton("SEE TRANSACTION");
            tran.setBackground(Color.cyan);
            //tran.setBounds(200,150,150,25);
            login.addActionListener(this);
            signup.addActionListener(this);
            tran.addActionListener(this);
            add(w);
            add(login);
            add(signup);
            add(tran);
            setSize(300,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            setVisible(true);
            setLocationRelativeTo(null);
            setTitle("welcome to E-Payment");

        }
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==login)
            {
                new login();
            }
            if(e.getSource()==signup)
            {
                new signup();
            }
            if(e.getSource()==tran)
            {
            	new transaction();
            }
        }
        public static void main(String[] args) {
            new welcome();
        }

    
}

