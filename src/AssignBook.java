import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class AssignBook extends JFrame implements ActionListener {
	JFrame window;
	JPanel p;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JTextField userID;
	JTextField bookID;
	JTextField date;
	JButton add;
	
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
			System.out.println("pressed");
		}
		
	}

}
