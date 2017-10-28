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
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;



public class HomePage extends JFrame {
	


	private JPanel contentPane;
	Database db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		
	}
	
	public HomePage(int id) {
		//System.out.println(id);
		db = new Database();
		String custName = db.getName(id);
		//System.out.println(det);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Welcome "+ custName.toUpperCase());
		lblLoginPage.setFont(new Font("Dialog", Font.BOLD, 19));
		lblLoginPage.setBounds(39, 65, 537, 32);
		contentPane.add(lblLoginPage);
		
		JButton btnChekBal = new JButton("Check Balance");
		btnChekBal.setFont(new Font("Dialog", Font.BOLD, 20));
		btnChekBal.setBackground(Color.BLUE);
		btnChekBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = db.getBal(id);
				System.out.println(balance);
				JOptionPane.showMessageDialog(null, balance,"account balance",
                        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnChekBal.setForeground(Color.LIGHT_GRAY);
		btnChekBal.setBounds(49, 177, 200, 60);
		contentPane.add(btnChekBal);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.addActionListener(new ActionListener() {   //action for money transfer button
			public void actionPerformed(ActionEvent arg0) {
				Transfer mytrans = new Transfer(id);
				mytrans.setVisible(true);
			}
		});
		btnTransferMoney.setBounds(328, 180, 208, 59);
		contentPane.add(btnTransferMoney);
	}
	
	public int add (int a ,int b) {
		return a+b;
	}
}
