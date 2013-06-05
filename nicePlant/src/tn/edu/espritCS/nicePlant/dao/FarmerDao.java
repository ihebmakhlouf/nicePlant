package tn.edu.espritCS.nicePlant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Farmer;

public class FarmerDao {
	private UtilJdbc utiljdbc = new UtilJdbc();

	public boolean addFarmer(Farmer farmer) {
		boolean b = false;
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "insert into farmer (firstname,lastname,login,password,mail) values('"
					+ farmer.getFirstName()
					+ "'"
					+ ",'"
					+ farmer.getLastName()
					+ "','"
					+ farmer.getLogin()
					+ "'"
					+ ",'"
					+ farmer.getPassword() + "','" + farmer.getMail() + "')";
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public Farmer findFarmerById(int id_farmer) {
		Farmer farmerTmp = new Farmer();
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "select * from farmer where id_farmer=" + id_farmer;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				farmerTmp.setId_farmer(resultSet.getInt("id_farmer"));
				farmerTmp.setFirstName(resultSet.getString("firstname"));
				farmerTmp.setLastName(resultSet.getString("lastname"));
				farmerTmp.setLogin(resultSet.getString("login"));
				farmerTmp.setPassword(resultSet.getString("password"));
				farmerTmp.setMail(resultSet.getString("mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return farmerTmp;
	}

	public boolean updateFarmer(Farmer farmer) {
		boolean b = false;

		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "update farmer set firstname='"
					+ farmer.getFirstName() + "'" + ",lastname='"
					+ farmer.getLastName() + "'" + ",login='"
					+ farmer.getLogin() + "'" + ",password='"
					+ farmer.getPassword() + "'" + ",mail='" + farmer.getMail()
					+ "'" + " where id_farmer=" + farmer.getId_farmer() + "";

			statement.executeUpdate(sql);

			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch blockge
			e.printStackTrace();
		}
		return b;
	}

	public boolean deleteFarmer(int id_farmer) {
		boolean b = false;
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "delete from farmer where id_farmer=" + id_farmer;
			System.out.println(sql);
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}
}
