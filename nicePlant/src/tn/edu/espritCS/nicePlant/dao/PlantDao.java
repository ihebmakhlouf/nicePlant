package tn.edu.espritCS.nicePlant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Farmer;
import tn.edu.espritCS.nicePlant.domain.Plant;

public class PlantDao {
	private UtilJdbc utiljdbc = new UtilJdbc();

	public boolean addPlant(Plant plant) {
		boolean b = false;
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "insert into plant (name,saison) values('"
					+ plant.getName() + "','" + plant.getSaison() + "')";
			statement.executeUpdate(sql);
			System.out.println("Plant added ..");
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public Plant findPlantById(int idPlant) {
		Plant plantmp = new Plant();
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "select * from plant where id_plant=" + idPlant;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				plantmp.setId_plant(resultSet.getInt("id_plant"));
				plantmp.setName(resultSet.getString("name"));
				plantmp.setSaison(resultSet.getString("saison"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantmp;
	}

	public boolean deletePlant(int idPlant) {
		boolean b = false;

		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "delete from plant where id_plant=" + idPlant;
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public boolean updatePlant(Plant plant) {
		boolean b = false;
		try {
			Statement statement = utiljdbc.nouveauconnexion().createStatement();
			String sql = "update plant set name ='" + plant.getName()
					+ "' , saison='" + plant.getSaison() + "'"
					+ "where id_plant=" + plant.getId_plant() + " ";
			b = true;
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	
}
