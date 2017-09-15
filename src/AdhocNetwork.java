import java.awt.Color;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AdhocNetwork extends JFrame implements ActionListener{
	
	Container c;
	JFrame f;
	ImageIcon i1,i2,i3,i4,i5,i6,i7,i1g,i2g,i3g,i4g,i5g,i6g,i7g,i2r,i3r,i4r,i5r,i6r,i7r;
	JLabel l1,l2,l3,l4,l5,l6,l7,less2,less3,less4,less5,less6;
	MenuBar mbr;
	Menu file;
	MenuItem item,item1;
	String n1="mn1",n2="mn2",n3="mn3",n4="mn4",n5="mn5",n6="mn6",n7="mn7";
	String dis1="",dis2="",dis3="",dis4="",dis5="",dis6="",dis7="";
	String e1="",e2="",e3="",e4="",e5="",e6="",e7="";
	String oname,filename,sk,ct;
	String sp1,sp2,sp3,sp4,sp5;
	String h1,h2,h3,h4,h5;
	String tym,node;
	String koutn = null;
	String node1;
	ResultSet rs;
	Socket con777;
	
	DataInputStream dis;
	DataOutputStream dos;
	int length;
	
	Dbcon db;
	Connection connect;
	
	AdhocNetwork()
	{
		
		
		f=new JFrame();
		
		c=f.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.ORANGE);
		
		f.setTitle("Adhoc Network ::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud ");
		
		less2=new JLabel("Less Energy");
		less2.setBounds(235, 180, 100, 100);
		less2.setForeground(Color.red);
		c.add(less2);
		
		less3=new JLabel("Less Energy");
		less3.setBounds(335, 60, 100, 100);
		less3.setForeground(Color.red);
		c.add(less3);
		
		less4=new JLabel("Less Energy");
		less4.setBounds(105, 300, 100, 100);
		less4.setForeground(Color.red);
		c.add(less4);
		
		less5=new JLabel("Less Energy");
		less5.setBounds(245, 350, 100, 100);
		less5.setForeground(Color.red);
		c.add(less5);
		
		less6=new JLabel("Less Energy");
		less6.setBounds(375, 250, 100, 100);
		less6.setForeground(Color.red);
		c.add(less6);
		
		less2.setVisible(false);
		less3.setVisible(false);
		less4.setVisible(false);
		less5.setVisible(false);
		less6.setVisible(false);
		
		mbr = new MenuBar();
		file = new Menu("Menu");
		item = new MenuItem("View Energy & Distance");
		item1 = new MenuItem("Update Energy");
		
		item.addActionListener(this);
		item1.addActionListener(this);
		
		file.add(item);
		file.add(item1);
		mbr.add(file);
		f.setMenuBar(mbr);
		
		
		
		i1 = new ImageIcon(this.getClass().getResource("images/nb1.png"));
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(70, 100, 100, 100);
		c.add(l1);
		
		i2 = new ImageIcon(this.getClass().getResource("images/nb2.png"));
		l2 = new JLabel();
		l2.setIcon(i2);
		l2.setBounds(180, 180, 100, 100);
		c.add(l2);
		
		i3 = new ImageIcon(this.getClass().getResource("images/nb3.png"));
		l3 = new JLabel();
		l3.setIcon(i3);
		l3.setBounds(280, 60, 100, 100);
		c.add(l3);
		
		i4 = new ImageIcon(this.getClass().getResource("images/nb4.png"));
		l4 = new JLabel();
		l4.setIcon(i4);
		l4.setBounds(50, 300, 100, 100);
		c.add(l4);
		
		i5 = new ImageIcon(this.getClass().getResource("images/nb5.png"));
		l5 = new JLabel();
		l5.setIcon(i5);
		l5.setBounds(190, 350, 100, 100);
		c.add(l5);
		
		i6 = new ImageIcon(this.getClass().getResource("images/nb6.png"));
		l6 = new JLabel();
		l6.setIcon(i6);
		l6.setBounds(320, 250, 100, 100);
		c.add(l6);
		
		i7 = new ImageIcon(this.getClass().getResource("images/nb7.png"));
		l7 = new JLabel();
		l7.setIcon(i7);
		l7.setBounds(340, 410, 100, 100);
		c.add(l7);
		
		
		f.setSize(500, 600);
		f.show();
		
		int [] ports = new int[]{ 12121};

  		for (int i = 0; i < 1; i++)
  		{
  			Thread t = new Thread(new PortListener(ports[i]));
  			t.setName("Listener-" + ports[i]);
  			t.start();

  		}
}
	void up() throws SQLException
	{
		
		db=new Dbcon();
		connect=db.getConnection();
		Random r = new Random();
		int rand1 = r.nextInt(40000);
		int rand2 = r.nextInt(40000);
		int rand3 = r.nextInt(40000);
		int rand4 = r.nextInt(40000);
		int rand5 = r.nextInt(40000);
		int rand6 = r.nextInt(40000);
		int rand7 = r.nextInt(40000);
		
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand1+"' where nodename='"+n1+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand2+"' where nodename='"+n2+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand3+"' where nodename='"+n3+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand4+"' where nodename='"+n4+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand5+"' where nodename='"+n5+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand6+"' where nodename='"+n6+"'");
		connect.createStatement().executeUpdate("update mobilenode set energy='"+rand7+"' where nodename='"+n7+"'");
	}
	class PortListener implements Runnable
	{


		BufferedOutputStream bos = null;
		ServerSocket ss1, ss2;
		Socket s1, s2;
		ServerSocket server, server1,server2,server3;
		Socket connection, so;
		BufferedReader br = null;
		int port;

		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{
			if(this.port==12121)
			{
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
				
				try
				{
					ServerSocket server909 = new ServerSocket(12121);
					Socket con777;
					while (true) 
						{
						con777 = server909.accept();
						System.out.println("connect with cs");
						
						ResultSet r1=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n1+"'");
						if(r1.next()==true){dis1=r1.getString("distance"); e1=r1.getString("energy"); }
						
						ResultSet r2=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n2+"'");
						if(r2.next()==true){dis2=r2.getString("distance"); e2=r2.getString("energy"); }
						
						ResultSet r3=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n3+"'");
						if(r3.next()==true){dis3=r3.getString("distance"); e3=r3.getString("energy"); }
						
						ResultSet r4=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n4+"'");
						if(r4.next()==true){dis4=r4.getString("distance"); e4=r4.getString("energy"); }
						
						ResultSet r5=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n5+"'");
						if(r5.next()==true){dis5=r5.getString("distance"); e5=r5.getString("energy"); }
						
						ResultSet r6=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n6+"'");
						if(r6.next()==true){dis6=r6.getString("distance"); e6=r6.getString("energy"); }
						
						ResultSet r7=connect.createStatement().executeQuery("select * from mobilenode where nodename='"+n7+"'");
						if(r7.next()==true){dis7=r7.getString("distance"); e7=r7.getString("energy"); }
						
	
						
						
						dis = new DataInputStream(con777.getInputStream());
						dos = new DataOutputStream(con777.getOutputStream());
						
						
						oname	= dis.readUTF();
						filename	= dis.readUTF();
						sk		= dis.readUTF();
						ct=dis.readUTF();
					
						sp1 = dis.readUTF();
						sp2 = dis.readUTF();
						sp3 = dis.readUTF();
						sp4 = dis.readUTF();
						sp5 = dis.readUTF();
	
						
						h1 = dis.readUTF();
						h2 = dis.readUTF();
						h3 = dis.readUTF();
						h4 = dis.readUTF();
						h5 = dis.readUTF();
						tym = dis.readUTF();
	
						length=ct.length();
	//					System.out.println("File Length"+length);
						
					///////Execution/////////	
						////////////11111111111111111111111111111111111111111111
						
						Thread.sleep(2000);
						i1g = new ImageIcon(this.getClass().getResource("images/ng1.png"));
						l1.setIcon(i1g);
						
						
						///////2222222222222222222222222222222222222222222222222
						
						if(Integer.parseInt(dis2)<Integer.parseInt(dis3))
						{
							if(Integer.parseInt(e2)>length)
							{
								Thread.sleep(2000);
								i2g = new ImageIcon(this.getClass().getResource("images/ng2.png"));
								l2.setIcon(i2g);
								
								int ene = (Integer.parseInt(e2)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene+"' where nodename='"+n2+"'");
							
								if(Integer.parseInt(dis3)<Integer.parseInt(dis4))
								{
									if(Integer.parseInt(e3)>length)
									{
										Thread.sleep(2000);
										i3g = new ImageIcon(this.getClass().getResource("images/ng3.png"));
										l3.setIcon(i3g);
										
										int ene1 = (Integer.parseInt(e3)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1+"' where nodename='"+n3+"'");
										
										if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
										{
											if(Integer.parseInt(e4)>length)
											{
												Thread.sleep(2000);
												i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
												l4.setIcon(i4g);
											
												int ene11 =  (Integer.parseInt(e4)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
											
											
												if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
												{
													if(Integer.parseInt(e5)>length)
													{
														Thread.sleep(2000);
														i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
														l5.setIcon(i5g);
														
														int ene111 = (Integer.parseInt(e5)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
						
													
														if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
														{
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
														else
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
													}
													else
													{
														Thread.sleep(2000);
														i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
														l5.setIcon(i5r);
														
														less5.setVisible(true);
														Thread.sleep(150);
														less5.setVisible(false);
														Thread.sleep(150);
														less5.setVisible(true);
														Thread.sleep(150);
														less5.setVisible(false);
														Thread.sleep(150);
														less5.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else
														{
															if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
															{
																if(Integer.parseInt(e6)>length)
																{
																	Thread.sleep(2000);
																	i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																	l6.setIcon(i6g);
																	
																	int ene1111 =  (Integer.parseInt(e6)-length);
																	connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
																else
																{
																	Thread.sleep(2000);
																	i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																	l6.setIcon(i6r);
																	
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	
																	rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																	if(rs.next())
																	{
																		koutn=rs.getString(3);
																	}
																	connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																	
																	con777 =new Socket("localhost",6666);
																	dos = new DataOutputStream(con777.getOutputStream());
																	dos.writeUTF("node5");
																	dos.writeUTF(oname);
																	
																	
																	dis = new DataInputStream(con777.getInputStream());
																	
																	node1 = dis.readUTF();
																	
																	
																	if(node1.equalsIgnoreCase("yes"))
																	{
																		complete();
																	}
																	else if(node1.equalsIgnoreCase("no"))
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);
																		Thread.sleep(10000);
																		
																		send();
																	}
																
																}
															}
															else
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
														}
													}
												}
												else
												{
													
														if(Integer.parseInt(e6)>length)
														{
															Thread.sleep(2000);
															i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
															l6.setIcon(i6g);
															
															int ene1111 =  (Integer.parseInt(e6)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
														
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
														else
														{
															Thread.sleep(2000);
															i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
															l6.setIcon(i6r);
															
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else if(node1.equalsIgnoreCase("no"))
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);
																Thread.sleep(10000);
																
																send();
															}
														
														}
													}
											}
											else
											{
												Thread.sleep(2000);
												i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
												l4.setIcon(i4r);
												
												less4.setVisible(true);
												Thread.sleep(150);
												less4.setVisible(false);
												Thread.sleep(150);
												less4.setVisible(true);
												Thread.sleep(150);
												less4.setVisible(false);
												Thread.sleep(150);
												less4.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else
												{
													if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
													{
														if(Integer.parseInt(e5)>length)
														{
															Thread.sleep(2000);
															i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
															l5.setIcon(i5g);
															
															int ene111 = (Integer.parseInt(e5)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
							
														
															if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
															{
																if(Integer.parseInt(e6)>length)
																{
																	Thread.sleep(2000);
																	i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																	l6.setIcon(i6g);
																	
																	int ene1111 =  (Integer.parseInt(e6)-length);
																	connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
																else
																{
																	Thread.sleep(2000);
																	i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																	l6.setIcon(i6r);
																	
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	
																	rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																	if(rs.next())
																	{
																		koutn=rs.getString(3);
																	}
																	connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																	
																	con777 =new Socket("localhost",6666);
																	dos = new DataOutputStream(con777.getOutputStream());
																	dos.writeUTF("node5");
																	dos.writeUTF(oname);
																	
																	
																	dis = new DataInputStream(con777.getInputStream());
																	
																	node1 = dis.readUTF();
																	
																	
																	if(node1.equalsIgnoreCase("yes"))
																	{
																		complete();
																	}
																	else if(node1.equalsIgnoreCase("no"))
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);
																		Thread.sleep(10000);
																		
																		send();
																	}
																
																}
															}
															else
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
														}
														else
														{
															Thread.sleep(2000);
															i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
															l5.setIcon(i5r);
															
															less5.setVisible(true);
															Thread.sleep(150);
															less5.setVisible(false);
															Thread.sleep(150);
															less5.setVisible(true);
															Thread.sleep(150);
															less5.setVisible(false);
															Thread.sleep(150);
															less5.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else
															{
																if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
																{
																	if(Integer.parseInt(e6)>length)
																	{
																		Thread.sleep(2000);
																		i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																		l6.setIcon(i6g);
																		
																		int ene1111 =  (Integer.parseInt(e6)-length);
																		connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																	
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);

																		Thread.sleep(2000);
																		l1.setIcon(i1);
																		l2.setIcon(i2);
																		l3.setIcon(i3);
																		l4.setIcon(i4);
																		l5.setIcon(i5);
																		l6.setIcon(i6);
																		l7.setIcon(i7);
																		
																		socketsend();
																	}
																	else
																	{
																		Thread.sleep(2000);
																		i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																		l6.setIcon(i6r);
																		
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		
																		rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																		if(rs.next())
																		{
																			koutn=rs.getString(3);
																		}
																		connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																		
																		con777 =new Socket("localhost",6666);
																		dos = new DataOutputStream(con777.getOutputStream());
																		dos.writeUTF("node5");
																		dos.writeUTF(oname);
																		
																		
																		dis = new DataInputStream(con777.getInputStream());
																		
																		node1 = dis.readUTF();
																		
																		
																		if(node1.equalsIgnoreCase("yes"))
																		{
																			complete();
																		}
																		else if(node1.equalsIgnoreCase("no"))
																		{
																			Thread.sleep(2000);
																			i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																			l7.setIcon(i7g);
																			Thread.sleep(10000);
																			
																			send();
																		}
																	
																	}
																}
																else
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
															}
														}
													}
													else
													{
														
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
												}
											}
										}
										else
										{
											if(Integer.parseInt(e5)>length)
											{
												Thread.sleep(2000);
												i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
												l5.setIcon(i5g);
												
												int ene111 = (Integer.parseInt(e5)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
				
											
												if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
												{
													if(Integer.parseInt(e6)>length)
													{
														Thread.sleep(2000);
														i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
														l6.setIcon(i6g);
														
														int ene1111 =  (Integer.parseInt(e6)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
													
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
													else
													{
														Thread.sleep(2000);
														i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
														l6.setIcon(i6r);
														
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else if(node1.equalsIgnoreCase("no"))
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);
															Thread.sleep(10000);
															
															send();
														}
													
													}
												}
												else
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
											}
											else
											{
												Thread.sleep(2000);
												i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
												l5.setIcon(i5r);
												
												less5.setVisible(true);
												Thread.sleep(150);
												less5.setVisible(false);
												Thread.sleep(150);
												less5.setVisible(true);
												Thread.sleep(150);
												less5.setVisible(false);
												Thread.sleep(150);
												less5.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else
												{
													if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
													{
														if(Integer.parseInt(e6)>length)
														{
															Thread.sleep(2000);
															i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
															l6.setIcon(i6g);
															
															int ene1111 =  (Integer.parseInt(e6)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
														
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
														else
														{
															Thread.sleep(2000);
															i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
															l6.setIcon(i6r);
															
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else if(node1.equalsIgnoreCase("no"))
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);
																Thread.sleep(10000);
																
																send();
															}
														
														}
													}
													else
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
												}
											}
										}
									}
									else
									{
										Thread.sleep(2000);
										i3r = new ImageIcon(this.getClass().getResource("images/nr3.png"));
										l3.setIcon(i3r);
										
										less3.setVisible(true);
										Thread.sleep(150);
										less3.setVisible(false);
										Thread.sleep(150);
										less3.setVisible(true);
										Thread.sleep(150);
										less3.setVisible(false);
										Thread.sleep(150);
										less3.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n3+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else
										{
											if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
											{
												if(Integer.parseInt(e4)>length)
												{
													Thread.sleep(2000);
													i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
													l4.setIcon(i4g);
												
													int ene11 =  (Integer.parseInt(e4)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
												
												
													if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
													{
														if(Integer.parseInt(e5)>length)
														{
															Thread.sleep(2000);
															i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
															l5.setIcon(i5g);
															
															int ene111 = (Integer.parseInt(e5)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
							
														
															if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
															{
																if(Integer.parseInt(e6)>length)
																{
																	Thread.sleep(2000);
																	i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																	l6.setIcon(i6g);
																	
																	int ene1111 =  (Integer.parseInt(e6)-length);
																	connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
																else
																{
																	Thread.sleep(2000);
																	i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																	l6.setIcon(i6r);
																	
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	
																	rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																	if(rs.next())
																	{
																		koutn=rs.getString(3);
																	}
																	connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																	
																	con777 =new Socket("localhost",6666);
																	dos = new DataOutputStream(con777.getOutputStream());
																	dos.writeUTF("node5");
																	dos.writeUTF(oname);
																	
																	
																	dis = new DataInputStream(con777.getInputStream());
																	
																	node1 = dis.readUTF();
																	
																	
																	if(node1.equalsIgnoreCase("yes"))
																	{
																		complete();
																	}
																	else if(node1.equalsIgnoreCase("no"))
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);
																		Thread.sleep(10000);
																		
																		send();
																	}
																
																}
															}
															else
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
														}
														else
														{
															Thread.sleep(2000);
															i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
															l5.setIcon(i5r);
															
															less5.setVisible(true);
															Thread.sleep(150);
															less5.setVisible(false);
															Thread.sleep(150);
															less5.setVisible(true);
															Thread.sleep(150);
															less5.setVisible(false);
															Thread.sleep(150);
															less5.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else
															{
																if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
																{
																	if(Integer.parseInt(e6)>length)
																	{
																		Thread.sleep(2000);
																		i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																		l6.setIcon(i6g);
																		
																		int ene1111 =  (Integer.parseInt(e6)-length);
																		connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																	
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);

																		Thread.sleep(2000);
																		l1.setIcon(i1);
																		l2.setIcon(i2);
																		l3.setIcon(i3);
																		l4.setIcon(i4);
																		l5.setIcon(i5);
																		l6.setIcon(i6);
																		l7.setIcon(i7);
																		
																		socketsend();
																	}
																	else
																	{
																		Thread.sleep(2000);
																		i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																		l6.setIcon(i6r);
																		
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		
																		rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																		if(rs.next())
																		{
																			koutn=rs.getString(3);
																		}
																		connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																		
																		con777 =new Socket("localhost",6666);
																		dos = new DataOutputStream(con777.getOutputStream());
																		dos.writeUTF("node5");
																		dos.writeUTF(oname);
																		
																		
																		dis = new DataInputStream(con777.getInputStream());
																		
																		node1 = dis.readUTF();
																		
																		
																		if(node1.equalsIgnoreCase("yes"))
																		{
																			complete();
																		}
																		else if(node1.equalsIgnoreCase("no"))
																		{
																			Thread.sleep(2000);
																			i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																			l7.setIcon(i7g);
																			Thread.sleep(10000);
																			
																			send();
																		}
																	
																	}
																}
																else
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
															}
														}
													}
													else
													{
														
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
												}
												else
												{
													Thread.sleep(2000);
													i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
													l4.setIcon(i4r);
													
													less4.setVisible(true);
													Thread.sleep(150);
													less4.setVisible(false);
													Thread.sleep(150);
													less4.setVisible(true);
													Thread.sleep(150);
													less4.setVisible(false);
													Thread.sleep(150);
													less4.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else
													{
														if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
														{
															if(Integer.parseInt(e5)>length)
															{
																Thread.sleep(2000);
																i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
																l5.setIcon(i5g);
																
																int ene111 = (Integer.parseInt(e5)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
								
															
																if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
																{
																	if(Integer.parseInt(e6)>length)
																	{
																		Thread.sleep(2000);
																		i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																		l6.setIcon(i6g);
																		
																		int ene1111 =  (Integer.parseInt(e6)-length);
																		connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																	
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);

																		Thread.sleep(2000);
																		l1.setIcon(i1);
																		l2.setIcon(i2);
																		l3.setIcon(i3);
																		l4.setIcon(i4);
																		l5.setIcon(i5);
																		l6.setIcon(i6);
																		l7.setIcon(i7);
																		
																		socketsend();
																	}
																	else
																	{
																		Thread.sleep(2000);
																		i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																		l6.setIcon(i6r);
																		
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		Thread.sleep(150);
																		less6.setVisible(false);
																		Thread.sleep(150);
																		less6.setVisible(true);
																		
																		rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																		if(rs.next())
																		{
																			koutn=rs.getString(3);
																		}
																		connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																		
																		con777 =new Socket("localhost",6666);
																		dos = new DataOutputStream(con777.getOutputStream());
																		dos.writeUTF("node5");
																		dos.writeUTF(oname);
																		
																		
																		dis = new DataInputStream(con777.getInputStream());
																		
																		node1 = dis.readUTF();
																		
																		
																		if(node1.equalsIgnoreCase("yes"))
																		{
																			complete();
																		}
																		else if(node1.equalsIgnoreCase("no"))
																		{
																			Thread.sleep(2000);
																			i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																			l7.setIcon(i7g);
																			Thread.sleep(10000);
																			
																			send();
																		}
																	
																	}
																}
																else
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
															}
															else
															{
																Thread.sleep(2000);
																i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
																l5.setIcon(i5r);
																
																less5.setVisible(true);
																Thread.sleep(150);
																less5.setVisible(false);
																Thread.sleep(150);
																less5.setVisible(true);
																Thread.sleep(150);
																less5.setVisible(false);
																Thread.sleep(150);
																less5.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else
																{
																	if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
																	{
																		if(Integer.parseInt(e6)>length)
																		{
																			Thread.sleep(2000);
																			i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																			l6.setIcon(i6g);
																			
																			int ene1111 =  (Integer.parseInt(e6)-length);
																			connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																		
																			Thread.sleep(2000);
																			i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																			l7.setIcon(i7g);

																			Thread.sleep(2000);
																			l1.setIcon(i1);
																			l2.setIcon(i2);
																			l3.setIcon(i3);
																			l4.setIcon(i4);
																			l5.setIcon(i5);
																			l6.setIcon(i6);
																			l7.setIcon(i7);
																			
																			socketsend();
																		}
																		else
																		{
																			Thread.sleep(2000);
																			i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																			l6.setIcon(i6r);
																			
																			less6.setVisible(true);
																			Thread.sleep(150);
																			less6.setVisible(false);
																			Thread.sleep(150);
																			less6.setVisible(true);
																			Thread.sleep(150);
																			less6.setVisible(false);
																			Thread.sleep(150);
																			less6.setVisible(true);
																			
																			rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																			if(rs.next())
																			{
																				koutn=rs.getString(3);
																			}
																			connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																			
																			con777 =new Socket("localhost",6666);
																			dos = new DataOutputStream(con777.getOutputStream());
																			dos.writeUTF("node5");
																			dos.writeUTF(oname);
																			
																			
																			dis = new DataInputStream(con777.getInputStream());
																			
																			node1 = dis.readUTF();
																			
																			
																			if(node1.equalsIgnoreCase("yes"))
																			{
																				complete();
																			}
																			else if(node1.equalsIgnoreCase("no"))
																			{
																				Thread.sleep(2000);
																				i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																				l7.setIcon(i7g);
																				Thread.sleep(10000);
																				
																				send();
																			}
																		
																		}
																	}
																	else
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);

																		Thread.sleep(2000);
																		l1.setIcon(i1);
																		l2.setIcon(i2);
																		l3.setIcon(i3);
																		l4.setIcon(i4);
																		l5.setIcon(i5);
																		l6.setIcon(i6);
																		l7.setIcon(i7);
																		
																		socketsend();
																	}
																}
															}
														}
														else
														{
															
																if(Integer.parseInt(e6)>length)
																{
																	Thread.sleep(2000);
																	i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																	l6.setIcon(i6g);
																	
																	int ene1111 =  (Integer.parseInt(e6)-length);
																	connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
																else
																{
																	Thread.sleep(2000);
																	i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																	l6.setIcon(i6r);
																	
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	
																	rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																	if(rs.next())
																	{
																		koutn=rs.getString(3);
																	}
																	connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																	
																	con777 =new Socket("localhost",6666);
																	dos = new DataOutputStream(con777.getOutputStream());
																	dos.writeUTF("node5");
																	dos.writeUTF(oname);
																	
																	
																	dis = new DataInputStream(con777.getInputStream());
																	
																	node1 = dis.readUTF();
																	
																	
																	if(node1.equalsIgnoreCase("yes"))
																	{
																		complete();
																	}
																	else if(node1.equalsIgnoreCase("no"))
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);
																		Thread.sleep(10000);
																		
																		send();
																	}
																
																}
															}
													}
												}
											}
											else
											{
												if(Integer.parseInt(e5)>length)
												{
													Thread.sleep(2000);
													i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
													l5.setIcon(i5g);
													
													int ene111 = (Integer.parseInt(e5)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
					
												
													if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
													{
														if(Integer.parseInt(e6)>length)
														{
															Thread.sleep(2000);
															i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
															l6.setIcon(i6g);
															
															int ene1111 =  (Integer.parseInt(e6)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
														
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
														else
														{
															Thread.sleep(2000);
															i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
															l6.setIcon(i6r);
															
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else if(node1.equalsIgnoreCase("no"))
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);
																Thread.sleep(10000);
																
																send();
															}
														
														}
													}
													else
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
												}
												else
												{
													Thread.sleep(2000);
													i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
													l5.setIcon(i5r);
													
													less5.setVisible(true);
													Thread.sleep(150);
													less5.setVisible(false);
													Thread.sleep(150);
													less5.setVisible(true);
													Thread.sleep(150);
													less5.setVisible(false);
													Thread.sleep(150);
													less5.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else
													{
														if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
														{
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
														else
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
													}
												}
											}
										}
									}
								}
								else
								{
									if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
									{
										if(Integer.parseInt(e4)>length)
										{
											Thread.sleep(2000);
											i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
											l4.setIcon(i4g);
										
											int ene11 =  (Integer.parseInt(e4)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
										
										
											if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
											{
												if(Integer.parseInt(e5)>length)
												{
													Thread.sleep(2000);
													i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
													l5.setIcon(i5g);
													
													int ene111 = (Integer.parseInt(e5)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
					
												
													if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
													{
														if(Integer.parseInt(e6)>length)
														{
															Thread.sleep(2000);
															i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
															l6.setIcon(i6g);
															
															int ene1111 =  (Integer.parseInt(e6)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
														
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
														else
														{
															Thread.sleep(2000);
															i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
															l6.setIcon(i6r);
															
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else if(node1.equalsIgnoreCase("no"))
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);
																Thread.sleep(10000);
																
																send();
															}
														
														}
													}
													else
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
												}
												else
												{
													Thread.sleep(2000);
													i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
													l5.setIcon(i5r);
													
													less5.setVisible(true);
													Thread.sleep(150);
													less5.setVisible(false);
													Thread.sleep(150);
													less5.setVisible(true);
													Thread.sleep(150);
													less5.setVisible(false);
													Thread.sleep(150);
													less5.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else
													{
														if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
														{
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
														else
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
													}
												}
											}
											else
											{
												
													if(Integer.parseInt(e6)>length)
													{
														Thread.sleep(2000);
														i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
														l6.setIcon(i6g);
														
														int ene1111 =  (Integer.parseInt(e6)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
													
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
													else
													{
														Thread.sleep(2000);
														i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
														l6.setIcon(i6r);
														
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else if(node1.equalsIgnoreCase("no"))
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);
															Thread.sleep(10000);
															
															send();
														}
													
													}
												}
										}
										else
										{
											Thread.sleep(2000);
											i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
											l4.setIcon(i4r);
											
											less4.setVisible(true);
											Thread.sleep(150);
											less4.setVisible(false);
											Thread.sleep(150);
											less4.setVisible(true);
											Thread.sleep(150);
											less4.setVisible(false);
											Thread.sleep(150);
											less4.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else
											{
												if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
												{
													if(Integer.parseInt(e5)>length)
													{
														Thread.sleep(2000);
														i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
														l5.setIcon(i5g);
														
														int ene111 = (Integer.parseInt(e5)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
						
													
														if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
														{
															if(Integer.parseInt(e6)>length)
															{
																Thread.sleep(2000);
																i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																l6.setIcon(i6g);
																
																int ene1111 =  (Integer.parseInt(e6)-length);
																connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
															
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
															else
															{
																Thread.sleep(2000);
																i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																l6.setIcon(i6r);
																
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																Thread.sleep(150);
																less6.setVisible(false);
																Thread.sleep(150);
																less6.setVisible(true);
																
																rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																if(rs.next())
																{
																	koutn=rs.getString(3);
																}
																connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																
																con777 =new Socket("localhost",6666);
																dos = new DataOutputStream(con777.getOutputStream());
																dos.writeUTF("node5");
																dos.writeUTF(oname);
																
																
																dis = new DataInputStream(con777.getInputStream());
																
																node1 = dis.readUTF();
																
																
																if(node1.equalsIgnoreCase("yes"))
																{
																	complete();
																}
																else if(node1.equalsIgnoreCase("no"))
																{
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);
																	Thread.sleep(10000);
																	
																	send();
																}
															
															}
														}
														else
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
													}
													else
													{
														Thread.sleep(2000);
														i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
														l5.setIcon(i5r);
														
														less5.setVisible(true);
														Thread.sleep(150);
														less5.setVisible(false);
														Thread.sleep(150);
														less5.setVisible(true);
														Thread.sleep(150);
														less5.setVisible(false);
														Thread.sleep(150);
														less5.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else
														{
															if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
															{
																if(Integer.parseInt(e6)>length)
																{
																	Thread.sleep(2000);
																	i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
																	l6.setIcon(i6g);
																	
																	int ene1111 =  (Integer.parseInt(e6)-length);
																	connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
																
																	Thread.sleep(2000);
																	i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																	l7.setIcon(i7g);

																	Thread.sleep(2000);
																	l1.setIcon(i1);
																	l2.setIcon(i2);
																	l3.setIcon(i3);
																	l4.setIcon(i4);
																	l5.setIcon(i5);
																	l6.setIcon(i6);
																	l7.setIcon(i7);
																	
																	socketsend();
																}
																else
																{
																	Thread.sleep(2000);
																	i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
																	l6.setIcon(i6r);
																	
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	Thread.sleep(150);
																	less6.setVisible(false);
																	Thread.sleep(150);
																	less6.setVisible(true);
																	
																	rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
																	if(rs.next())
																	{
																		koutn=rs.getString(3);
																	}
																	connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
																	
																	con777 =new Socket("localhost",6666);
																	dos = new DataOutputStream(con777.getOutputStream());
																	dos.writeUTF("node5");
																	dos.writeUTF(oname);
																	
																	
																	dis = new DataInputStream(con777.getInputStream());
																	
																	node1 = dis.readUTF();
																	
																	
																	if(node1.equalsIgnoreCase("yes"))
																	{
																		complete();
																	}
																	else if(node1.equalsIgnoreCase("no"))
																	{
																		Thread.sleep(2000);
																		i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																		l7.setIcon(i7g);
																		Thread.sleep(10000);
																		
																		send();
																	}
																
																}
															}
															else
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);

																Thread.sleep(2000);
																l1.setIcon(i1);
																l2.setIcon(i2);
																l3.setIcon(i3);
																l4.setIcon(i4);
																l5.setIcon(i5);
																l6.setIcon(i6);
																l7.setIcon(i7);
																
																socketsend();
															}
														}
													}
												}
												else
												{
													
														if(Integer.parseInt(e6)>length)
														{
															Thread.sleep(2000);
															i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
															l6.setIcon(i6g);
															
															int ene1111 =  (Integer.parseInt(e6)-length);
															connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
														
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);

															Thread.sleep(2000);
															l1.setIcon(i1);
															l2.setIcon(i2);
															l3.setIcon(i3);
															l4.setIcon(i4);
															l5.setIcon(i5);
															l6.setIcon(i6);
															l7.setIcon(i7);
															
															socketsend();
														}
														else
														{
															Thread.sleep(2000);
															i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
															l6.setIcon(i6r);
															
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															Thread.sleep(150);
															less6.setVisible(false);
															Thread.sleep(150);
															less6.setVisible(true);
															
															rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
															if(rs.next())
															{
																koutn=rs.getString(3);
															}
															connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
															
															con777 =new Socket("localhost",6666);
															dos = new DataOutputStream(con777.getOutputStream());
															dos.writeUTF("node5");
															dos.writeUTF(oname);
															
															
															dis = new DataInputStream(con777.getInputStream());
															
															node1 = dis.readUTF();
															
															
															if(node1.equalsIgnoreCase("yes"))
															{
																complete();
															}
															else if(node1.equalsIgnoreCase("no"))
															{
																Thread.sleep(2000);
																i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
																l7.setIcon(i7g);
																Thread.sleep(10000);
																
																send();
															}
														
														}
													}
											}
										}
									}
									else
									{
										if(Integer.parseInt(e5)>length)
										{
											Thread.sleep(2000);
											i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
											l5.setIcon(i5g);
											
											int ene111 = (Integer.parseInt(e5)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
			
										
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
										else
										{
											Thread.sleep(2000);
											i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
											l5.setIcon(i5r);
											
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else
											{
												if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
												{
													if(Integer.parseInt(e6)>length)
													{
														Thread.sleep(2000);
														i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
														l6.setIcon(i6g);
														
														int ene1111 =  (Integer.parseInt(e6)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
													
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
													else
													{
														Thread.sleep(2000);
														i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
														l6.setIcon(i6r);
														
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else if(node1.equalsIgnoreCase("no"))
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);
															Thread.sleep(10000);
															
															send();
														}
													
													}
												}
												else
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
											}
										}
									}
								}
							}
							else
							{
								Thread.sleep(2000);
								i2r = new ImageIcon(this.getClass().getResource("images/nr2.png"));
								l2.setIcon(i2r);
								
								less2.setVisible(true);
								Thread.sleep(150);
								less2.setVisible(false);
								Thread.sleep(150);
								less2.setVisible(true);
								Thread.sleep(150);
								less2.setVisible(false);
								Thread.sleep(150);
								less2.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n2+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									elsetwo();
								}
							}
						}
						else
						{
							elsedisttwo();
						}
						}
				}catch (Exception e) {
					
				}
			}
		}
		
												
												
		  void elsedisttwo() throws InterruptedException, SQLException, UnknownHostException, IOException {
			  
				if(Integer.parseInt(e3)>length)
				{
					Thread.sleep(2000);
					i3g = new ImageIcon(this.getClass().getResource("images/ng3.png"));
					l3.setIcon(i3g);
					
					int ene1 = (Integer.parseInt(e3)-length);
					connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1+"' where nodename='"+n3+"'");
					
					if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
					{
						if(Integer.parseInt(e4)>length)
						{
							Thread.sleep(2000);
							i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
							l4.setIcon(i4g);
						
							int ene11 =  (Integer.parseInt(e4)-length);
							connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
						
						
							if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
							{
								if(Integer.parseInt(e5)>length)
								{
									Thread.sleep(2000);
									i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
									l5.setIcon(i5g);
									
									int ene111 = (Integer.parseInt(e5)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
	
								
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
								else
								{
									Thread.sleep(2000);
									i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
									l5.setIcon(i5r);
									
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else
									{
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
								}
							}
							else
							{
								
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
						}
						else
						{
							Thread.sleep(2000);
							i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
							l4.setIcon(i4r);
							
							less4.setVisible(true);
							Thread.sleep(150);
							less4.setVisible(false);
							Thread.sleep(150);
							less4.setVisible(true);
							Thread.sleep(150);
							less4.setVisible(false);
							Thread.sleep(150);
							less4.setVisible(true);
							
							rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
							if(rs.next())
							{
								koutn=rs.getString(3);
							}
							connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
							
							con777 =new Socket("localhost",6666);
							dos = new DataOutputStream(con777.getOutputStream());
							dos.writeUTF("node5");
							dos.writeUTF(oname);
							
							
							dis = new DataInputStream(con777.getInputStream());
							
							node1 = dis.readUTF();
							
							
							if(node1.equalsIgnoreCase("yes"))
							{
								complete();
							}
							else
							{
								if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
								{
									if(Integer.parseInt(e5)>length)
									{
										Thread.sleep(2000);
										i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
										l5.setIcon(i5g);
										
										int ene111 = (Integer.parseInt(e5)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
		
									
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
									else
									{
										Thread.sleep(2000);
										i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
										l5.setIcon(i5r);
										
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else
										{
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
									}
								}
								else
								{
									
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
							}
						}
					}
					else
					{
						if(Integer.parseInt(e5)>length)
						{
							Thread.sleep(2000);
							i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
							l5.setIcon(i5g);
							
							int ene111 = (Integer.parseInt(e5)-length);
							connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

						
							if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
							{
								if(Integer.parseInt(e6)>length)
								{
									Thread.sleep(2000);
									i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
									l6.setIcon(i6g);
									
									int ene1111 =  (Integer.parseInt(e6)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
								
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
								else
								{
									Thread.sleep(2000);
									i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
									l6.setIcon(i6r);
									
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else if(node1.equalsIgnoreCase("no"))
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);
										Thread.sleep(10000);
										
										send();
									}
								
								}
							}
							else
							{
								Thread.sleep(2000);
								i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
								l7.setIcon(i7g);

								Thread.sleep(2000);
								l1.setIcon(i1);
								l2.setIcon(i2);
								l3.setIcon(i3);
								l4.setIcon(i4);
								l5.setIcon(i5);
								l6.setIcon(i6);
								l7.setIcon(i7);
								
								socketsend();
							}
						}
						else
						{
							Thread.sleep(2000);
							i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
							l5.setIcon(i5r);
							
							less5.setVisible(true);
							Thread.sleep(150);
							less5.setVisible(false);
							Thread.sleep(150);
							less5.setVisible(true);
							Thread.sleep(150);
							less5.setVisible(false);
							Thread.sleep(150);
							less5.setVisible(true);
							
							rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
							if(rs.next())
							{
								koutn=rs.getString(3);
							}
							connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
							
							con777 =new Socket("localhost",6666);
							dos = new DataOutputStream(con777.getOutputStream());
							dos.writeUTF("node5");
							dos.writeUTF(oname);
							
							
							dis = new DataInputStream(con777.getInputStream());
							
							node1 = dis.readUTF();
							
							
							if(node1.equalsIgnoreCase("yes"))
							{
								complete();
							}
							else
							{
								if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
								{
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
								else
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
							}
						}
					}
				}
				else
				{
					Thread.sleep(2000);
					i3r = new ImageIcon(this.getClass().getResource("images/nr3.png"));
					l3.setIcon(i3r);
					
					less3.setVisible(true);
					Thread.sleep(150);
					less3.setVisible(false);
					Thread.sleep(150);
					less3.setVisible(true);
					Thread.sleep(150);
					less3.setVisible(false);
					Thread.sleep(150);
					less3.setVisible(true);
					
					rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
					if(rs.next())
					{
						koutn=rs.getString(3);
					}
					connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n3+"','"+koutn+"','"+tym+"')");
					
					con777 =new Socket("localhost",6666);
					dos = new DataOutputStream(con777.getOutputStream());
					dos.writeUTF("node5");
					dos.writeUTF(oname);
					
					
					dis = new DataInputStream(con777.getInputStream());
					
					node1 = dis.readUTF();
					
					
					if(node1.equalsIgnoreCase("yes"))
					{
						complete();
					}
					else
					{
						if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
						{
							if(Integer.parseInt(e4)>length)
							{
								Thread.sleep(2000);
								i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
								l4.setIcon(i4g);
							
								int ene11 =  (Integer.parseInt(e4)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
							
							
								if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
								{
									if(Integer.parseInt(e5)>length)
									{
										Thread.sleep(2000);
										i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
										l5.setIcon(i5g);
										
										int ene111 = (Integer.parseInt(e5)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
		
									
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
									else
									{
										Thread.sleep(2000);
										i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
										l5.setIcon(i5r);
										
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else
										{
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
									}
								}
								else
								{
									
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
							}
							else
							{
								Thread.sleep(2000);
								i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
								l4.setIcon(i4r);
								
								less4.setVisible(true);
								Thread.sleep(150);
								less4.setVisible(false);
								Thread.sleep(150);
								less4.setVisible(true);
								Thread.sleep(150);
								less4.setVisible(false);
								Thread.sleep(150);
								less4.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
									{
										if(Integer.parseInt(e5)>length)
										{
											Thread.sleep(2000);
											i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
											l5.setIcon(i5g);
											
											int ene111 = (Integer.parseInt(e5)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
			
										
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
										else
										{
											Thread.sleep(2000);
											i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
											l5.setIcon(i5r);
											
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else
											{
												if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
												{
													if(Integer.parseInt(e6)>length)
													{
														Thread.sleep(2000);
														i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
														l6.setIcon(i6g);
														
														int ene1111 =  (Integer.parseInt(e6)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
													
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
													else
													{
														Thread.sleep(2000);
														i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
														l6.setIcon(i6r);
														
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else if(node1.equalsIgnoreCase("no"))
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);
															Thread.sleep(10000);
															
															send();
														}
													
													}
												}
												else
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
											}
										}
									}
									else
									{
										
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
								}
							}
						}
						else
						{
							if(Integer.parseInt(e5)>length)
							{
								Thread.sleep(2000);
								i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
								l5.setIcon(i5g);
								
								int ene111 = (Integer.parseInt(e5)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

							
								if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
								{
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
								else
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
							}
							else
							{
								Thread.sleep(2000);
								i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
								l5.setIcon(i5r);
								
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
							}
						}
					}
				}
		  }

		void elsetwo() throws InterruptedException, SQLException, UnknownHostException, IOException {

			if(Integer.parseInt(dis3)<Integer.parseInt(dis4))
			{
				if(Integer.parseInt(e3)>length)
				{
					Thread.sleep(2000);
					i3g = new ImageIcon(this.getClass().getResource("images/ng3.png"));
					l3.setIcon(i3g);
					
					int ene1 = (Integer.parseInt(e3)-length);
					connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1+"' where nodename='"+n3+"'");
					
					if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
					{
						if(Integer.parseInt(e4)>length)
						{
							Thread.sleep(2000);
							i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
							l4.setIcon(i4g);
						
							int ene11 =  (Integer.parseInt(e4)-length);
							connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
						
						
							if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
							{
								if(Integer.parseInt(e5)>length)
								{
									Thread.sleep(2000);
									i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
									l5.setIcon(i5g);
									
									int ene111 = (Integer.parseInt(e5)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
	
								
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
								else
								{
									Thread.sleep(2000);
									i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
									l5.setIcon(i5r);
									
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else
									{
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
								}
							}
							else
							{
								
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
						}
						else
						{
							Thread.sleep(2000);
							i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
							l4.setIcon(i4r);
							
							less4.setVisible(true);
							Thread.sleep(150);
							less4.setVisible(false);
							Thread.sleep(150);
							less4.setVisible(true);
							Thread.sleep(150);
							less4.setVisible(false);
							Thread.sleep(150);
							less4.setVisible(true);
							
							rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
							if(rs.next())
							{
								koutn=rs.getString(3);
							}
							connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
							
							con777 =new Socket("localhost",6666);
							dos = new DataOutputStream(con777.getOutputStream());
							dos.writeUTF("node5");
							dos.writeUTF(oname);
							
							
							dis = new DataInputStream(con777.getInputStream());
							
							node1 = dis.readUTF();
							
							
							if(node1.equalsIgnoreCase("yes"))
							{
								complete();
							}
							else
							{
								if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
								{
									if(Integer.parseInt(e5)>length)
									{
										Thread.sleep(2000);
										i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
										l5.setIcon(i5g);
										
										int ene111 = (Integer.parseInt(e5)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
		
									
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
									else
									{
										Thread.sleep(2000);
										i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
										l5.setIcon(i5r);
										
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else
										{
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
									}
								}
								else
								{
									
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
							}
						}
					}
					else
					{
						if(Integer.parseInt(e5)>length)
						{
							Thread.sleep(2000);
							i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
							l5.setIcon(i5g);
							
							int ene111 = (Integer.parseInt(e5)-length);
							connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

						
							if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
							{
								if(Integer.parseInt(e6)>length)
								{
									Thread.sleep(2000);
									i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
									l6.setIcon(i6g);
									
									int ene1111 =  (Integer.parseInt(e6)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
								
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
								else
								{
									Thread.sleep(2000);
									i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
									l6.setIcon(i6r);
									
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else if(node1.equalsIgnoreCase("no"))
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);
										Thread.sleep(10000);
										
										send();
									}
								
								}
							}
							else
							{
								Thread.sleep(2000);
								i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
								l7.setIcon(i7g);

								Thread.sleep(2000);
								l1.setIcon(i1);
								l2.setIcon(i2);
								l3.setIcon(i3);
								l4.setIcon(i4);
								l5.setIcon(i5);
								l6.setIcon(i6);
								l7.setIcon(i7);
								
								socketsend();
							}
						}
						else
						{
							Thread.sleep(2000);
							i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
							l5.setIcon(i5r);
							
							less5.setVisible(true);
							Thread.sleep(150);
							less5.setVisible(false);
							Thread.sleep(150);
							less5.setVisible(true);
							Thread.sleep(150);
							less5.setVisible(false);
							Thread.sleep(150);
							less5.setVisible(true);
							
							rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
							if(rs.next())
							{
								koutn=rs.getString(3);
							}
							connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
							
							con777 =new Socket("localhost",6666);
							dos = new DataOutputStream(con777.getOutputStream());
							dos.writeUTF("node5");
							dos.writeUTF(oname);
							
							
							dis = new DataInputStream(con777.getInputStream());
							
							node1 = dis.readUTF();
							
							
							if(node1.equalsIgnoreCase("yes"))
							{
								complete();
							}
							else
							{
								if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
								{
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
								else
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
							}
						}
					}
				}
				else
				{
					Thread.sleep(2000);
					i3r = new ImageIcon(this.getClass().getResource("images/nr3.png"));
					l3.setIcon(i3r);
					
					less3.setVisible(true);
					Thread.sleep(150);
					less3.setVisible(false);
					Thread.sleep(150);
					less3.setVisible(true);
					Thread.sleep(150);
					less3.setVisible(false);
					Thread.sleep(150);
					less3.setVisible(true);
					
					rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
					if(rs.next())
					{
						koutn=rs.getString(3);
					}
					connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n3+"','"+koutn+"','"+tym+"')");
					
					con777 =new Socket("localhost",6666);
					dos = new DataOutputStream(con777.getOutputStream());
					dos.writeUTF("node5");
					dos.writeUTF(oname);
					
					
					dis = new DataInputStream(con777.getInputStream());
					
					node1 = dis.readUTF();
					
					
					if(node1.equalsIgnoreCase("yes"))
					{
						complete();
					}
					else
					{
						if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
						{
							if(Integer.parseInt(e4)>length)
							{
								Thread.sleep(2000);
								i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
								l4.setIcon(i4g);
							
								int ene11 =  (Integer.parseInt(e4)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
							
							
								if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
								{
									if(Integer.parseInt(e5)>length)
									{
										Thread.sleep(2000);
										i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
										l5.setIcon(i5g);
										
										int ene111 = (Integer.parseInt(e5)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
		
									
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
									else
									{
										Thread.sleep(2000);
										i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
										l5.setIcon(i5r);
										
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										Thread.sleep(150);
										less5.setVisible(false);
										Thread.sleep(150);
										less5.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else
										{
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
									}
								}
								else
								{
									
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
							}
							else
							{
								Thread.sleep(2000);
								i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
								l4.setIcon(i4r);
								
								less4.setVisible(true);
								Thread.sleep(150);
								less4.setVisible(false);
								Thread.sleep(150);
								less4.setVisible(true);
								Thread.sleep(150);
								less4.setVisible(false);
								Thread.sleep(150);
								less4.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
									{
										if(Integer.parseInt(e5)>length)
										{
											Thread.sleep(2000);
											i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
											l5.setIcon(i5g);
											
											int ene111 = (Integer.parseInt(e5)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
			
										
											if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
											{
												if(Integer.parseInt(e6)>length)
												{
													Thread.sleep(2000);
													i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
													l6.setIcon(i6g);
													
													int ene1111 =  (Integer.parseInt(e6)-length);
													connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
												
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
												else
												{
													Thread.sleep(2000);
													i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
													l6.setIcon(i6r);
													
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													Thread.sleep(150);
													less6.setVisible(false);
													Thread.sleep(150);
													less6.setVisible(true);
													
													rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
													if(rs.next())
													{
														koutn=rs.getString(3);
													}
													connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
													
													con777 =new Socket("localhost",6666);
													dos = new DataOutputStream(con777.getOutputStream());
													dos.writeUTF("node5");
													dos.writeUTF(oname);
													
													
													dis = new DataInputStream(con777.getInputStream());
													
													node1 = dis.readUTF();
													
													
													if(node1.equalsIgnoreCase("yes"))
													{
														complete();
													}
													else if(node1.equalsIgnoreCase("no"))
													{
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);
														Thread.sleep(10000);
														
														send();
													}
												
												}
											}
											else
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
										}
										else
										{
											Thread.sleep(2000);
											i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
											l5.setIcon(i5r);
											
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											Thread.sleep(150);
											less5.setVisible(false);
											Thread.sleep(150);
											less5.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else
											{
												if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
												{
													if(Integer.parseInt(e6)>length)
													{
														Thread.sleep(2000);
														i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
														l6.setIcon(i6g);
														
														int ene1111 =  (Integer.parseInt(e6)-length);
														connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
													
														Thread.sleep(2000);
														i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
														l7.setIcon(i7g);

														Thread.sleep(2000);
														l1.setIcon(i1);
														l2.setIcon(i2);
														l3.setIcon(i3);
														l4.setIcon(i4);
														l5.setIcon(i5);
														l6.setIcon(i6);
														l7.setIcon(i7);
														
														socketsend();
													}
													else
													{
														Thread.sleep(2000);
														i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
														l6.setIcon(i6r);
														
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														Thread.sleep(150);
														less6.setVisible(false);
														Thread.sleep(150);
														less6.setVisible(true);
														
														rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
														if(rs.next())
														{
															koutn=rs.getString(3);
														}
														connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
														
														con777 =new Socket("localhost",6666);
														dos = new DataOutputStream(con777.getOutputStream());
														dos.writeUTF("node5");
														dos.writeUTF(oname);
														
														
														dis = new DataInputStream(con777.getInputStream());
														
														node1 = dis.readUTF();
														
														
														if(node1.equalsIgnoreCase("yes"))
														{
															complete();
														}
														else if(node1.equalsIgnoreCase("no"))
														{
															Thread.sleep(2000);
															i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
															l7.setIcon(i7g);
															Thread.sleep(10000);
															
															send();
														}
													
													}
												}
												else
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);

													Thread.sleep(2000);
													l1.setIcon(i1);
													l2.setIcon(i2);
													l3.setIcon(i3);
													l4.setIcon(i4);
													l5.setIcon(i5);
													l6.setIcon(i6);
													l7.setIcon(i7);
													
													socketsend();
												}
											}
										}
									}
									else
									{
										
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
								}
							}
						}
						else
						{
							if(Integer.parseInt(e5)>length)
							{
								Thread.sleep(2000);
								i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
								l5.setIcon(i5g);
								
								int ene111 = (Integer.parseInt(e5)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

							
								if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
								{
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
								else
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
							}
							else
							{
								Thread.sleep(2000);
								i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
								l5.setIcon(i5r);
								
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
							}
						}
					}
				}
			}
			else
			{
				if(Integer.parseInt(dis4)<Integer.parseInt(dis5))
				{
					if(Integer.parseInt(e4)>length)
					{
						Thread.sleep(2000);
						i4g = new ImageIcon(this.getClass().getResource("images/ng4.png"));
						l4.setIcon(i4g);
					
						int ene11 =  (Integer.parseInt(e4)-length);
						connect.createStatement().executeUpdate("update mobilenode set energy='"+ene11+"' where nodename='"+n4+"'");
					
					
						if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
						{
							if(Integer.parseInt(e5)>length)
							{
								Thread.sleep(2000);
								i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
								l5.setIcon(i5g);
								
								int ene111 = (Integer.parseInt(e5)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

							
								if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
								{
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
								else
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
							}
							else
							{
								Thread.sleep(2000);
								i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
								l5.setIcon(i5r);
								
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								Thread.sleep(150);
								less5.setVisible(false);
								Thread.sleep(150);
								less5.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else
								{
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
							}
						}
						else
						{
							
								if(Integer.parseInt(e6)>length)
								{
									Thread.sleep(2000);
									i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
									l6.setIcon(i6g);
									
									int ene1111 =  (Integer.parseInt(e6)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
								
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
								else
								{
									Thread.sleep(2000);
									i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
									l6.setIcon(i6r);
									
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else if(node1.equalsIgnoreCase("no"))
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);
										Thread.sleep(10000);
										
										send();
									}
								
								}
							}
					}
					else
					{
						Thread.sleep(2000);
						i4r = new ImageIcon(this.getClass().getResource("images/nr4.png"));
						l4.setIcon(i4r);
						
						less4.setVisible(true);
						Thread.sleep(150);
						less4.setVisible(false);
						Thread.sleep(150);
						less4.setVisible(true);
						Thread.sleep(150);
						less4.setVisible(false);
						Thread.sleep(150);
						less4.setVisible(true);
						
						rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
						if(rs.next())
						{
							koutn=rs.getString(3);
						}
						connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n4+"','"+koutn+"','"+tym+"')");
						
						con777 =new Socket("localhost",6666);
						dos = new DataOutputStream(con777.getOutputStream());
						dos.writeUTF("node5");
						dos.writeUTF(oname);
						
						
						dis = new DataInputStream(con777.getInputStream());
						
						node1 = dis.readUTF();
						
						
						if(node1.equalsIgnoreCase("yes"))
						{
							complete();
						}
						else
						{
							if(Integer.parseInt(dis5)<Integer.parseInt(dis6))
							{
								if(Integer.parseInt(e5)>length)
								{
									Thread.sleep(2000);
									i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
									l5.setIcon(i5g);
									
									int ene111 = (Integer.parseInt(e5)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");
	
								
									if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
									{
										if(Integer.parseInt(e6)>length)
										{
											Thread.sleep(2000);
											i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
											l6.setIcon(i6g);
											
											int ene1111 =  (Integer.parseInt(e6)-length);
											connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
										
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
										else
										{
											Thread.sleep(2000);
											i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
											l6.setIcon(i6r);
											
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											Thread.sleep(150);
											less6.setVisible(false);
											Thread.sleep(150);
											less6.setVisible(true);
											
											rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
											if(rs.next())
											{
												koutn=rs.getString(3);
											}
											connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
											
											con777 =new Socket("localhost",6666);
											dos = new DataOutputStream(con777.getOutputStream());
											dos.writeUTF("node5");
											dos.writeUTF(oname);
											
											
											dis = new DataInputStream(con777.getInputStream());
											
											node1 = dis.readUTF();
											
											
											if(node1.equalsIgnoreCase("yes"))
											{
												complete();
											}
											else if(node1.equalsIgnoreCase("no"))
											{
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);
												Thread.sleep(10000);
												
												send();
											}
										
										}
									}
									else
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
								}
								else
								{
									Thread.sleep(2000);
									i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
									l5.setIcon(i5r);
									
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									Thread.sleep(150);
									less5.setVisible(false);
									Thread.sleep(150);
									less5.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else
									{
										if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
										{
											if(Integer.parseInt(e6)>length)
											{
												Thread.sleep(2000);
												i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
												l6.setIcon(i6g);
												
												int ene1111 =  (Integer.parseInt(e6)-length);
												connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
											
												Thread.sleep(2000);
												i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
												l7.setIcon(i7g);

												Thread.sleep(2000);
												l1.setIcon(i1);
												l2.setIcon(i2);
												l3.setIcon(i3);
												l4.setIcon(i4);
												l5.setIcon(i5);
												l6.setIcon(i6);
												l7.setIcon(i7);
												
												socketsend();
											}
											else
											{
												Thread.sleep(2000);
												i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
												l6.setIcon(i6r);
												
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												Thread.sleep(150);
												less6.setVisible(false);
												Thread.sleep(150);
												less6.setVisible(true);
												
												rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
												if(rs.next())
												{
													koutn=rs.getString(3);
												}
												connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
												
												con777 =new Socket("localhost",6666);
												dos = new DataOutputStream(con777.getOutputStream());
												dos.writeUTF("node5");
												dos.writeUTF(oname);
												
												
												dis = new DataInputStream(con777.getInputStream());
												
												node1 = dis.readUTF();
												
												
												if(node1.equalsIgnoreCase("yes"))
												{
													complete();
												}
												else if(node1.equalsIgnoreCase("no"))
												{
													Thread.sleep(2000);
													i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
													l7.setIcon(i7g);
													Thread.sleep(10000);
													
													send();
												}
											
											}
										}
										else
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);

											Thread.sleep(2000);
											l1.setIcon(i1);
											l2.setIcon(i2);
											l3.setIcon(i3);
											l4.setIcon(i4);
											l5.setIcon(i5);
											l6.setIcon(i6);
											l7.setIcon(i7);
											
											socketsend();
										}
									}
								}
							}
							else
							{
								
									if(Integer.parseInt(e6)>length)
									{
										Thread.sleep(2000);
										i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
										l6.setIcon(i6g);
										
										int ene1111 =  (Integer.parseInt(e6)-length);
										connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
									
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);

										Thread.sleep(2000);
										l1.setIcon(i1);
										l2.setIcon(i2);
										l3.setIcon(i3);
										l4.setIcon(i4);
										l5.setIcon(i5);
										l6.setIcon(i6);
										l7.setIcon(i7);
										
										socketsend();
									}
									else
									{
										Thread.sleep(2000);
										i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
										l6.setIcon(i6r);
										
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										Thread.sleep(150);
										less6.setVisible(false);
										Thread.sleep(150);
										less6.setVisible(true);
										
										rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
										if(rs.next())
										{
											koutn=rs.getString(3);
										}
										connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
										
										con777 =new Socket("localhost",6666);
										dos = new DataOutputStream(con777.getOutputStream());
										dos.writeUTF("node5");
										dos.writeUTF(oname);
										
										
										dis = new DataInputStream(con777.getInputStream());
										
										node1 = dis.readUTF();
										
										
										if(node1.equalsIgnoreCase("yes"))
										{
											complete();
										}
										else if(node1.equalsIgnoreCase("no"))
										{
											Thread.sleep(2000);
											i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
											l7.setIcon(i7g);
											Thread.sleep(10000);
											
											send();
										}
									
									}
								}
						}
					}
				}
				else
				{
					if(Integer.parseInt(e5)>length)
					{
						Thread.sleep(2000);
						i5g = new ImageIcon(this.getClass().getResource("images/ng5.png"));
						l5.setIcon(i5g);
						
						int ene111 = (Integer.parseInt(e5)-length);
						connect.createStatement().executeUpdate("update mobilenode set energy='"+ene111+"' where nodename='"+n5+"'");

					
						if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
						{
							if(Integer.parseInt(e6)>length)
							{
								Thread.sleep(2000);
								i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
								l6.setIcon(i6g);
								
								int ene1111 =  (Integer.parseInt(e6)-length);
								connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
							
								Thread.sleep(2000);
								i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
								l7.setIcon(i7g);

								Thread.sleep(2000);
								l1.setIcon(i1);
								l2.setIcon(i2);
								l3.setIcon(i3);
								l4.setIcon(i4);
								l5.setIcon(i5);
								l6.setIcon(i6);
								l7.setIcon(i7);
								
								socketsend();
							}
							else
							{
								Thread.sleep(2000);
								i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
								l6.setIcon(i6r);
								
								less6.setVisible(true);
								Thread.sleep(150);
								less6.setVisible(false);
								Thread.sleep(150);
								less6.setVisible(true);
								Thread.sleep(150);
								less6.setVisible(false);
								Thread.sleep(150);
								less6.setVisible(true);
								
								rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
								if(rs.next())
								{
									koutn=rs.getString(3);
								}
								connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
								
								con777 =new Socket("localhost",6666);
								dos = new DataOutputStream(con777.getOutputStream());
								dos.writeUTF("node5");
								dos.writeUTF(oname);
								
								
								dis = new DataInputStream(con777.getInputStream());
								
								node1 = dis.readUTF();
								
								
								if(node1.equalsIgnoreCase("yes"))
								{
									complete();
								}
								else if(node1.equalsIgnoreCase("no"))
								{
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);
									Thread.sleep(10000);
									
									send();
								}
							
							}
						}
						else
						{
							Thread.sleep(2000);
							i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
							l7.setIcon(i7g);

							Thread.sleep(2000);
							l1.setIcon(i1);
							l2.setIcon(i2);
							l3.setIcon(i3);
							l4.setIcon(i4);
							l5.setIcon(i5);
							l6.setIcon(i6);
							l7.setIcon(i7);
							
							socketsend();
						}
					}
					else
					{
						Thread.sleep(2000);
						i5r = new ImageIcon(this.getClass().getResource("images/nr5.png"));
						l5.setIcon(i5r);
						
						less5.setVisible(true);
						Thread.sleep(150);
						less5.setVisible(false);
						Thread.sleep(150);
						less5.setVisible(true);
						Thread.sleep(150);
						less5.setVisible(false);
						Thread.sleep(150);
						less5.setVisible(true);
						
						rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
						if(rs.next())
						{
							koutn=rs.getString(3);
						}
						connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n5+"','"+koutn+"','"+tym+"')");
						
						con777 =new Socket("localhost",6666);
						dos = new DataOutputStream(con777.getOutputStream());
						dos.writeUTF("node5");
						dos.writeUTF(oname);
						
						
						dis = new DataInputStream(con777.getInputStream());
						
						node1 = dis.readUTF();
						
						
						if(node1.equalsIgnoreCase("yes"))
						{
							complete();
						}
						else
						{
							if(Integer.parseInt(dis6)<Integer.parseInt(dis7))
							{
								if(Integer.parseInt(e6)>length)
								{
									Thread.sleep(2000);
									i6g = new ImageIcon(this.getClass().getResource("images/ng6.png"));
									l6.setIcon(i6g);
									
									int ene1111 =  (Integer.parseInt(e6)-length);
									connect.createStatement().executeUpdate("update mobilenode set energy='"+ene1111+"' where nodename='"+n6+"'");
								
									Thread.sleep(2000);
									i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
									l7.setIcon(i7g);

									Thread.sleep(2000);
									l1.setIcon(i1);
									l2.setIcon(i2);
									l3.setIcon(i3);
									l4.setIcon(i4);
									l5.setIcon(i5);
									l6.setIcon(i6);
									l7.setIcon(i7);
									
									socketsend();
								}
								else
								{
									Thread.sleep(2000);
									i6r = new ImageIcon(this.getClass().getResource("images/nr6.png"));
									l6.setIcon(i6r);
									
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									Thread.sleep(150);
									less6.setVisible(false);
									Thread.sleep(150);
									less6.setVisible(true);
									
									rs = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
									if(rs.next())
									{
										koutn=rs.getString(3);
									}
									connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n6+"','"+koutn+"','"+tym+"')");
									
									con777 =new Socket("localhost",6666);
									dos = new DataOutputStream(con777.getOutputStream());
									dos.writeUTF("node5");
									dos.writeUTF(oname);
									
									
									dis = new DataInputStream(con777.getInputStream());
									
									node1 = dis.readUTF();
									
									
									if(node1.equalsIgnoreCase("yes"))
									{
										complete();
									}
									else if(node1.equalsIgnoreCase("no"))
									{
										Thread.sleep(2000);
										i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
										l7.setIcon(i7g);
										Thread.sleep(10000);
										
										send();
									}
								
								}
							}
							else
							{
								Thread.sleep(2000);
								i7g = new ImageIcon(this.getClass().getResource("images/ng7.png"));
								l7.setIcon(i7g);

								Thread.sleep(2000);
								l1.setIcon(i1);
								l2.setIcon(i2);
								l3.setIcon(i3);
								l4.setIcon(i4);
								l5.setIcon(i5);
								l6.setIcon(i6);
								l7.setIcon(i7);
								
								socketsend();
							}
						}
					}
				}
			}
			
		}

		void socketsend() throws UnknownHostException, IOException, InterruptedException {

			less2.setVisible(false);
			less3.setVisible(false);
			less4.setVisible(false);
			less5.setVisible(false);
			less6.setVisible(false);
			
			 Socket client = new Socket("localhost",2323);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				
				dos.writeUTF(oname);
				dos.writeUTF(filename);
				dos.writeUTF(sk);
				dos.writeUTF(ct);
				
				dos.writeUTF(sp1);
				dos.writeUTF(sp2);
				dos.writeUTF(sp3);
				dos.writeUTF(sp4);
				dos.writeUTF(sp5);
				dos.writeUTF(h1);
				dos.writeUTF(h2);
				dos.writeUTF(h3);
				dos.writeUTF(h4);
				dos.writeUTF(h5);
				dos.writeUTF(tym);
				
/*sleep*/						Thread.sleep(5000);
				
				l1.setIcon(i1);
				l2.setIcon(i2);
				l3.setIcon(i3);
				l4.setIcon(i4);
				l5.setIcon(i5);
				l6.setIcon(i6);
				l7.setIcon(i7);
				
				less2.setVisible(false);
				less3.setVisible(false);
				less4.setVisible(false);
				less5.setVisible(false);
				less6.setVisible(false);
			
		}

		private void send() throws UnknownHostException, IOException, InterruptedException {

			
			
			
			Socket client = new Socket("localhost",2323);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			dos.writeUTF(oname);
			dos.writeUTF(filename);
			dos.writeUTF(sk);
			dos.writeUTF(ct);
			
			dos.writeUTF(sp1);
			dos.writeUTF(sp2);
			dos.writeUTF(sp3);
			dos.writeUTF(sp4);
			dos.writeUTF(sp5);
			dos.writeUTF(h1);
			dos.writeUTF(h2);
			dos.writeUTF(h3);
			dos.writeUTF(h4);
			dos.writeUTF(h5);
			dos.writeUTF(tym);
			
			
			DataInputStream din = new DataInputStream(client.getInputStream());
			
			String node1 = din.readUTF();
			
			if(node1.equalsIgnoreCase("yes"))
			{
				complete();
				
			}
			else if(node1.equalsIgnoreCase("no"))
			{
				System.out.println("OK");
			}
			Thread.sleep(5000);
			
			l1.setIcon(i1);
			l2.setIcon(i2);
			l3.setIcon(i3);
			l4.setIcon(i4);
			l5.setIcon(i5);
			l6.setIcon(i6);
			l7.setIcon(i7);
			
			less2.setVisible(false);
			less3.setVisible(false);
			less4.setVisible(false);
			less5.setVisible(false);
			less6.setVisible(false);
		}

		 void complete() {
			
			JOptionPane.showMessageDialog(null, "All The Tasks Are Completed For This User");
			
			l1.setIcon(i1);
			l2.setIcon(i2);
			l3.setIcon(i3);
			l4.setIcon(i4);
			l5.setIcon(i5);
			l6.setIcon(i6);
			l7.setIcon(i7);
			
			less2.setVisible(false);
			less3.setVisible(false);
			less4.setVisible(false);
			less5.setVisible(false);
			less6.setVisible(false);
			
		}

		
	}
	public static void main(String[] args) throws SQLException {
		
		AdhocNetwork a = new AdhocNetwork();
		a.up();
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		if(a.getSource()==item)
		{
			ViewEnergy v = new ViewEnergy();
			v.setSize(500, 300);
			v.setVisible(true);
			
		}
		if(a.getSource()==item1)
		{
			EnergyUpdate v1 = new EnergyUpdate();
			v1.setSize(450, 450);
			v1.setVisible(true);
			
		}
	}

}
