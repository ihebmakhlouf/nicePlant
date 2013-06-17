package tn.edu.espritCS.nicePlant.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.domain.Plant;

public class ListePlantService {
	 UtilJdbc utilJdbc=new UtilJdbc();
	 public ArrayList<Plant> liste() throws SQLException
	 {
		 ArrayList<Plant> arrayList=new ArrayList<Plant>();
		 
		 try {
			Statement statement=utilJdbc.nouveauconnexion().createStatement();
			String sql="select * from plant";
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next())
			{
			Plant plant=new Plant(resultSet.getString("name"),resultSet.getString("saison"),resultSet.getInt("id_plant"));
			arrayList.add(plant);
	
			}
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	 }
	 public Plant getRow(int id_plant)
	 {
		 Plant plant=null;
		 try {
			Statement statement=utilJdbc.nouveauconnexion().createStatement();
			String sql="select * from plant where id_plant="+id_plant;
			ResultSet resultSet=statement.executeQuery(sql);
			while(resultSet.next())
			{
			 plant=new Plant(resultSet.getString("name"),resultSet.getString("saison"),resultSet.getInt("id_plant"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return plant;
	 }
}
