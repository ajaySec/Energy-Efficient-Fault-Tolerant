import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class DataOwnerLogin extends JFrame implements ActionListener {

	JPanel p;
	JLabel l;
	JTextField tf;
	JButton jb; 
	public Font f = new Font("Arieal", Font.BOLD, 13);
	public Font f1 = new Font("Arieal", Font.BOLD, 12);
	DataOwnerLogin()
	{
		setTitle("LOGIN::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		
		p=new JPanel();
		p.setLayout(null);
		
		l=new JLabel("User Name");
		l.setBounds(50, 90, 150, 50);
		l.setFont(f);
		tf=new JTextField();
		tf.setBounds(130, 100, 200, 30);
		
		jb=new JButton("LOGIN");
		jb.setFont(f1);
		jb.setBounds(130, 140, 100, 30);
		
		jb.addActionListener(this);
		
		p.add(l);
		p.add(tf);
		p.add(jb);
		
		add(p);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DataOwnerLogin d = new DataOwnerLogin();
				d.setSize(400,300);
				d.setVisible(true);
			}
		});

	}
	@Override
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource()==jb)
		{
			try
				{
				Dbcon db = new Dbcon();
				Connection connect=db.getConnection();
				Statement stmt=connect.createStatement();
				
				String name=tf.getText();
				
				ResultSet rs = stmt.executeQuery("select * from koutn where dataowner='"+name+"'");
				
				String s1 = "";
				String s2 = "";
				
				if(rs.next())
				{
					s1 = rs.getString(2);
					s2 = rs.getString(3);
					int s3=Integer.parseInt(s1)-Integer.parseInt(s2);
					
					
					new DataOwner(name,s3);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Register Urself");
					
				}
					
				
			}catch (Exception e) {
			
			
		}
	}
	}
}
