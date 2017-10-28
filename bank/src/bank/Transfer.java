package bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transfer extends JFrame {

	private JPanel contentPane;
	private JTextField textField_account;
	private JTextField textField_amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Transfer frame = new Transfer();
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
	public Transfer(int id) {
		
		System.out.println(id);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTransferMoney = new JLabel("TRANSFER MONEY");
		lblTransferMoney.setBounds(178, 36, 256, 41);
		contentPane.add(lblTransferMoney);
		
		JLabel lblAccountNumber = new JLabel("Account number");
		lblAccountNumber.setBounds(38, 177, 151, 41);
		contentPane.add(lblAccountNumber);
		
		textField_account = new JTextField();
		textField_account.setBounds(320, 188, 114, 19);
		contentPane.add(textField_account);
		textField_account.setColumns(10);
		
		JLabel lblAmount = new JLabel("amount");
		lblAmount.setBounds(61, 293, 70, 15);
		contentPane.add(lblAmount);
		
		textField_amount = new JTextField();
		textField_amount.setBounds(344, 291, 114, 19);
		contentPane.add(textField_amount);
		textField_amount.setColumns(10);
		
		JButton btnGo = new JButton("go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGo.setBounds(194, 400, 117, 25);
		contentPane.add(btnGo);
	}
}
