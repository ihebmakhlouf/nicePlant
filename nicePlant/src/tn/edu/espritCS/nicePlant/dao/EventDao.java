package tn.edu.espritCS.nicePlant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Event;

public class EventDao {
	UtilJdbc utilJdbc = new UtilJdbc();

	public boolean addEvent(Event event) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "insert into event(event_name)values('"
					+ event.getName_evt() + "')";
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public Event findEventById(int id_event) {

		Event evenTmp = new Event();
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from event where id_event=" + id_event;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				evenTmp.setId_evt(resultSet.getInt("id_event"));
				evenTmp.setName_evt(resultSet.getString("event_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return evenTmp;
	}

	public boolean updateEvent(Event event) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();

			String sql = "update event set event_name='" + event.getName_evt()
					+ "'" 
					+ " where id_event=" + event.getId_evt();
			System.out.println(sql);
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public boolean deleteEvent(int id_event) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "delete from event where id_event=" + id_event;
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

}
