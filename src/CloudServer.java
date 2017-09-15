import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class CloudServer implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	JPanel p1, p2;
	JButton b1, b2, b3, b4;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1;
	MenuBar mbr;
	Menu file;
	MenuItem  item2, users,owner,enduser,exit;
	Border b11, b22, b33;
	JScrollPane pane;
	String Scheme1, rank;
	String f1 = "", f2 = "", f3 = "", f4 = "", f5 = "", f6 = "", f7 = "",f8 = "";
	int count = 0;
	Timer timer;
	ImageIcon c1,c2,c3;
	JLabel a1,a2,a3,lab,network,cloud;
	
	public Font f = new Font("Times new roman", Font.BOLD, 18);
	public Font font = new Font("Times new roman", Font.BOLD, 18);
	
	JLabel mg1, mg2, mg3, mg4, mg5, mg6, mg7, mg8, mg9, mg10, g11, g22, g33,
			g44, g55, g66, g77;
	ImageIcon g1, g2, g3, g4, g5, g6, g7;
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";

	CloudServer() {
		jf = new JFrame("Cloud Server::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.WHITE);
		timer = new Timer(0, null);

		
		c1 = new ImageIcon(this.getClass().getResource("images/cloud1.png"));
		a1=new JLabel();
		a1.setIcon(c1);
		a1.setBounds(420, 150, 500, 200);
		c.add(a1);
		
		c2 = new ImageIcon(this.getClass().getResource("images/cloud4.png"));
		a2=new JLabel();
		a2.setIcon(c2);
		a2.setBounds(300, 150, 200, 200);
		c.add(a2);
		
		c3 = new ImageIcon(this.getClass().getResource("images/cloud3.jpg"));
		a3=new JLabel();
		a3.setIcon(c3);
		a3.setBounds(100, 150, 200, 200);
		c.add(a3);
		
		lab = new JLabel("UPLOADED SUCCESSFULLY");
		lab.setFont(f);
		lab.setBounds(420, 340, 500, 30);
		lab.setVisible(false);
		c.add(lab);
		
		network = new JLabel("Adhoc Network");
		network.setBounds(120, 50, 200, 200);
		network.setFont(font);
		c.add(network);
		
		cloud = new JLabel("Cloud Server");
		cloud.setBounds(500, 50, 500, 200);
		cloud.setFont(font);
		c.add(cloud);
		
		ImageIcon banner = new ImageIcon(this.getClass().getResource("images/server.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(-15, -30,  1300,590);

		t1 = new JTextField(15);
		Border b22 = BorderFactory.createBevelBorder(0);
		l2 = new JLabel();
		l2.setBorder(b22);
		
		b1 = new JButton("View Cloud Files");
		b1.setForeground(Color.BLACK);
		b1.addActionListener(this);

		mbr = new MenuBar();
		file = new Menu("File");

		users = new MenuItem("View Attackers");
		owner = new MenuItem("View Owner Details");
		enduser = new MenuItem("View End User Details");
		exit = new MenuItem("Exit");
	
		users.addActionListener(this);
		owner.addActionListener(this);
		enduser.addActionListener(this);
		exit.addActionListener(this);

		file.add(users);
		file.add(owner);
		file.add(enduser);
		file.add(exit);
		mbr.add(file);
		jf.setMenuBar(mbr);

		c.add(l2);
		
		c.add(title);
		b1.setBounds(270, 370, 200, 30);
		c.add(b1);
		jf.setBounds(0, 0, 770,500);
		jf.show();

		int[] ports = new int[] { 2424,4545,7373,3434,9988};
		
		for (int i = 0; i < 5; i++) {
			Thread t2 = new Thread(new PortListener(ports[i]));
			t2.start();
		}
	}

	public static void main(String args[])
	{
//		new CloudServer();
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CloudServer();
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
				
		if (o == b1) {
			
			ViewCloudFiles v =new ViewCloudFiles();
			v.setSize(500, 500);
			v.setVisible(true);
		}
		

		if (o == users) {
			
			ViewAttacker v =new ViewAttacker();
			v.setSize(500, 500);
			v.setVisible(true);
		}
		if (o == owner) {
			
			ViewDataOwners v1 =new ViewDataOwners();
			v1.setSize(500, 500);
			v1.setVisible(true);
		}
		
		if (o == enduser) {
			
			ViewEndUser v11 =new ViewEndUser();
			v11.setSize(500, 500);
			v11.setVisible(true);
		}
		
		
		if(o == exit)
		{
			System.exit(0);
		}
	}

	class PortListener implements Runnable {
		
		int port;

		public PortListener(int port) {
			this.port = port;
		}

		public void run() {
			try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Dbcon db=new Dbcon();
			Connection connect=db.getConnection();
			//connect =  DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq=src\\Database.mdb");
			
			 
		 if (this.port == 2424) {
			 
				try {
					ServerSocket sc01, sc02, sc03, sc04, sc11, sc12;
					Socket cn01, cn02, cn03, cn04, cn05, cn1, cn2;
					
					sc02 = new ServerSocket(2424);

						String oname,filename,sk,ct;
						String sp1,sp2,sp3,sp4,sp5;
						String h1,h2,h3,h4,h5;
						String tym;
						
					while (true) {
						cn02 = sc02.accept();
						
						
						Statement stmt = connect.createStatement();
						DataInputStream dis = new DataInputStream(cn02.getInputStream());
						
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

						
						 int len = filename.length();
						 String fname = filename.substring(0, len-5);
						
							
						 	Thread.sleep(2000);
							c3 = new ImageIcon(this.getClass().getResource("images/cloud3.jpg"));
							a3.setIcon(c3);
							a3.setVisible(false);
							Thread.sleep(1000);
							a3.setVisible(true);
							Thread.sleep(1000);
							a3.setVisible(false);
							Thread.sleep(1000);
							a3.setVisible(true);
							
							Thread.sleep(2000);
							c2 = new ImageIcon(this.getClass().getResource("images/cloud2.png"));
							a2.setIcon(c2);
							
							Thread.sleep(2000);
							c1 = new ImageIcon(this.getClass().getResource("images/cloud1.png"));
							a1.setIcon(c1);
							a1.setVisible(false);
							Thread.sleep(1000);
							a1.setVisible(true);
							Thread.sleep(1000);
							a1.setVisible(false);
							Thread.sleep(1000);
							a1.setVisible(true);
							lab.setVisible(true);
							clear();
							
							String query = "insert into cloudfiles values('"+oname+"','" +fname+ "','" +sk+ "','"+h1+"','"+h2+"','"+h3+"','"+h4+"','"+h5+"','"+tym+"')";	
							stmt.executeUpdate(query);
				
	
							PrintStream out99 = null;
							try {
							    out99 = new PrintStream(new FileOutputStream("CloudServer\\"+fname+".txt"));
							    out99.print(ct);
							    
							    
							}
							finally {
							    if (out99 != null) out99.close();
							}
							
							PrintStream out = null;
							try {
							    out = new PrintStream(new FileOutputStream("CloudServer\\"+fname+"1"+".txt"));
							    out.print(sp1);
							    
							    
							}
							finally {
							    if (out != null) out.close();
							}
							
							PrintStream out1 = null;
							try {
							    out1 = new PrintStream(new FileOutputStream("CloudServer\\"+fname+"2"+".txt"));
							    out1.print(sp2);
							    
							}
							finally {
							    if (out1 != null) out1.close();
							}
							
							PrintStream out2 = null;
							try {
							    out2 = new PrintStream(new FileOutputStream("CloudServer\\"+fname+"3"+".txt"));
							    out2.print(sp3);
							    
							}
							finally {
							    if (out2 != null) out2.close();
							}
							
							
							PrintStream out3 = null;
							try {
							    out3 = new PrintStream(new FileOutputStream("CloudServer\\"+fname+"4"+".txt"));
							    out3.print(sp4);
							    
							}
							finally {
							    if (out3 != null) out3.close();
							}
							
							PrintStream out4 = null;
							try {
							    out4 = new PrintStream(new FileOutputStream("CloudServer\\"+fname+"5"+".txt"));
							    out4.print(sp5);
							    
							}
							finally {
							    if (out4 != null) out4.close();
							}
							
							
							
							
							JOptionPane.showMessageDialog(null, "Data Uploaded Successfully");
						
					}
				} catch (Exception e23) {
					e23.printStackTrace();
				}
			} 
		
						if(this.port==4545)
						{
					
							try
							{
								ServerSocket server909 = new ServerSocket(4545);
								Socket con777;
								while (true) 
								{
								con777 = server909.accept();
								
								DataInputStream dis = new DataInputStream(con777.getInputStream());
								
								String email	= dis.readUTF();
								String name	= dis.readUTF();
								String pass	= dis.readUTF();
								String age	= dis.readUTF();
								String gender	= dis.readUTF();
								String country	= dis.readUTF();
								
								ResultSet r1=connect.createStatement().executeQuery("insert into register values('"+email+"','"+name+"','"+pass+"','"+age+"','"+gender+"','"+country+"')");
								
								if(r1.next()==true)
								{
									DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
									dos1.writeUTF("reg");
								}
								
								}
							}catch (Exception e) {
								
							}
						}	
		 if(this.port==7373)
			{
				try
				{
					ServerSocket server909 = new ServerSocket(7373);
					Socket con777;
					while (true) 
					{
					con777 = server909.accept();
					
					DataInputStream dis = new DataInputStream(con777.getInputStream());
					
					String user	= dis.readUTF();
					String pass	= dis.readUTF();
					ResultSet r1=connect.createStatement().executeQuery("select * from register where name='"+user+"' and password='"+pass+"'");
					
					if(r1.next()==true)
					{
						DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
						dos1.writeUTF("yes");
					}
					
					}
				}catch (Exception e) {
					
				}
			}	

		 
		 if(this.port==3434)
			{
		
				try
				{
					ServerSocket server909 = new ServerSocket(3434);
					Socket con777;
					while (true) 
					{
					con777 = server909.accept();
					
					DataInputStream dis = new DataInputStream(con777.getInputStream());
					
					String file	= dis.readUTF();
					
					
					ResultSet r1=connect.createStatement().executeQuery("select * from cloudfiles where filename='"+file+"'");
					
					if(r1.next()==true)
					{
						String k= r1.getString(3);
						
						DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
						
						dos1.writeUTF("key");
						dos1.writeUTF(k);
						
					}
					if(r1.next()==false)
					{
						DataOutputStream dos1 = new DataOutputStream(con777.getOutputStream());
						dos1.writeUTF("no");
						dos1.writeUTF("no");
						
					}
					
					}
				}catch (Exception e) {
					
				}
			}
		 if(this.port==9988)
			{

				try
				{
					ServerSocket server909 = new ServerSocket(9988);
					Socket con777;
					while (true) 
					{
					con777 = server909.accept();
					
					DataInputStream dis = new DataInputStream(con777.getInputStream());
					
					String user	= dis.readUTF();
					String file = dis.readUTF();
					String sk	= dis.readUTF();
					ResultSet r1=connect.createStatement().executeQuery("select * from cloudfiles where filename='"+file+"' and secretkey='"+sk+"'");
					
					if(r1.next()==true)
					{
						String cname = "CloudServer\\";
						MergeFile mf = new MergeFile();
						mf.mergeFiles(file, cname);
						
						FileInputStream fs = new FileInputStream("CloudServer\\" + file + "x.txt");
						byte bs1[] = new byte[fs.available()];
						fs.read(bs1);
						String content = new String(bs1);
					 
						  DataOutputStream  ds = new DataOutputStream(con777.getOutputStream());
							AES a = new AES();
							
						   ds.writeUTF(a.decrypt(content, keyWord));
						   ds.writeUTF("success");
						
						
					}
					else
					{
						DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
					       //get current date time with Date()
					       Date date = new Date();
					       
					       String dt=dateFormat.format(date);
						
						String qry="insert into Attacker values('"+file+"','"+user+"','"+sk+"','"+dt+"')";
						Statement st = connect.createStatement();
						int a=st.executeUpdate(qry);
						System.out.println(a);
						
						DataOutputStream  ds = new DataOutputStream(con777.getOutputStream());
						
						   ds.writeUTF("no");
						   ds.writeUTF("no");
					}
					
					}
				}catch (Exception e) {
					
				}
			}	
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

		 void clear() throws InterruptedException {
			
			Thread.sleep(2000);
			a1.setIcon(c1);
			c2 = new ImageIcon(this.getClass().getResource("images/cloud4.png"));
			a2.setIcon(c2);
			a3.setIcon(c3);
			
			lab.setVisible(false);
			
		}
	}
	}
	
