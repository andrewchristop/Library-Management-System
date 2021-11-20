import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Window;
import java.beans.PropertyVetoException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main extends JFrame implements ActionListener, MouseListener {
	JPanel query;
	JLabel search;
	static JTextField tfSearch;
	JButton searchBook;
	//Connect connect = new Connect();
	public Main(){
		
		JFrame frm = new JFrame();
		frm.pack();
		frm.setLocationRelativeTo(null);
        frm.setSize(300,100);
        frm.setTitle("Search for a book");
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setResizable(false);
        
        query = new JPanel();
        search = new JLabel("Enter a book to search");
        //query.setBorder(new EmptyBorder(0,20,0,20));
        query.add(search);
        
        tfSearch = new JTextField();
        tfSearch.setPreferredSize(new Dimension(200,24));
        query.add(tfSearch);
        searchBook = new JButton("Search");
        query.add(searchBook);
        searchBook.addActionListener(this);
        
        frm.getContentPane().add(query);

        frm.setVisible(true);        
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchBook)) {
			if(tfSearch.getText().equals("")) {
				String err = "Please enter a book to search";
				JOptionPane.showMessageDialog(null,err);
			}else {
				AvailableBooks a1 = new AvailableBooks();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
