import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EndUser implements ActionListener 
{
	JFrame jf;
	Container c;
	JPanel p1,p2;	
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	int rank; 
	JLabel mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10, g11, g22, g33,g44, g55, g66, g77,l8,l9,username;
	ImageIcon banner;
	JTextArea ta;
	JScrollPane sp;
	String name;
	@SuppressWarnings("deprecation")
	EndUser(String name)
	{
		jf = new JFrame("End User::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("images/enduser.png"));
		JLabel l5 = new JLabel();
		l5.setIcon(banner);
		l5.setBounds(0, 0,  700,540);
		username = new JLabel(name);
		username.setBounds(100, 100, 100, 100);
		
		l1=new JLabel("User Name");
		l1.setBounds(60, 175, 100, 30);
		
		l2=new JLabel("File Name");
		l2.setBounds(60, 235, 100, 30);
		
		l3=new JLabel("Secret Key");
		l3.setBounds(60, 295, 100, 30);
		
		t1 = new JTextField();
		t1.setBounds(60, 200, 100, 30);
		t1.setText(name);
		t2 = new JTextField();
		t2.setBounds(60, 260, 100, 30);
		
		t3 = new JTextField();
		t3.setBounds(60, 320, 100, 30);
		
		b1 = new JButton("Req-SK");
		b1.setBounds(60, 380, 100, 30);
		b1.addActionListener(this);
		
		b2 = new JButton("Download");
		b2.setBounds(60, 440, 100, 30);
		b2.addActionListener(this);
		
		ta = new JTextArea();
		ta.setColumns(100);
		ta.setRows(100);
		
		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(230, 185, 315, 250);
		
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(sp);
		c.add(b2);
		c.add(b1);
		c.add(l5);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		
		
		c.add(username);
		jf.setSize(700,575);
		jf.show();
		
	}


	public void actionPerformed(ActionEvent e1)
	{
		Object o = e1.getSource();
		
		if(o==b1)
		{
			try {
			String file =t2.getText();
			if(file.equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null, "Enter The File Name");
			}
			else
			{
					
					Socket g = new Socket("localhost",3434);
					DataOutputStream d = new DataOutputStream(g.getOutputStream());
					
					d.writeUTF(file);
					
					DataInputStream dis = new DataInputStream(g.getInputStream());
					
					String msg = dis.readUTF();
					String sk = dis.readUTF();
					
					if(msg.equalsIgnoreCase("key"))
					{
						t3.setText(sk);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "File Doesn't Exist");
					}
					
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(o == b2)
		{
						
			 String user = t1.getText();
			 String file = t2.getText();
			 String sk = t3.getText();
			 
			 try
			 {
				 Socket cn2 = new Socket("localhost",9988);
				  DataOutputStream oos2 = new DataOutputStream(cn2.getOutputStream());
				  
				  oos2.writeUTF(user);
				  oos2.writeUTF(file);
				  oos2.writeUTF(sk);
				  
				  DataInputStream din = new DataInputStream(cn2.getInputStream());

				  
				  String content =  din.readUTF();
				  String msg =  din.readUTF();
				
						if(msg.equalsIgnoreCase("success"))
						{
							ta.setText(content);
							
							String str = ta.getText();
							  FileOutputStream fos = new FileOutputStream("User/"+ file);
							  fos.write(str.getBytes());
							  System.out.println("Received Successfully");
							  
							  JOptionPane.showMessageDialog(null, "File Downloaded Successfully");
						}
						if(msg.equalsIgnoreCase("no"))
						{
							JOptionPane.showMessageDialog(null, "Blocked");
						}
						
						  
				  
			 }catch(Exception e2)
			 {
				 e2.printStackTrace();
			 }
		}
			
			
		}
		
		
	public static void main(String[] args) {
		
	}
}