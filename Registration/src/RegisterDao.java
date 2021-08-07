import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	private String dbdriver = "com.mysql.cj.jdbc.Driver";
	private String dburl = "jdbc:mysql://localhost:3306/dbuser";
	private String dbuname = "root";
	private String dbpassword = "password";
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} 
		
		catch (SQLException e) {
		
			e.printStackTrace();
		} 
	
		return con;
		
	}
	
	public String insert(Member member) {
		
		loadDriver(dbdriver);
		Connection con = getConnection();
		String result = "Hurray!!!! Data Entered Successfully.";
		String sql = "insert into member values(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, member.getUname());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.executeUpdate(); 
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
