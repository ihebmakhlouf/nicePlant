package tn.edu.espritCS.nicePlant.services;

import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;

public class AffectEventService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public boolean affectEvent(int id_event, int id_plant, String periode) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "insert into affectation_event (id_event,id_plant,periode)values("
					+ id_event + "," + id_plant + ",'" + periode + "')";

			statement.executeUpdate(sql);

			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}
}
