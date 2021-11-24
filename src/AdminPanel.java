import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class AdminPanel extends JFrame implements ActionListener {
	JFrame frm;
	JPanel p;
	JLabel lbl;
	JButton addBook;
	JButton removeBook;
	JButton assignBook;
	JButton returnBook;
	JButton addAccount;
	JButton removeAccount;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addBook)) {
			System.out.println("addBook btn pressed");
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
		
	}
}
