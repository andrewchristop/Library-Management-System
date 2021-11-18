import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class AvailableBooks extends JFrame implements ActionListener {
	JFrame frm;
	JPanel panel;
	JTable bookList;
	DefaultTableModel dtm;
	Connect connect = new Connect();
	JScrollPane j;
	public AvailableBooks(){
		frm = new JFrame();
		frm.pack();
		frm.setLocationRelativeTo(null);
		frm.setSize(1000,700);
		frm.setTitle("List of books in the library");
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
//		dtm = new DefaultTableModel(new String[] {"Book ID", "Book Name", "Genre", "Availability"},0);
		//connect.searchBook(getName());
		String[][] data  = new String[5][4];
		String[] col = {"Book ID", "Name", "Genre", "Availability"};
		int i =0;
		
		dtm = new DefaultTableModel(data, col);
		bookList = new JTable(dtm);
		bookList.setShowGrid(true);
		bookList.setShowVerticalLines(true);
		
//		panel = new JPanel();
//		frm.getContentPane().add(panel);
		j = new JScrollPane(bookList);
		frm.add(j);
		frm.setVisible(true);
				
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
