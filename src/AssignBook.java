import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Font;
public class AssignBook extends JFrame implements ActionListener {
	String bookName;
	String name;
	String availability;
	JFrame window;
	JPanel p;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JTextField userID;
	JTextField bookID;
	JTextField date;
	JButton add;
	Connect c = new Connect();
	Connect c1 = new Connect();
	Connect c2 = new Connect();
	Connect c3 = new Connect();
	Connect c4 = new Connect();
	Connect c5 = new Connect();
	
	public AssignBook() {
		window = new JFrame();
		window.pack();
		window.setSize(270,218);
		window.setTitle("Assign Book to User by ID");
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p = new JPanel();
		lbl1 = new JLabel("Assign Book ID");
		bookID = new JTextField();
		bookID.setPreferredSize(new Dimension(200,24));
		
		lbl2 = new JLabel("Enter User ID to assign book to");
		userID = new JTextField();
		userID.setPreferredSize(new Dimension(200,24));
		
		lbl3 = new JLabel("Enter return date of assigned book");
		date = new JTextField();
		date.setPreferredSize(new Dimension(200,24));
		
		add = new JButton("Assign Book to User");
		add.addActionListener(this);
		
		p.add(lbl1);
		p.add(bookID);
		p.add(lbl2);
		p.add(userID);
		p.add(lbl3);
		p.add(date);
		p.add(add);
		
		window.getContentPane().add(p);
		window.setVisible(true);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(add)) {
			if(bookID.getText().equals("") || userID.getText().equals("") || date.getText().equals("")) {
				String err = "Please fill all fields/select all options";
				JOptionPane.showMessageDialog(null, err);
			}else {
				c.findBID(bookID.getText());
				c1.findAcctID(userID.getText());
				c5.checkAvailability(bookID.getText());
				
				try {
					while(c5.rs.next()) {
						availability = c5.rs.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					if(!c.rs.next() || !c1.rs.next()) {
						String err = "One of the fields have been entered incorrectly";
						JOptionPane.showMessageDialog(null, err);
					}else {
						if(!availability.equals("Available")) {
							String err = "The book you wanted to assign is either unavailable or broken";
							JOptionPane.showMessageDialog(null, err);
						}else {
							c2.findBookName(bookID.getText());
							while(c2.rs.next()) {
								bookName = c2.rs.getString(1);
							}
							
							c3.findAcctName(userID.getText());
							while(c3.rs.next()) {
								name = c3.rs.getString(1);
							}
							
							c4.popAssignBook(name, bookName, date.getText(), bookID.getText());
							c4.updateAvailability("Unavailable", bookID.getText());
							String success = "Book has been assigned to user";
							JOptionPane.showMessageDialog(null, success);
							bookID.setText("");
							userID.setText("");
							date.setText("");
						}
					}
				}catch(Exception f) {
					f.printStackTrace();
				}
			}
		}
		
	}

}
