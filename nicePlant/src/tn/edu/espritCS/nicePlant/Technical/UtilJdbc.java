package tn.edu.espritCS.nicePlant.Technical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJdbc {

	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/niceplantdb";
	private String user = "root";
	private String password = "";

	public Connection nouveauconnexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion etabli");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}