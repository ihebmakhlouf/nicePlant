package tn.edu.espritCS.nicePlant.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.dao.MaladyDao;
import tn.edu.espritCS.nicePlant.domain.Malady;

public class TestRealPlateform2 {
	private MaladyDao maladyDao = new MaladyDao();

	@Test
	public void testHetliConnetionMrigle() {
		UtilJdbc utilJdbc = new UtilJdbc();
		utilJdbc.nouveauconnexion();
	}

	@Test
	public void testAddMalady() {
		Malady malady = new Malady("Chlorose", "Normal", "tache jaune",
				"Normal");
		Assert.assertTrue(maladyDao.addMalady(malady));
	}

	@Test
	public void testFindFarmerByDescription() {
		Malady malady = maladyDao.findMaladyByDescription("Normal",
				"tache jaune", "Normal");
		Assert.assertEquals("Chlorose", malady.getName_mal());
	}

	@Test
	public void testFindFarmerById() {
		Malady malady = maladyDao.findMaladyById(1);
		Assert.assertEquals("Chlorose", malady.getName_mal());
	}

	@Test
	public void testUpdateMalady() {
		Malady malady = maladyDao.findMaladyById(1);
		malady.setName_mal("Chlorose");
		malady.setTige("Normal");
		malady.setFeuille("taches jaunes");
		malady.setFleur("Normal");
		Assert.assertTrue(maladyDao.updateMalady(malady));
	}

	@Test
	public void testDeleteMalady() {

		Assert.assertTrue(maladyDao.deleteMalady(3));
	}

}
