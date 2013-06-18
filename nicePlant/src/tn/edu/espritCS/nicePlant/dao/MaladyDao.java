package tn.edu.espritCS.nicePlant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Malady;

public class MaladyDao {

	UtilJdbc utilJdbc = new UtilJdbc();

	public boolean addMalady(Malady malady) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "insert into maladie(name_maladie,tige_color,feuille,fleur,solution)values("
					+ "'"
					+ malady.getName_mal()
					+ "','"

					+ malady.getTige()
					+ "'"
					+ ",'"
					+ malady.getFeuille()
					+ "','"
					+ malady.getFleur()
					+ "','"
					+ malady.getSolution()
					+ "')";
			statement.executeUpdate(sql);

			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

	public Malady findMaladyByDescription(String tige, String feuille,
			String fleur) {
		Malady maladyTmp = new Malady();
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from maladie where tige_color=" + "'" + tige
					+ "'and feuille='" + feuille + "' and fleur='" + fleur
					+ "'";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				maladyTmp.setId_malady(resultSet.getInt("id_maladie"));
				maladyTmp.setName_mal(resultSet.getString("name_maladie"));
				maladyTmp.setTige(resultSet.getString("tige_color"));
				maladyTmp.setFeuille(resultSet.getString("feuille"));
				maladyTmp.setFleur(resultSet.getString("fleur"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maladyTmp;
	}

	public Malady findMaladyById(int id_malady) {
		Malady maladyTmp = new Malady();
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "select * from maladie where id_maladie=" + id_malady;
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				maladyTmp.setId_malady(resultSet.getInt("id_maladie"));
				maladyTmp.setName_mal(resultSet.getString("name_maladie"));
				maladyTmp.setTige(resultSet.getString("tige_color"));
				maladyTmp.setFeuille(resultSet.getString("feuille"));
				maladyTmp.setFleur(resultSet.getString("fleur"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maladyTmp;
	}

	public boolean updateMalady(Malady malady) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "update maladie set name_maladie='"
					+ malady.getName_mal() + "'" + ",tige_color='"
					+ malady.getTige() + "',feuille='" + malady.getFeuille()
					+ "',fleur='" + malady.getFleur() + "',solution='"
					+ malady.getSolution() + "' where id_maladie="
					+ malady.getId_malady();
			statement.execute(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public boolean deleteMalady(int id_malady) {
		boolean b = false;
		try {
			Statement statement = utilJdbc.nouveauconnexion().createStatement();
			String sql = "delete from maladie where id_maladie=" + id_malady;
			statement.executeUpdate(sql);
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return b;
	}

}
