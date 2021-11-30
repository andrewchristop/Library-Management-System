import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
public class AllUsers extends JFrame{
	JFrame frm;
	JPanel panel;
	JTable userList;
	JScrollPane j;
	Connect c = new Connect();
	
	public AllUsers(){
		frm = new JFrame();
		frm.pack();
		frm.setLocationRelativeTo(null);
		frm.setSize(1000,700);
		frm.setTitle("List of all users in the library");
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			c.showAllUsers();
			userList = new JTable();
			userList.setModel(DbUtils.resultSetToTableModel(c.rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		userList.setShowGrid(true);
		userList.setShowVerticalLines(true);
		j = new JScrollPane(userList);
		j.setPreferredSize(new Dimension(950,600));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(850,600));
		panel.add(j);
		
		
		frm.add(panel);
		frm.setVisible(true);	
	}
	
}
