import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class AdminPanel extends JFrame implements ActionListener {
	JFrame frm;
	JFrame window;
	JTextField tf1;
	JTextField tf2;
	JRadioButton available;
	JRadioButton unavailable;
	JPanel p;
	JLabel lbl;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JPanel p1;
	JButton b1;
	JButton addBook;
	JButton btn;
	JButton removeBook;
	JButton assignBook;
	JButton returnBook;
	JButton addAccount;
	JButton removeAccount;
	ButtonGroup grp;
	String name;
	String genre;
	String availability;
	
	Connect c = new Connect();
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addBook)) {
//			System.out.println("addBook btn pressed");
			addBookScreen();
		}
		
		if(e.getSource().equals(removeBook)) {
			System.out.println("removeBook btn pressed");
		}
		
		if(e.getSource().equals(assignBook)) {
			System.out.println("assignBook btn pressed");
		}
		
		if(e.getSource().equals(returnBook)) {
			System.out.println("returnBook btn pressed");
		}
		
		if(e.getSource().equals(addAccount)) {
			if(Login.privilege.equals("2")) {
				System.out.println("Add account access granted!");
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
