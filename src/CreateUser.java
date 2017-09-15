import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import com.Location.Mail;

public class CreateUser implements ActionListener {
	JFrame jf;
	Container c;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8;
	JButton b1, b2;
	JTextArea ta;
	Object scheme;
	String selItem;
	JLabel label = new JLabel("You are registering....");	JComboBox jb;

	CreateUser() {
		jf = new JFrame("New User Registration::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		c = jf.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.RED);

		ta = new JTextArea();
		ta.setRows(100);
		ta.setColumns(100);

		l1 = new JLabel();
		l1.setText("Email-Id");
		l1.setForeground(Color.WHITE);
		

		t1 = new JTextField(10);
		//l1.setForeground(Color.DARK_GRAY);

		ta.setBounds(335, 80, 150, 120);
		ta.setBackground(Color.WHITE);

		l2 = new JLabel();
		l2.setText("Name");
		l2.setForeground(Color.WHITE);

		t2 = new JTextField(10);

		l3 = new JLabel();
		l3.setText("Password");
		l3.setForeground(Color.WHITE);

		t3 = new JPasswordField(10);
		((JPasswordField) t3).setEchoChar('*');

		l4 = new JLabel();
		l4.setText("Age");
		l4.setForeground(Color.WHITE);

		t4 = new JTextField(10);

		JLabel ll1 = new JLabel("Gender");
		ll1.setBounds(50, 280, 150, 25);
		ll1.setForeground(Color.WHITE);

		t5 = new JTextField(10);

		l6 = new JLabel();
		l6.setText("Country");
		l6.setForeground(Color.WHITE);

		t6 = new JTextField(10);


		b1 = new JButton("OK");
		b2 = new JButton("Reset");

		l1.setBounds(50, 80, 150, 25);
		t1.setBounds(150, 80, 180, 25);

		l2.setBounds(50, 130, 150, 25);
		t2.setBounds(150, 130, 180, 25);

		l3.setBounds(50, 180, 150, 25);
		t3.setBounds(150, 180, 180, 25);

		l4.setBounds(50, 230, 150, 25);
		t4.setBounds(150, 230, 180, 25);
		
		t5.setBounds(150, 280, 180, 25);

		l6.setBounds(50, 330, 150, 25);
		t6.setBounds(150, 330, 180, 25);

		b1.setBounds(150, 410, 80, 25);
		b2.setBounds(250, 410, 80, 25);

		b1.addActionListener(this);
		b2.addActionListener(this);

		c.add(l1);
		c.add(ll1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l6);
		c.add(t1);
		c.add(t2);
		c.add(t3);
		c.add(t4);
		c.add(t5);
		c.add(t6);
		c.add(b1);
		c.add(b2);
		// c.add(ta);
		// c.add(l7);
		jf.show();
		jf.setSize(400, 500);
	}

	// public void itemStateChanged(ItemEvent ie)
	// {
	// scheme = ie.getItem();
	// selItem = String.valueOf(scheme);
	// }

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == b1) {

			String email = t1.getText();
			String name = t2.getText();
			String pwd = t3.getText();
			String age = t4.getText();
			String gender = t5.getText();
			String country = t6.getText();

			if (email.equals("") || name.equals("") || pwd.equals("")|| age.equals("") || gender.equals("")|| country.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Fields cannot be empty");
			} else {
				
				String ipd=JOptionPane.showInputDialog(" Enter Cloud server IP address");
				
				try
				{
					Socket soc = new Socket(ipd,4545);
					DataOutputStream dos1 = new DataOutputStream(soc.getOutputStream());
					dos1.writeUTF(email);
					dos1.writeUTF(name);
					dos1.writeUTF(pwd);
					dos1.writeUTF(age);
					dos1.writeUTF(gender);
					dos1.writeUTF(country);
					
					System.out.println("User details sent to cloud server");
					
//					DataInputStream dis = new DataInputStream(soc.getInputStream());
//					String r = dis.readUTF();
					
					JOptionPane.showMessageDialog(null, "Registered Successfully");
					
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}			
			}

			if (event.getSource() == b2) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");

			}
		}
	}

	public static void main(String[] args) {
		new CreateUser();
	}

}