package resources;


import java.sql.*;

public class database {
	
	Connection conn;
	Statement st;
	public void dataBaseConnectivity() throws ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank","purvi","");
			st=conn.createStatement();
			st.executeQuery("select * from employee");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
