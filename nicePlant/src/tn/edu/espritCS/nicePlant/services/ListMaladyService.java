package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Malady;

public class ListMaladyService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public ArrayList<Malady> liste() throws SQLException {
		ArrayList<Malady> arrayList = new ArrayList<Malady>();

		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from maladie";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Malady malady = new Malady(resultSet.getInt("id_maladie"),
						resultSet.getString("name_maladie"),
						resultSet.getString("tige_color"),
						resultSet.getString("feuille"),
						resultSet.getString("fleur"),
						resultSet.getString("solution"));
				arrayList.add(malady);

			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	public Malady getRow(int id_Malady) {
		Malady malady = null;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from maladie where id_maladie=" + id_Malady;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				malady = new Malady(resultSet.getInt("id_maladie"),
						resultSet.getString("name_maladie"),
						resultSet.getString("tige_color"),
						resultSet.getString("feuille"),
						resultSet.getString("fleur"),
						resultSet.getString("solution"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return malady;
	}
}
