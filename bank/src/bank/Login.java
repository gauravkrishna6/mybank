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
				
		db = new Database();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 600, 500);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bla Bla Bank...");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(228, 67, 176, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(97, 182, 103, 46);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(97, 282, 97, 15);
		getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(290, 196, 114, 19);
		getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
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
		btnNewButton.setBounds(209, 382, 132, 25);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 280, 114, 19);
		getContentPane().add(passwordField);
	}

}
