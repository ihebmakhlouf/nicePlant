package tn.edu.espritCS.nicePlant.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.dao.PlantDao;
import tn.edu.espritCS.nicePlant.domain.Plant;

public class TestRealPlateform {
	private PlantDao plantDao = new PlantDao();
	@Test
	public void testHetliConnetionMrigle() {
		UtilJdbc utilJdbc = new UtilJdbc();
		utilJdbc.nouveauconnexion();
	}

	@Test
	public void testAddPlant() {
		Plant plant = new Plant("Raise", "été");
		Assert.assertTrue(plantDao.addPlant(plant));
	}
	@Test
	public void testFindPlantById() {
		Plant plant =plantDao.findPlantById(7);
		Assert.assertEquals("Raise", plant.getName());
	}
	@Test
	public void testUpdatePlant() {
		Plant plant =plantDao.findPlantById(7);
		plant.setName("fraise");
		plant.setSaison("printemps");
		Assert.assertTrue(plantDao.updatePlant(plant));
	}
	@Test
	public void testDeletePlant() {
		
		Assert.assertTrue(plantDao.deletePlant(7));
	}
	
	
}
