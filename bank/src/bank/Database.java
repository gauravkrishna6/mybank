package bank;
import java.sql.*;
public class Database {
	
	 Connection con;
	 PreparedStatement pstLogin, pstGetDetail;
	 ResultSet rs,rs1;
	 
	 
	 Database(){
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 //1.get a connection to database
			 Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","gaurav","gaurav610");
			 pstLogin = Conn.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?");
			 pstGetDetail = Conn.prepareStatement("SELECT *  FROM accounts WHERE usr_id = ?");
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
			 pstGetDetail.setInt(1, id);
			 rs = pstGetDetail.executeQuery();
			 if(rs.next()) return rs.getInt("acc_balance");
		 }
		 catch (Exception e) {
			 System.out.println("datbase error");
		 }
		return -2;
	 }
	 
	 public String getName(int id) {
		 try {
			 pstGetDetail.setInt(1,id);
			 rs1 = pstGetDetail.executeQuery();
			 if(rs1.next())
			 return rs1.getString("name");
			 else return null;
		 }
		 catch(Exception e) {
			 System.out.println(e);
			 return null;
		 }
		
	 }

}
