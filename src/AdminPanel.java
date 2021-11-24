import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
public class AdminPanel extends JFrame implements ActionListener {
	JFrame frm;
	JPanel p;
	JLabel lbl;
	public AdminPanel() {
		frm = new JFrame();
		frm.pack();
		frm.setSize(700,500);
		frm.setTitle("Admin Panel");
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		p = new JPanel();
		lbl = new JLabel("Admin Panel");
		lbl.setFont(new Font("Helvetica", Font.BOLD, 22));
		p.add(lbl);
		
		frm.getContentPane().add(p);
		frm.setVisible(true);
		
		//System.out.println("Access Granted");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
