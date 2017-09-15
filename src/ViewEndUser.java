

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ViewEndUser extends JFrame

{

	JButton view;
	JScrollPane jsp;
	JTable table;
	int v, h;
	String s, d, call, dt;
	Container c;

	JLabel imglabel;

	ViewEndUser(){
		setTitle("End User Details::Energy Efficient Fault Tolerant Data Storage and Processing in Mobile Cloud");
		c = getContentPane();
		c.setLayout(new FlowLayout());

		v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;

		jsp = new JScrollPane();

		Vector heading = new Vector();
		heading.addElement("EMail");
		heading.addElement("Username");
		heading.addElement("Password");
		heading.addElement("Age");
		heading.addElement("Gender");
		heading.addElement("Country");
		
		Vector data = new Vector();

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connect =  DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq=src\\Database.mdb");
			Statement stmt = connect.createStatement();
			String query = "select * from register";//"SELECT * FROM CloudServer where order by rank DESC";
			ResultSet rs = stmt.executeQuery(query);

			ResultSetMetaData rsm = rs.getMetaData();
			int col = rsm.getColumnCount();

			while (rs.next()) {
				Vector row = new Vector();
				for (int i = 1; i <= col; i++) {
					row.addElement(rs.getObject(i));

				}

				data.addElement(row);
			}

			int vColIndex = 0;
			table = new JTable(data, heading);

			for (int i = 0; i < table.getColumnCount(); i++) {
				DefaultTableColumnModel colModel = (DefaultTableColumnModel) table
						.getColumnModel();
				TableColumn col12 = colModel.getColumn(i);
				int width = 0;

				TableCellRenderer renderer = col12.getHeaderRenderer();
				for (int r = 0; r < table.getRowCount(); r++) {
					renderer = table.getCellRenderer(r, i);
					Component comp = renderer.getTableCellRendererComponent(
							table, table.getValueAt(r, i), false, false, r, i);
					width = Math.max(width, comp.getPreferredSize().width);
				}
				col12.setPreferredWidth(width + 2);
			}

			table.setBackground(Color.green);
			table.setColumnSelectionAllowed(false);
			table.setCellSelectionEnabled(false);

			jsp = new JScrollPane(table, v, h);
			c.add("center", jsp);

			c.setBackground(Color.ORANGE);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}