import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class DataOwner implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b1, b2, b3, b4, b5, b6,b2m;
	JScrollPane sp;
	JTextArea ta;
	JTextField t1, t2, t3;
	MenuBar mbr;
	Menu file;
	MenuItem item;
	Border b11, b22, b33;
	File path;
	JComboBox jb;
	Object type;
	String selItem;
	Cipher encoder;
	Key prKey;
	int rank;
	JLabel ownername;
	JTextField ownertext;
	
	public static Key pubKey;
	public Font f = new Font("Times new roman", Font.BOLD, 16);
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";

	DataOwner(String name,int s3) {
		jf = new JFrame("Data Owner::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(188, 100, 100));
		
		JOptionPane.showMessageDialog(null, "Remaining Tasks for Owner " +name+ "=" +s3);
		
		ownername = new JLabel("Owner Name");
		ownername.setFont(f);
		ownername.setBounds(50, 195, 120, 30);
		c.add(ownername);
		
		ownertext = new JTextField();
		ownertext.setBounds(170, 195, 120, 30);
		ownertext.setFont(f);
		ownertext.setText(name);
		c.add(ownertext);
		
		ImageIcon m = new ImageIcon("images/ss.jpg");
		l9 = new JLabel();
		l9.setIcon(m);
	
		l9.setBounds(35, 65, 700, 450);

		Border b11 = BorderFactory.createBevelBorder(0);
		l1 = new JLabel();
		l1.setBorder(b11);
		l1.setBounds(35, 165, 700, 350);

		Border b22 = BorderFactory.createBevelBorder(0);
		l2 = new JLabel();
		l2.setBorder(b22);
		

		ImageIcon banner = new ImageIcon(this.getClass().getResource("images/owner.png"));
		JLabel title = new JLabel();
		title.setIcon(banner);
		title.setBounds(0, 0, 950, 500);

		mbr = new MenuBar();
		file = new Menu("File");
		item = new MenuItem("New User");
		file.add(item);
		
		jf.setMenuBar(mbr);

		ta = new JTextArea();
		ta.setColumns(100);
		ta.setRows(100);

		sp = new JScrollPane();
		sp.setViewportView(ta);
		sp.setBounds(375, 185, 315, 250);

		b1 = new JButton("Browse");
		b2 = new JButton("Upload File ");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b2.setBackground(Color.CYAN);
		
		b1.setBackground(Color.CYAN);
		
		item.addActionListener(this);

		b1.setBounds(50, 280, 120, 30);
		b2.setBounds(50, 350, 120, 30);

		c.add(sp);
		c.add(l1);
		
		c.add(l2);
		c.add(b1);
		c.add(b2);

		c.add(title);
		jf.setSize(950,535);
		jf.show();
		
	}
	public void actionPerformed(ActionEvent e) {
		String strline = "";
		Object o = e.getSource();
		if (o == item) {

			// user.setSize
		}
		if (o == b1) {
			JFileChooser chooser = new JFileChooser("Database");
			try {
				File f = new File(new File("filename.txt").getCanonicalPath());
				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			int retval = chooser.showOpenDialog(b1);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				
				path = chooser.getSelectedFile();
			}

			File curFile = chooser.getSelectedFile();
			try {
				FileInputStream fstream = new FileInputStream(curFile);
				DataInputStream ins = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));
				StringBuffer buffer = new StringBuffer();

				while ((strline = br.readLine()) != null) {
//					System.out.println(strline);
					buffer.append(strline + "\n");
				}
				ta.setText(buffer.toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if (o == b2) {
			try {
			String oname = ownertext.getText(); 
			Dbcon db = new Dbcon();
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from koutn where dataowner='"+oname+"'");
			String s = null;
			String s1 = null;
			String s2 = null;
			
			while(rs.next())
			{
				s = rs.getString(2);
				s1 = rs.getString(3);
				s2 =rs.getString(1);
			}
			if(oname.equalsIgnoreCase("") || !(oname.equalsIgnoreCase(s2)))
			{
				JOptionPane.showMessageDialog(null, "Enter Correct Owner Name");
			}
			
			else{
			long start=System.currentTimeMillis();

			String fname = JOptionPane.showInputDialog(null,"Enter the file name");
			String ip = JOptionPane.showInputDialog(null,"Enter Cloud Server Ip Address");
			
				AES enc = new AES();

				KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
				encoder = Cipher.getInstance("RSA");
				KeyPair kp = kg.generateKeyPair();

				prKey = kp.getPrivate();
				pubKey = kp.getPublic();

				byte[] pub = pubKey.getEncoded();
//				System.out.println("PUBLIC KEY" + pub);
		
				String pk = String.valueOf(pub);

				KeyGenerator2 k = new KeyGenerator2();
				String secretkey = String.valueOf(k.getKeys());
				
				FileInputStream fis = new FileInputStream(path);
				byte b[] = new byte[fis.available()];
				fis.read(b);
				String cont = new String(b);
//				System.out.println("Contents are:" + "\t" + cont);
//				System.out.println(b);

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connect1 =  DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq=src\\Database.mdb");
				
				
				AES a1=new AES();
				String content=a1.encrypt(cont,  keyWord);
				
//				System.out.println(content);
				
					PrintStream out = null;
					try {
					    out = new PrintStream(new FileOutputStream("Owner\\"+fname));
					    out.print(content);
					}
					finally {
					    if (out != null) out.close();
					}
					
//					JOptionPane.showMessageDialog(null,"File Uploaded SuccessFully");
					SplitFile sp = new SplitFile();
					sp.splitFile(new File("Owner\\"+fname),5, 1024);
					
					
//					System.out.println("FileNAME:"+fname);
					int len = fname.length();
					String fil = fname.substring(0, len-5);
//					System.out.println(fil);
					
//					System.out.println("File Splitted");
					
					
					MessageDigest md = MessageDigest.getInstance("SHA1");
//					System.out.println("Hellllllll");
					
					FileInputStream fis1 = new FileInputStream("Owner\\"+fil+"1"+".txt");
					byte	 bs1[] = new byte[fis1.available()];
					fis1.read(bs1);
					String split1 = new String(bs1);
					fis1.close();
					
					FileInputStream fis11 = new FileInputStream("Owner\\"+fil+"1"+".txt");
					DigestInputStream dis1 = new DigestInputStream(fis11, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
					String spl1 = bi1.toString();
					String	 h1 = bi1.toString(16);
//					System.out.println(h1);
					
					FileInputStream fis2 = new FileInputStream("Owner\\"+fil+"2"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs2[] = new byte[fis2.available()];
					fis2.read(bs2);
					String split2 = new String(bs2);
					FileInputStream fis22 = new FileInputStream("Owner\\"+fil+"2"+".txt");
					DigestInputStream dis2 = new DigestInputStream(fis22, md);
					BufferedInputStream bis2 = new BufferedInputStream(dis2);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b2 = bis2.read();
						if (b2 == -1)
							break;
					}
		 
					BigInteger bi2 = new BigInteger(md.digest());
					String  h2 = bi2.toString(16);
//					System.out.println(h2);
					
					
					FileInputStream fis3 = new FileInputStream("Owner\\"+fil+"3"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs3[] = new byte[fis3.available()];
					fis3.read(bs3);
					String split3 = new String(bs3);
					FileInputStream fis33 = new FileInputStream("Owner\\"+fil+"3"+".txt");
					DigestInputStream dis3 = new DigestInputStream(fis33, md);
					BufferedInputStream bis3 = new BufferedInputStream(dis3);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b3 = bis3.read();
						if (b3 == -1)
							break;
					}
		 
					BigInteger bi3 = new BigInteger(md.digest());
				String h3 = bi3.toString(16);
//					System.out.println(h3);
					
					
					
					
					
					
					FileInputStream fis4 = new FileInputStream("Owner\\"+fil+"4"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs4[] = new byte[fis4.available()];
					fis4.read(bs4);
					String split4 = new String(bs4);
					
					FileInputStream fis44 = new FileInputStream("Owner\\"+fil+"4"+".txt");
					DigestInputStream dis4 = new DigestInputStream(fis4, md);
					BufferedInputStream bis4 = new BufferedInputStream(dis4);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b4 = bis4.read();
						if (b4 == -1)
							break;
					}
		 
					BigInteger bi4 = new BigInteger(md.digest());
					String	 h4 = bi4.toString(16);
//					System.out.println(h4);
					
					
					
					FileInputStream fis5 = new FileInputStream("Owner\\"+fil+"5"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs5[] = new byte[fis5.available()];
					fis5.read(bs5);
					String split5 = new String(bs5);
					
					FileInputStream fis55 = new FileInputStream("Owner\\"+fil+"5"+".txt");
					DigestInputStream dis5 = new DigestInputStream(fis5, md);
					BufferedInputStream bis5 = new BufferedInputStream(dis5);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b5 = bis5.read();
						if (b5 == -1)
							break;
					}
		 
					BigInteger bi5 = new BigInteger(md.digest());
					String	h5 = bi5.toString(16);
//					System.out.println(h5);
					///
					
					
					
					DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				       //get current date time with Date()
				       Date date = new Date();
				       
				       String tym=dateFormat.format(date);
					
					
					
					String query = "insert into owner values('"+oname+"','"+fname+"','"+secretkey+"','"+h1+"','"+h2+"','"+h3+"','"+h4+"','"+h5+"','"+tym+"')";	
					stmt.executeUpdate(query);
				
				
					Socket client = new Socket(ip,12121);
					DataOutputStream dos = new DataOutputStream(client.getOutputStream());
					
					dos.writeUTF(oname);
					dos.writeUTF(fname);
					dos.writeUTF(secretkey);
					dos.writeUTF(content);
					
					dos.writeUTF(split1);
					dos.writeUTF(split2);
					dos.writeUTF(split3);
					dos.writeUTF(split4);
					dos.writeUTF(split5);
					dos.writeUTF(h1);
					dos.writeUTF(h2);
					dos.writeUTF(h3);
					dos.writeUTF(h4);
					dos.writeUTF(h5);
					dos.writeUTF(tym);
				
			}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
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
			}
		});
	}

}
