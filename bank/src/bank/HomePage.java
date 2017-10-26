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



public class HomePage extends JFrame {
	


	private JPanel contentPane;
	Database db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Login mylog = new Login();
		//System.out.println(mylog.User_id);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomePage frame = new HomePage();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage(int id) {
		//System.out.println(id);
		db = new Database();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("DashBoard");
		lblLoginPage.setBounds(159, 56, 117, 15);
		contentPane.add(lblLoginPage);
		
		JButton btnChekBal = new JButton("chek bal");
		btnChekBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int balance = db.getBal(id);
				System.out.println(balance);
				JOptionPane.showMessageDialog(null, balance,"account balance",
                        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnChekBal.setForeground(Color.GREEN);
		btnChekBal.setBounds(126, 200, 200, 60);
		contentPane.add(btnChekBal);
	}
}
