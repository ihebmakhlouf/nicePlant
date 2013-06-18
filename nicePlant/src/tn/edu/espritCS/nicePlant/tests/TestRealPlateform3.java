package tn.edu.espritCS.nicePlant.tests;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.espritCS.nicePlant.Technical.UtilJdbc;
import tn.edu.espritCS.nicePlant.dao.EventDao;
import tn.edu.espritCS.nicePlant.domain.Event;

public class TestRealPlateform3 {
	private EventDao eventDao = new EventDao();

	@Test
	public void testHetliConnetionMrigle() {
		UtilJdbc utilJdbc = new UtilJdbc();
		utilJdbc.nouveauconnexion();
	}

	@Test
	public void testAddEvent() {
		Event event = new Event("harvesting1");
		Assert.assertTrue(eventDao.addEvent(event));
	}

	@Test
	public void testFindEventById() {
		Event event = eventDao.findEventById(1);
		Assert.assertEquals("harvesting", event.getName_evt());
	}

	@Test
	public void testUpdateEvent() {
		Event event = eventDao.findEventById(1);
		event.setName_evt("harvesting12");

		Assert.assertTrue(eventDao.updateEvent(event));
	}

	@Test
	public void testDeleteMalady() {

		Assert.assertTrue(eventDao.deleteEvent(12));
	}
}
