import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame implements ActionListener, MouseListener {

	JLabel lblLogin, lblUsername, lblPassword, lblRegis, lblTitle;
	JPanel panelForm;
	JTextField tfUsername;
	JButton btnLogin;
	JPasswordField pfPassword;

	Connect connect = new Connect();

	void init() {
//		lblTitle = new JLabel("Welcome to the public library system", SwingConstants.CENTER);
//		lblTitle.setFont(new Font("Helvetica", Font.BOLD, 20));
		lblLogin = new JLabel("Login", SwingConstants.CENTER);
		lblLogin.setFont(new Font("Helvetica", Font.BOLD, 18));

		lblUsername = new JLabel("Username");
		lblPassword = new JLabel("Password");
		lblRegis = new JLabel("", SwingConstants.CENTER);
		lblRegis.setForeground(Color.BLUE);
		lblRegis.setFont(new Font("Calibri", Font.ITALIC, 20));
		lblRegis.addMouseListener(this);

		panelForm = new JPanel(new GridLayout(2, 2));
		panelForm.setBorder(new EmptyBorder(0, 20, 0, 20));

		tfUsername = new JTextField();
		pfPassword = new JPasswordField();

		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(this);

		setLayout(new GridLayout(4, 1));
		//add(lblTitle);
		add(lblLogin);

		panelForm.add(lblUsername);
		panelForm.add(tfUsername);
		panelForm.add(lblPassword);
		panelForm.add(pfPassword);
		add(panelForm);

		add(lblRegis);
		add(btnLogin);
	}

	public Login() {
		init();
		setSize(800, 400);
		setTitle("Public Library System");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnLogin)) {
			if (tfUsername.getText().equals("") && pfPassword.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Username and Password must be filled", "Warning",
						JOptionPane.WARNING_MESSAGE);
			} else if (tfUsername.getText().equals("") && !pfPassword.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Username must be filled", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if (!tfUsername.getText().equals("") && pfPassword.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Password must be filled", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				connect.callLogin(tfUsername.getText(), pfPassword.getText());
				try {
					if (!connect.rs.next()) {
						JOptionPane.showMessageDialog(this, "Wrong username or password", "Warning",
								JOptionPane.WARNING_MESSAGE);
					} else {
						dispose();
						Main main = new Main();
						//System.out.println("you're in!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(lblRegis)) {
			System.out.println("register data");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
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

}