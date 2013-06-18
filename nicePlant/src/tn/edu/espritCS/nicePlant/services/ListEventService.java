package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Event;

public class ListEventService {
	UtilJdbc utilJdbc = new UtilJdbc();

	public ArrayList<Event> liste() throws SQLException {
		ArrayList<Event> arrayList = new ArrayList<Event>();

		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from event";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Event event = new Event(resultSet.getString("event_name"),

				resultSet.getInt("id_event"));
				arrayList.add(event);

			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

	public Event getRow(int id_Event) {
		Event event = null;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from event where id_event=" + id_Event;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				event = new Event(resultSet.getString("event_name"),
						resultSet.getInt("id_event"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}
}
