import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class AvailableBooks extends JFrame implements ActionListener {
	JFrame frm;
	JPanel panel;
	JTable bookList;
	DefaultTableModel dtm;
	Connect connect = new Connect();
	JScrollPane j;
	JScrollPane k;
	public AvailableBooks(){
		frm = new JFrame();
		frm.pack();
		frm.setLocationRelativeTo(null);
		frm.setSize(1000,700);
		frm.setTitle("List of books in the library");
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		frm.setVisible(true);		
	}
	
	public void queryBook() {
		try {
			connect.searchBook(Main.tfSearch.getText());
			bookList = new JTable();
			bookList.setModel(DbUtils.resultSetToTableModel(connect.rs));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		bookList.setShowGrid(true);
		bookList.setShowVerticalLines(true);
		j = new JScrollPane(bookList);
		j.setPreferredSize(new Dimension(950,600));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.add(j);
		//panel.setBorder(new EmptyBorder(20,20,10,20));
		frm.add(panel);
	}
	
	public void showAllBooks() {
		try {
			connect.showAll();
			bookList = new JTable();
			bookList.setModel(DbUtils.resultSetToTableModel(connect.rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bookList.setShowGrid(true);
		bookList.setShowVerticalLines(true);
		j = new JScrollPane(bookList);
		j.setPreferredSize(new Dimension(950,600));
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800,600));
		panel.add(j);
		frm.add(panel);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
