package tn.edu.espritCS.nicePlant.services;

import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;

public class AffectMaladyService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public boolean affectMalady(int id_malady, int id_plant) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "insert into affectation_maladie(id_maladie,id_plant)values("
					+ id_malady + "," + id_plant + ")";
			statement.executeUpdate(sql);

			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}
}
