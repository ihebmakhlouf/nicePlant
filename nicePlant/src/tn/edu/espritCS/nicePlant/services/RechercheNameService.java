package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Malady;

public class RechercheNameService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public int findMaladyByName(String name) {
		int i = 0;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from maladie where name_maladie='" + name
					+ "'";

			ResultSet resultSet = statement.executeQuery(sql);
			Malady maladyTmp = new Malady();
			while (resultSet.next()) {
				maladyTmp.setId_malady(resultSet.getInt("id_maladie"));
				i = maladyTmp.getId_malady();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
