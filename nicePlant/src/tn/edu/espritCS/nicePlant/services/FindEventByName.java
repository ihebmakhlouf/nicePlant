package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Event;

public class FindEventByName {

	UtilJdbc utilJdbc = new UtilJdbc();

	public int findEventByName(String name) {
		int i = 0;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from event where event_name='" + name + "'";

			ResultSet resultSet = statement.executeQuery(sql);
			Event eventTmp = new Event();
			while (resultSet.next()) {
				eventTmp.setId_evt(resultSet.getInt("id_event"));
				i = eventTmp.getId_evt();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
