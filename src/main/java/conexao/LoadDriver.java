package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriver {
	
	private Connection connection = null;
	private String address;
	private String database;
	private String username;
	private String password;
	private String port;
	
	public LoadDriver() {};
	
	public LoadDriver(String address, String port, String database, String username, String password) {
		this.address = address;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
		
		try {
		    this.setConnection(DriverManager.getConnection(
		    		"jdbc:mysql://"+this.getAddress()+":"+this.getPort()+"/"+this.getDatabase()+"?user="+this.getUsername()+"&password="+this.getPassword()));
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection conn) {
		this.connection = conn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
