package tn.edu.espritCS.nicePlant.dao;

import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Farmer;

public class FarmerDao {
	private UtilJdbc utiljdbc = new UtilJdbc();
	public boolean addFarmer(Farmer farmer) {
		boolean b=false;
		try {
			Statement statement=utiljdbc.nouveauconnexion().createStatement();
String sql="insert into farmer (firstname,lastname,login,password,mail) values('"+farmer.getFirstName()+"'" +
		",'"+farmer.getLastName()+"','"+farmer.getLogin()+"'" +
				",'"+farmer.getPassword()+"','"+farmer.getMail()+"')";
statement.executeUpdate(sql);
b=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	}


