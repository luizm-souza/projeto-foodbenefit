import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	
	
	private static String user = "root";
	private static String pwd = "";
	private static String banco = "bd_food_benefit";
	private static String serverName = "127.0.0.1";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	
	private static String url = "jdbc:mysql://"+serverName+"/"+banco+"?useTimezone=true&serverTimezone=UTC";
	
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		conn =  DriverManager.getConnection(url,user,pwd);
		
		
		if (conn != null) {
			System.out.println("Conexão realizada com sucesso");
		}else {
			System.out.print("Conexão faiô");
		}
		return conn;
		
	}

}
