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
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class NetworkManager extends JFrame implements ActionListener {

	Container c;
	JFrame f;
	ImageIcon i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	MenuBar mbr;
	Menu file;
	MenuItem item,item1,item2;
	
	public NetworkManager()
	{
		
		setBackground(Color.white);
		
		f=new JFrame();
		c=f.getContentPane();
		c.setLayout(null);
		f.setTitle("Network Manager :: Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		
		
		mbr = new MenuBar();
		file = new Menu("Menu");
		item = new MenuItem("Network Manager");
		item1 = new MenuItem("K-OUT-N");
		item2 = new MenuItem("Add Data Creator");
		
		file.add(item2);
		file.add(item);
		file.add(item1);
		
		mbr.add(file);
		f.setMenuBar(mbr);
		
		item.addActionListener(this);
		item1.addActionListener(this);
		item2.addActionListener(this);
		
		ImageIcon background = new ImageIcon(this.getClass().getResource("images/background.png"));
		JLabel back = new JLabel();
		back.setIcon(background);
		back.setBounds(-10, -55, 700, 600);
		
		
		i1 = new ImageIcon(this.getClass().getResource("images/topo.png"));
		l1 = new JLabel();
		l1.setIcon(i1);
		l1.setBounds(125, 300, 200, 200);
		c.add(l1);
		
		i2 = new ImageIcon(this.getClass().getResource("images/time.png"));
		l2 = new JLabel();
		l2.setIcon(i2);
		l2.setBounds(395, 350, 400, 100);
		c.add(l2);
		
		i3 = new ImageIcon(this.getClass().getResource("images/fail.png"));
		l3 = new JLabel();
		l3.setIcon(i3);
		l3.setBounds(395, 270, 250, 100);
		c.add(l3);
		
		i4 = new ImageIcon(this.getClass().getResource("images/kn.png"));
		l4 = new JLabel();
		l4.setIcon(i4);
		l4.setBounds(395, 430, 250, 100);
		c.add(l4);
		
		i5 = new ImageIcon(this.getClass().getResource("images/arrow1.png"));
		l5 = new JLabel();
		l5.setIcon(i5);
		l5.setBounds(285, 275, 100, 100);
		c.add(l5);
		
		i6 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
		l6 = new JLabel();
		l6.setIcon(i6);
		l6.setBounds(450, 315, 100, 100);
		c.add(l6);
		
		i7 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
		l7 = new JLabel();
		l7.setIcon(i7);
		l7.setBounds(450, 395, 100, 100);
		c.add(l7);
		
		
		i8 = new ImageIcon(this.getClass().getResource("images/csb.png"));
		l8 = new JLabel();
		l8.setIcon(i8);
		l8.setBounds(235, 40, 200, 100);
		c.add(l8);
		
		
		i9 = new ImageIcon(this.getClass().getResource("images/kn.png"));
		l9 = new JLabel();
		l9.setIcon(i9);
		l9.setBounds(260, 160, 200, 100);
		c.add(l9);
		
		
		i10 = new ImageIcon(this.getClass().getResource("images/upb.png"));
		l10 = new JLabel();
		l10.setIcon(i10);
		l10.setBounds(160, 195, 100, 100);
		c.add(l10);
		
		
		i11 = new ImageIcon(this.getClass().getResource("images/up1b.png"));
		l11 = new JLabel();
		l11.setIcon(i11);
		l11.setBounds(315, 85, 200, 150);
		c.add(l11);
		
		c.add(back);
		f.setSize(700,600);
		f.show();
		
		
		int [] ports = new int[]{ 2323,6666};

		for (int i = 0; i < 2; i++)
		{
			Thread t = new Thread(new PortListener(ports[i]));
			t.setName("Listener-" + ports[i]);
			t.start();

		}
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
		void display() throws InterruptedException
		{
		Thread.sleep(1000);
		
		i1 = new ImageIcon(this.getClass().getResource("images/topo.png"));
		l1.setIcon(i1);
		
		i2 = new ImageIcon(this.getClass().getResource("images/time.png"));
		l2.setIcon(i2);
		
		i3 = new ImageIcon(this.getClass().getResource("images/fail.png"));
		l3.setIcon(i3);
		
		i4 = new ImageIcon(this.getClass().getResource("images/kn.png"));
		l4.setIcon(i4);
		
		i5 = new ImageIcon(this.getClass().getResource("images/arrow1.png"));
		l5.setIcon(i5);
		
		i6 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
		l6.setIcon(i6);
		
		i7 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
		l7.setIcon(i7);
		
		i8 = new ImageIcon(this.getClass().getResource("images/csb.png"));
		l8.setIcon(i8);
		
		i9 = new ImageIcon(this.getClass().getResource("images/kn.png"));
		l9.setIcon(i9);
		
		i10 = new ImageIcon(this.getClass().getResource("images/upb.png"));
		l10.setIcon(i10);
		
		
		i11 = new ImageIcon(this.getClass().getResource("images/up1b.png"));
		l11.setIcon(i11);
		}
		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{
			if(this.port==2323)
			{
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
				Statement stmt = null;
				String n1="mn1",n2="mn2",n3="mn3",n4="mn4",n5="mn5",n6="mn6",n7="mn7";
				String dis1="",dis2="",dis3="",dis4="",dis5="",dis6="",dis7="";
				String e1="",e2="",e3="",e4="",e5="",e6="",e7="";
				String oname,filename,sk,ct;
				String sp1,sp2,sp3,sp4,sp5;
				String h1,h2,h3,h4,h5;
				String tym;
				
				
				try
				{
					
				
					ServerSocket server909 = new ServerSocket(2323);
					Socket con777;
					while (true) 
					{
						con777 = server909.accept();
//						System.out.println("connect with cs");
						
						DataInputStream dis = new DataInputStream(con777.getInputStream());
						
						oname	= dis.readUTF();
						filename	= dis.readUTF();
						sk= dis.readUTF();
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
					
						Thread.sleep(2000);
						i1 = new ImageIcon(this.getClass().getResource("images/topog.png"));
						l1.setIcon(i1);
						
						
						Thread.sleep(2000);
						i10 = new ImageIcon(this.getClass().getResource("images/upg.png"));
						l10.setIcon(i10);

						//////////////////////////////////////////////////////////////
						
						Statement stmt1=connect.createStatement();
						ResultSet rs = stmt1.executeQuery("select * from koutn where dataowner='"+oname+"'");
						int s =0;
						int s1 =0;
						String s2 = null;
						DataOutputStream dos2 = new DataOutputStream(con777.getOutputStream());
						
						if(rs.next())
						{
							s =Integer.parseInt( rs.getString(2));
							s1 = Integer.parseInt(rs.getString(3));
							s2 =rs.getString(1);
							
						}
						if(s<=s1)
						{
							Thread.sleep(2000);
							i9 = new ImageIcon(this.getClass().getResource("images/knr.png"));
							l9.setIcon(i9);
							
							Thread.sleep(2000);
							i11 = new ImageIcon(this.getClass().getResource("images/up1r.png"));
							l11.setIcon(i11);
							
							Thread.sleep(2000);
							i8 = new ImageIcon(this.getClass().getResource("images/csr.png"));
							l8.setIcon(i8);
						
							dos2.writeUTF("yes");
							
							display();
						}
						else if(s>=s1)
						{
							Thread.sleep(2000);
							i9 = new ImageIcon(this.getClass().getResource("images/kng.png"));
							l9.setIcon(i9);
							
							Thread.sleep(2000);
							i11 = new ImageIcon(this.getClass().getResource("images/up1g.png"));
							l11.setIcon(i11);
							
							Thread.sleep(2000);
							i8 = new ImageIcon(this.getClass().getResource("images/csg.png"));
							l8.setIcon(i8);
							
							
						
							
							dos2.writeUTF("no");
							
							display();
						}
						
						ResultSet rs1 = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
						
						String koutn=null;
						int lenght=ct.length();
						
						if(rs1.next())
						{
							koutn=rs1.getString(3);
						}
						String length=String.valueOf(lenght);
						
						connect.createStatement().executeUpdate("insert into networkmanager values('"+filename+"','"+oname+"','"+length+"','"+n7+"','"+koutn+"','"+tym+"')");
						
						
						// increment the task and update in the table
						
						ResultSet rs11 = connect.createStatement().executeQuery("select * from koutn where dataowner='"+oname+"'");
						int s8 = 0;
						
						while(rs11.next())
						{
							s8 = Integer.parseInt(rs11.getString(3));
						}
						
						int s4 = s8+1;
						connect.createStatement().executeUpdate("update koutn set taskcompleted='"+s4+"' where dataowner='"+oname+"'");
						
						Socket client = new Socket("localhost",2424);
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
						
						Thread.sleep(1000);
						
						i1 = new ImageIcon(this.getClass().getResource("images/topo.png"));
						l1.setIcon(i1);
						
						i2 = new ImageIcon(this.getClass().getResource("images/time.png"));
						l2.setIcon(i2);
						
						i3 = new ImageIcon(this.getClass().getResource("images/fail.png"));
						l3.setIcon(i3);
						
						i4 = new ImageIcon(this.getClass().getResource("images/kn.png"));
						l4.setIcon(i4);
						
						i5 = new ImageIcon(this.getClass().getResource("images/arrow1.png"));
						l5.setIcon(i5);
						
						i6 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
						l6.setIcon(i6);
						
						i7 = new ImageIcon(this.getClass().getResource("images/arrow2.png"));
						l7.setIcon(i7);
						
						i8 = new ImageIcon(this.getClass().getResource("images/csb.png"));
						l8.setIcon(i8);
						
						i9 = new ImageIcon(this.getClass().getResource("images/kn.png"));
						l9.setIcon(i9);
						
						i10 = new ImageIcon(this.getClass().getResource("images/upb.png"));
						l10.setIcon(i10);
						
						
						i11 = new ImageIcon(this.getClass().getResource("images/up1b.png"));
						l11.setIcon(i11);
						
					
						
						
					}
				}catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			if(this.port==6666)
			{
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
				
		try
				{
					
					ServerSocket server909 = new ServerSocket(6666);
					Socket con777;
					while (true) 
					{
						
						con777 = server909.accept();
						DataInputStream dis = new DataInputStream(con777.getInputStream());
						
						String nodename = dis.readUTF();
						String oname =dis.readUTF();
						
						Thread.sleep(2000);
						i1 = new ImageIcon(this.getClass().getResource("images/topog.png"));
						l1.setIcon(i1);
						
						Thread.sleep(2000);
						i5 = new ImageIcon(this.getClass().getResource("images/arrow1g.png"));
						l5.setIcon(i5);
						
						Thread.sleep(2000);
						i3 = new ImageIcon(this.getClass().getResource("images/failr.png"));
						l3.setIcon(i3);
						
						Thread.sleep(2000);
						i6 = new ImageIcon(this.getClass().getResource("images/arrow2r.png"));
						l6.setIcon(i6);
						
						Thread.sleep(2000);
						i2 = new ImageIcon(this.getClass().getResource("images/timer.png"));
						l2.setIcon(i2);
						
						Thread.sleep(2000);
						i7 = new ImageIcon(this.getClass().getResource("images/arrow2r.png"));
						l7.setIcon(i7);
						
						
//////////////////////////////////////////////////////////////
						
						Statement stmt=connect.createStatement();
						ResultSet rs = stmt.executeQuery("select * from koutn where dataowner='"+oname+"'");
						int s = 0;
						int s1 =0;
						String s2 = null;
						DataOutputStream dos = new DataOutputStream(con777.getOutputStream());
						
						if(rs.next())
						{
							s =Integer.parseInt( rs.getString(2));
							s1 = Integer.parseInt(rs.getString(3));
							s2 =rs.getString(1);
							
							
							
						}
						if( s<=s1)
						{
							Thread.sleep(2000);
							i4 = new ImageIcon(this.getClass().getResource("images/knr.png"));
							l4.setIcon(i4);
							
							
							dos.writeUTF("yes");
						}
						else if( s>=s1)
						{
							Thread.sleep(2000);
							i4 = new ImageIcon(this.getClass().getResource("images/kng.png"));
							l4.setIcon(i4);
							
							dos.writeUTF("no");
						}
						
/////////////////////////////////////////////////	

						display();
						
					}
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
			/*if(this.port==6789)
			{
				Dbcon db=new Dbcon();
				Connection connect=db.getConnection();
		try
				{
					ServerSocket server909 = new ServerSocket(6789);
					Socket con777;
					while (true) 
					{
						con777 = server909.accept();
						
						
						DataInputStream dis = new DataInputStream(con777.getInputStream());
						
						String a = dis.readUTF();
						
						Thread.sleep(2000);
						i1 = new ImageIcon(this.getClass().getResource("images/topog.png"));
						l1.setIcon(i1);
						
						Thread.sleep(2000);
						i10 = new ImageIcon(this.getClass().getResource("images/upg.png"));
						l10.setIcon(i10);
						
						Thread.sleep(2000);
						i9 = new ImageIcon(this.getClass().getResource("images/knr.png"));
						l9.setIcon(i9);
						
						Thread.sleep(2000);
						i11 = new ImageIcon(this.getClass().getResource("images/up1r.png"));
						l11.setIcon(i11);
						
						Thread.sleep(2000);
						i8 = new ImageIcon(this.getClass().getResource("images/csr.png"));
						l8.setIcon(i8);
						
						DataOutputStream dos = new DataOutputStream(con777.getOutputStream());
						dos.writeUTF("node5");
						
						display();
						
						
						
					}
		}catch (Exception e) {
			// TODO: handle exception
		}
		}*/
			
	}

}


	public static void main(String[] args) {
		
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NetworkManager();
			}
		});
		
	}


	@Override
	public void actionPerformed(ActionEvent a) {

			if (a.getSource() == item2) {
			
			try{
				Dbcon db=new Dbcon();
				Connection con = db.getConnection();
				Statement stmt = con.createStatement();
				
				String owner = JOptionPane.showInputDialog(null, "Enter Data Creator");
				String assign = JOptionPane.showInputDialog(null, "Enter Number Of Tasks");
				
				int task=0;
				String query = "insert into koutn values('"+owner+"','" +assign+ "','" +task+ "')";	
				stmt.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Tasks Assigned Successfully");
				
				}catch (Exception e5) {
					// TODO: handle exception
				}
			}
			
		if(a.getSource()==item)
		{
			ViewMobile v = new ViewMobile();
			v.setSize(500, 500);
			v.setVisible(true);
			
		}
		if(a.getSource()==item1)
		{
			ViewKoutn v1 = new ViewKoutn();
			v1.setSize(500, 500);
			v1.setVisible(true);
			
		}
		
	}


}
