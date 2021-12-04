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
	JPanel ry;
	JLabel search;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JTextField idShw;
	JTextField usernameShw;
	JTextField privShw;
	JTextField posShw;
	static JTextField tfSearch;
	JButton searchBook;
	JButton showAllBooks;
	JButton adminPanel;
	JButton showAcctInfo;
	JButton ok;
	JFrame w;
	String pos;
	//Connect connect = new Connect();
	public Main(){
		
		JFrame frm = new JFrame();
		frm.pack();
		frm.setLocationRelativeTo(null);
        frm.setSize(300,155);
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
        
        showAllBooks = new JButton("Show All Books");
        query.add(showAllBooks);
        showAllBooks.addActionListener(this);
        
        adminPanel = new JButton("Admin Panel");
        query.add(adminPanel);
        adminPanel.addActionListener(this);
        
        showAcctInfo = new JButton("Show Account Info");
        query.add(showAcctInfo);
        showAcctInfo.addActionListener(this);
        
        
        frm.getContentPane().add(query);

        frm.setVisible(true);        
        
	}
	
	public void showUserInfo() {
		w = new JFrame();
		w.pack();
		w.setLocationRelativeTo(null);
        w.setSize(280,195);
        w.setTitle("User Account Info");
        w.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        w.setResizable(false);
        
        ry = new JPanel();
        lbl1 = new JLabel("ID");
        idShw = new JTextField();
        idShw.setPreferredSize(new Dimension(200,24));
        lbl2 = new JLabel("Username");
        usernameShw = new JTextField();
        usernameShw.setPreferredSize(new Dimension(200,24));
        lbl3 = new JLabel("Privilege");
        privShw = new JTextField();
        privShw.setPreferredSize(new Dimension(200,24));
        JLabel lbl4 = new JLabel("Position");
        posShw = new JTextField();
        posShw.setPreferredSize(new Dimension(200,24));
        
        ok = new JButton("OK");
        ok.addActionListener(this);
        
        
        
        ry.add(lbl1);
        ry.add(idShw);
        ry.add(lbl2);
        ry.add(usernameShw);
        ry.add(lbl3);
        ry.add(privShw);
        ry.add(lbl4);
        ry.add(posShw);
        ry.add(ok);
        
        idShw.setText(User.id);
        usernameShw.setText(User.username);
        privShw.setText(User.privilege);
        w.getContentPane().add(ry);
        
        if(Login.privilege.equals("0")) {
        	Customer cust = new Customer();
        	pos = cust.showInfo();
        	posShw.setText(pos);
        }
        
        if(Login.privilege.equals("1")) {
        	Librarian librarian = new Librarian();
        	pos = librarian.showInfo();
        	posShw.setText(pos);
        }
        
        if(Login.privilege.equals("2")) {
        	Admin admin = new Admin();
        	pos = admin.showInfo();
        	posShw.setText(pos);
        }
        
        w.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchBook)) {
			if(tfSearch.getText().equals("")) {
				String err = "Please enter a book to search";
				JOptionPane.showMessageDialog(null,err);
			}else {
				AvailableBooks a1 = new AvailableBooks();
				a1.queryBook();
			}
		}
		
		if(e.getSource().equals(showAllBooks)) {
			//System.out.println("Btn input detected");
			AvailableBooks a = new AvailableBooks();
			a.showAllBooks();
		}
		
		if(e.getSource().equals(adminPanel)) {
			if(Login.privilege.equals("0")) {
				String err = "Insufficient Privileges! Only Admins/Employees can access the admin panel!";
				JOptionPane.showMessageDialog(null, err);
			}else {
				AdminPanel a = new AdminPanel();
			}
//			System.out.println("action recorded");
		}
		
		if(e.getSource().equals(showAcctInfo)) {
			showUserInfo();
		}
		
		if(e.getSource().equals(ok)) {
			w.dispose();
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
