package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Farmer;

public class ListFarmerService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public ArrayList<Farmer> liste() throws SQLException {
		ArrayList<Farmer> arrayList = new ArrayList<Farmer>();

		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from farmer";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Farmer farmer = new Farmer(resultSet.getString("firstname"),
						resultSet.getString("lastname"),
						resultSet.getString("login"),
						resultSet.getString("mail"),
						resultSet.getInt("id_farmer"));
				arrayList.add(farmer);

			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	public Farmer getRow(int id_farmer) {
		Farmer farmer = null;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from farmer where id_farmer=" + id_farmer;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				farmer = new Farmer(resultSet.getString("firstname"),
						resultSet.getString("lastname"),
						resultSet.getString("login"),
						resultSet.getString("mail"),
						resultSet.getInt("id_farmer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return farmer;
	}
}
