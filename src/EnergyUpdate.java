

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EnergyUpdate extends JFrame implements ActionListener{
	
	JPanel p; 
	JLabel l1,l2,l3,l4,l5,l6,l7,l8; 
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7; 
	JButton b1;
	
	public EnergyUpdate()
	{
		p=new JPanel();
		p.setLayout(null);
		setTitle("Update Energy::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		
//		ImageIcon ii=new ImageIcon(this.getClass().getResource("Desert.jpg"));
//		l8=new JLabel();
//		l8.setIcon(ii);
//		l8.setBounds(0, 0, 500, 500);
		
		l1=new JLabel("Energy Update");
		l1.setBounds(105, 25, 230 ,50 );
		l1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
		l1.setForeground(Color.BLUE);
		
		l2=new JLabel("MOBILE NODE 1");
		l2.setBounds(70, 80, 120 ,20 );
		l2.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		l3=new JLabel("MOBILE NODE 2");
		l3.setBounds(70, 110, 120 ,20 );
		l3.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		l4=new JLabel("MOBILE NODE 3");
		l4.setBounds(70, 140, 120 ,20 );
		l4.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		l5=new JLabel("MOBILE NODE 4");
		l5.setBounds(70, 170, 120 ,20 );
		l5.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));

		l6=new JLabel("MOBILE NODE 5");
		l6.setBounds(70, 200, 120 ,20 );
		l6.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		l7=new JLabel("MOBILE NODE 6");
		l7.setBounds(70, 230, 120 ,20 );
		l7.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		l8=new JLabel("MOBILE NODE 7");
		l8.setBounds(70, 260, 120 ,20 );
		l8.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,12));
		
		tf1=new JTextField(15);
		tf1.setBounds(180, 80, 150, 20);
		
		tf2=new JTextField(15);
		tf2.setBounds(180, 110, 150, 20);
		
		tf3=new JTextField(15);
		tf3.setBounds(180, 140, 150, 20);
		
		tf4=new JTextField(15);
		tf4.setBounds(180, 170, 150, 20);
		
		tf5=new JTextField(15);
		tf5.setBounds(180, 200, 150, 20);
		
		tf6=new JTextField(15);
		tf6.setBounds(180, 230, 150, 20);
		
		tf7=new JTextField(15);
		tf7.setBounds(180, 260, 150, 20);
		
		b1=new JButton("UPDATE");
		b1.setBounds(140, 310, 100, 30);
		b1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 14));
		b1.setBackground(Color.cyan);
		
		
		b1.addActionListener(this);
		
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		
		p.add(tf1);
		p.add(tf2);
		p.add(tf3);
		p.add(tf4);
		p.add(tf5);
		p.add(tf6);
		p.add(tf7);

		p.add(b1);
		
		add(p);
		
	}

	public static void main(String[] args) {
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		String t1=tf1.getText(); 
		String t2=tf2.getText();
		String t3=tf3.getText();
		String t4=tf4.getText();
		String t5=tf5.getText();
		String t6=tf6.getText();
		String t7=tf7.getText();
		
		
		if(ae.getSource()==b1)
		{
			try {
			if(t1.equalsIgnoreCase("")  || t2.equalsIgnoreCase("") || t3.equalsIgnoreCase("") || t4.equalsIgnoreCase("") || t5.equalsIgnoreCase("") || t6.equalsIgnoreCase("") || t7.equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null, "FIELDS CANNOT BE BLANK");
				
			}
			else
			{	
		
			Dbcon db=new Dbcon();
			
			
			Connection con=db.getConnection();
			
			String n1="mn1";String n2="mn2";String n3="mn3";String n4="mn4";String n5="mn5";String n6="mn6";String n7="mn7";
			
			con.createStatement().executeUpdate("update mobilenode set distance='"+t1+"' where nodename='"+n1+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t2+"' where nodename='"+n2+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t3+"' where nodename='"+n3+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t4+"' where nodename='"+n4+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t5+"' where nodename='"+n5+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t6+"' where nodename='"+n6+"'");
			con.createStatement().executeUpdate("update mobilenode set distance='"+t7+"' where nodename='"+n7+"'");
			
				JOptionPane.showMessageDialog(null, "Energy Updated");
			
			}
			} catch (Exception e) {

			e.printStackTrace();
			
			} 
		}
	}

}
