import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class ReturnBook extends JFrame implements ActionListener {
	String bookname;
	JFrame window;
	JTextField bookID;
	JLabel lbl1;
	JPanel p;
	JButton b1;
	
	String availability;
	
	Connect c = new Connect();
	Connect c1 = new Connect();
	
	public ReturnBook() {
		window = new JFrame();
		window.pack();
		window.setSize(270,120);
		window.setTitle("Return Book by ID");
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p = new JPanel();
		
		lbl1 = new JLabel("Enter Book ID to return");
		bookID = new JTextField();
		bookID.setPreferredSize(new Dimension(200,24));
		
		b1 = new JButton("Return Book");
		b1.addActionListener(this);
		
		
		p.add(lbl1);
		p.add(bookID);
		p.add(b1);
		window.getContentPane().add(p);
		window.setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b1)) {
			if(bookID.getText().equals("")) {
				String err = "Please enter a book ID to return";
				JOptionPane.showMessageDialog(null, err);
			}else {
				c.findBID(bookID.getText());
				try {
					if(!c.rs.next()) {
						String err = "Book ID not found!";
						JOptionPane.showMessageDialog(null, err);
					}else {
						c1.checkAvailability(bookID.getText());
						while(c1.rs.next()) {
							availability = c1.rs.getString(1);
						}
						
						if(!availability.equals("Unavailable")) {
							String err = "You can't return a book that is listed as available";
							JOptionPane.showMessageDialog(null, err);
						}else {
							c.returnBook(bookID.getText());
							c.updateAvailability("Available", bookID.getText());
							String success = "Book returned!";
							JOptionPane.showMessageDialog(null, success);
							bookID.setText("");
						}
						
						
					}
				}catch (Exception f) {
					f.printStackTrace();
				}
			}
		}
		
	}

}
