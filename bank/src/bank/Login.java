package bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class Login extends JFrame {
	private JTextField textUsername;
	private JPasswordField passwordField;
	PreparedStatement pst;
	Database db;
	public int User_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));
				
		db = new Database();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 600, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Indian Bank...");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Bitstream Vera Serif", Font.BOLD, 33));
		lblNewLabel.setBounds(142, 67, 308, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.BOLD, 20));
		lblUsername.setBounds(97, 182, 125, 46);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 22));
		lblPassword.setBounds(97, 264, 125, 33);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(290, 191, 183, 33);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] tmp_pwd = passwordField.getPassword();
				String pwd = null;
				pwd = String.copyValueOf(tmp_pwd);
				int tmp_id = db.chkLogin(textUsername.getText(), pwd);
				if(tmp_id > 0) {
//					JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
//                            JOptionPane.INFORMATION_MESSAGE);
					User_id = tmp_id;
					
					HomePage myhome = new HomePage(User_id);
					myhome.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(199, 365, 164, 46);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 266, 183, 33);
		getContentPane().add(passwordField);
	}

}
