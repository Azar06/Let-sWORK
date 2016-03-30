package test;

import static org.junit.Assert.*;

import org.junit.Test;

import business.Factory;
import persistence.Category;
import persistence.Service;

public class ServiceTest {

	@Test
	public void testService() {
		Factory factorio = new TestFactory();
        Service s = factorio.createService();
        s.setLabel("Couture");
        s.setDescription("Je peux vous coudre vos ourlets pour 10 boules");

        assertEquals(s.getLabel(), "Couture");
        assertEquals(s.getDescription(), "Je peux vous coudre vos ourlets pour 10 boules");
        s.setLabel("Peinture");
        s.setDescription("Revetement de facade ayyyyghttt!");
        assertEquals(s.getLabel(), "Peinture");
        assertEquals(s.getDescription(), "Revetement de facade ayyyyghttt!");
	}

}
