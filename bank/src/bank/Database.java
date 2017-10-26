package bank;
import java.sql.*;
public class Database {
	
	 Connection con;
	 PreparedStatement pstLogin, pstGetBal;
	 ResultSet rs;
	 
	 
	 Database(){
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 //1.get a connection to database
			 Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","gaurav","gaurav610");
			 pstLogin = Conn.prepareStatement("SELECT * FROM account WHERE username = ? AND password = ?");
			 pstGetBal = Conn.prepareStatement("SELECT *  FROM balance WHERE usr_id = ?");
		 }
		 catch (Exception e) {
			 System.out.println(e);
		 }
	 }
	 
	 //login function
	 public int chkLogin(String u_name, String pwd) {
		 try {
			 pstLogin.setString(1, u_name);
			 pstLogin.setString(2, pwd);
			 rs = pstLogin.executeQuery();
			 
			 if(rs.next()) {	//if any record is returned
				 return rs.getInt("userId");
			 }
			 else {
				 return 0;
			 }
		 }
		 catch (Exception e) {
			 System.out.println("Error in login");
			 return 0;
		 }
	 }
	 
	 
	 
	 // returns the balance in the account of the user
	 public int getBal(int id) {
		 try {
			 pstGetBal.setInt(1, id);
			 rs = pstGetBal.executeQuery();
			 if(rs.next()) return rs.getInt("acc_balance");
		 }
		 catch (Exception e) {
			 System.out.println("datbase error");
		 }
		return -2;
	 }

}
