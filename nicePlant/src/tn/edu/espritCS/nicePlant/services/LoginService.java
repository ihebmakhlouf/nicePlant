package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;

public class LoginService {
 UtilJdbc utilJdbc=new UtilJdbc();
	public int login(String login, String password) {
		int b=0;
		try {
			Statement statement =utilJdbc.nouveauconnexion().createStatement();
			Statement statement1 =utilJdbc.nouveauconnexion().createStatement();
			String sql="select * from farmer where login='"+login+"' and password='"+password+"'"; 
			String sql1="select * from admin where login='"+login+"' and password='"+password+"'"; 
			ResultSet resultSet=statement.executeQuery(sql);
			ResultSet resultSet1=statement1.executeQuery(sql1);
			while(resultSet.next())
			{
				System.out.println("hana le9eneh tel3 fal7...");
				b=1;
			}
			while(resultSet1.next())
			{
				System.out.println("hana le9eneh tel3 admin...");
				b=2;
			}
		} catch (SQLException e) {
			System.out.println("male9touch ...");
			e.printStackTrace();
		}
		
		return b;
	}

	

}
