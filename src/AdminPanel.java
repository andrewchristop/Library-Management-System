import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class AdminPanel extends JFrame implements ActionListener {
	JFrame frm;
	JFrame window;
	JFrame delBook;
	JFrame wAdd;
	JFrame wRemove;
	JTextField tf1;
	JTextField tf2;
	JTextField id;
	JTextField addUser;
	JPasswordField pwd;
	JRadioButton available;
	JRadioButton unavailable;
	JRadioButton librarian;
	JRadioButton user;
	JRadioButton admin;
	JPanel p;
	JPanel panel1;
	JLabel lbl;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel idRemove;
	JLabel username;
	JLabel password;
	JLabel adminPowers;
	JPanel p1;
	JPanel acct;
	JButton b1;
	JButton addBook;
	JButton btn;
	JButton deleteBook;
	JButton removeBook;
	JButton assignBook;
	JButton returnBook;
	JButton addAccount;
	JButton removeAccount;
	JButton acctAdd;
	ButtonGroup grp;
	ButtonGroup grp1;
	String name;
	String genre;
	String availability;
	String uName;
	String pass;
	String privilege;
	
	Connect c = new Connect();
	Connect c1 = new Connect();
	public AdminPanel() {
		frm = new JFrame();
		frm.pack();
		frm.setSize(500,300);
		frm.setTitle("Admin Panel");
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl = new JLabel("Admin Panel");
		lbl.setFont(new Font("Helvetica", Font.BOLD, 22));
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		addBook = new JButton("Add Book");
		addBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		addBook.addActionListener(this);
		removeBook = new JButton("Remove Book");
		removeBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeBook.addActionListener(this);
		assignBook = new JButton("Assign Book");
		assignBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		assignBook.addActionListener(this);
		returnBook = new JButton("Return Book");
		returnBook.setAlignmentX(Component.CENTER_ALIGNMENT);
		returnBook.addActionListener(this);
		addAccount = new JButton("Add Account");
		addAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		addAccount.addActionListener(this);
		removeAccount = new JButton("Remove Account");
		removeAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		removeAccount.addActionListener(this);
		
		p.add(lbl);
		p.add(addBook);
		p.add(removeBook);
		p.add(assignBook);
		p.add(returnBook);
		p.add(addAccount);
		p.add(removeAccount);
		
//		p.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//frm.getContentPane().setLayout(new BoxLayout(frm.getContentPane(), BoxLayout.Y_AXIS));
		
		frm.getContentPane().add(p);
		frm.setResizable(false);
		frm.setVisible(true);
		
		//System.out.println("Access Granted");
	}
	
	public void addBookScreen() {
		window = new JFrame();
		window.pack();
		window.setSize(270,200);
		window.setTitle("Add Book");
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER,2,2));
		lbl1 = new JLabel("Enter a book to add");
		tf1 = new JTextField();
		tf1.setPreferredSize(new Dimension(200,24));
		
		lbl2 = new JLabel("Enter the book's genre");
		tf2 = new JTextField();
		tf2.setPreferredSize(new Dimension(200,24));
		
		grp = new ButtonGroup();
		
		lbl3 = new JLabel("Availability");
		available = new JRadioButton();
		available.setText("Available");
		
		unavailable = new JRadioButton();
		unavailable.setText("Unavailable");
		
		btn = new JButton("Add Book");
		btn.addActionListener(this);
		
		p1.add(lbl1);
		p1.add(tf1);
		p1.add(lbl2);
		p1.add(tf2);
		p1.add(lbl3);
		p1.add(available);
		p1.add(unavailable);
		p1.add(btn);
		
		grp.add(available);
		grp.add(unavailable);
		
		
		window.getContentPane().add(p1);
		window.setVisible(true);
	}
	
	public void removeBook() {
		delBook = new JFrame();
		delBook.pack();
		delBook.setSize(270,120);
		delBook.setTitle("Remove Book");
		delBook.setLocationRelativeTo(null);
		delBook.setResizable(false);
		delBook.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel1 = new JPanel();
		
		idRemove = new JLabel("Enter Book ID to be removed");
		id = new JTextField();
		id.setPreferredSize(new Dimension(200,24));
		
		deleteBook = new JButton("Delete Book");
		deleteBook.addActionListener(this);
		
		panel1.add(idRemove);
		panel1.add(id);
		panel1.add(deleteBook);
		delBook.getContentPane().add(panel1);
		delBook.setVisible(true);
	}
	
	public void removeAcct() {
		wRemove = new JFrame();
		wRemove.pack();
		wRemove.setSize(270,120);
		wRemove.setTitle("Remove Book");
		wRemove.setLocationRelativeTo(null);
		wRemove.setResizable(false);
		wRemove.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void addAcctScreen() {
		wAdd = new JFrame();
		wAdd.pack();
		wAdd.setSize(270,220);
		wAdd.setTitle("Add Account");
		wAdd.setLocationRelativeTo(null);
		wAdd.setResizable(false);
		wAdd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		acct = new JPanel();
		username = new JLabel("Enter the username you want to add");
		addUser = new JTextField();
		addUser.setPreferredSize(new Dimension(200,24));
		password = new JLabel("Set user password");
		pwd = new JPasswordField();
		pwd.setPreferredSize(new Dimension(200,24));
		
		adminPowers = new JLabel("Aministrative Powers");
		user = new JRadioButton();
		user.setText("User");
		librarian = new JRadioButton();
		librarian.setText("Librarian");
		admin = new JRadioButton();
		admin.setText("Admin");
		
		grp1 = new ButtonGroup();
		grp1.add(user);
		grp1.add(librarian);
		grp1.add(admin);
		
		acctAdd = new JButton("Add account");
		acctAdd.addActionListener(this);
		
		acct.add(username);
		acct.add(addUser);
		acct.add(password);
		acct.add(pwd);
		acct.add(adminPowers);
		acct.add(user);
		acct.add(librarian);
		acct.add(admin);
		acct.add(acctAdd);
		wAdd.getContentPane().add(acct);
		wAdd.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addBook)) {
//			System.out.println("addBook btn pressed");
			addBookScreen();
		}
		
		if(e.getSource().equals(removeBook)) {
//			System.out.println("removeBook btn pressed");
			removeBook();
		}
		
		if(e.getSource().equals(assignBook)) {
			System.out.println("assignBook btn pressed");
		}
		
		if(e.getSource().equals(returnBook)) {
			System.out.println("returnBook btn pressed");
		}
		
		if(e.getSource().equals(deleteBook)) {
			if(id.getText().equals("")) {
				String err = "ID of the book to be deleted cannot be empty!";
				JOptionPane.showMessageDialog(null, err);
			}else {
				c1.findBID(id.getText());
				try {
					if(!c1.rs.next()) {
						String err = "Book ID not found!";
						JOptionPane.showMessageDialog(null, err);
					}else {
						String success = "Book is deleted!";
						JOptionPane.showMessageDialog(null,success);
						c.deleteBook(id.getText());
						id.setText("");
					}
				}catch(Exception a) {
					a.printStackTrace();
				}
				
				
			}
		}
		
		if(e.getSource().equals(acctAdd)) {
			if(addUser.getText().equals("") || pwd.getText().equals("") || (!(admin.isSelected()||user.isSelected() || librarian.isSelected()))) {
				String err = "Please fill all fields/select all options";
				JOptionPane.showMessageDialog(null, err);
			}else {
				uName = addUser.getText();
				pass = pwd.getText();
				if(admin.isSelected()) {
					privilege = "2";
				}
				
				if(librarian.isSelected()) {
					privilege = "1";
				}
				
				if(user.isSelected()) {
					privilege = "0";
				}
				
				
				c.addAccount(uName, pass, privilege);
				String msg = "Account successfully added";
				JOptionPane.showMessageDialog(null, msg);
				addUser.setText("");
				pwd.setText("");
				grp1.clearSelection();
				
				
			}
		}
		
		if(e.getSource().equals(addAccount)) {
			if(Login.privilege.equals("2")) {
//				System.out.println("Add account access granted!");
				addAcctScreen();
			}else {
				String err = "Access Denied! Only Admins can create/delete accounts!";
				JOptionPane.showMessageDialog(null, err);
			}
//			System.out.println("addAccount btn pressed");
		}
		
		if(e.getSource().equals(removeAccount)) {
			if(Login.privilege.equals("2")) {
				System.out.println("Remove account access granted!");
			}else {
				String err = "Access Denied! Only Admins can create/delete accounts!";
				JOptionPane.showMessageDialog(null, err);
			}
			
//			System.out.println("removeAccount btn pressed");
		}
		
		if(e.getSource().equals(btn)) {
			if(tf1.getText().equals("") || tf2.getText().equals("") || (!(available.isSelected()||unavailable.isSelected()))) {
				String err = "Please fill all fields/select all options";
				JOptionPane.showMessageDialog(null, err);
			}else {
				name = tf1.getText();
				genre = tf2.getText();
				if(available.isSelected()) {
					availability = "Available";
				}
				
				if(unavailable.isSelected()) {
					availability = "Unavailable";
				}

				c.addBook(name, genre, availability);
				String msg = "Book is added!";
				JOptionPane.showMessageDialog(null, msg);
				tf1.setText("");
				tf2.setText("");
				grp.clearSelection();
				
				
			}
		}
		
	}
}
