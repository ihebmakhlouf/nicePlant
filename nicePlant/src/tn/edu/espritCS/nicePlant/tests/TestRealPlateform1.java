package tn.edu.espritCS.nicePlant.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.dao.FarmerDao;
import tn.edu.espritCS.nicePlant.domain.Farmer;




public class TestRealPlateform1 {
	private FarmerDao farmerDao = new FarmerDao();

	@Test
	public void testHetliConnetionMrigle() {
		UtilJdbc utilJdbc = new UtilJdbc();
		utilJdbc.nouveauconnexion();
	}
	@Test
	public void testAddFarmer() {
		Farmer farmer =new 
		Farmer("makhlouf","iheb","ihebmakhlouf","isi","iheb@yahoo.fr");
		Assert.assertTrue(farmerDao.addFarmer(farmer));
}
}