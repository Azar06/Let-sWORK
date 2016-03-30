package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import business.Factory;
import persistence.Product;

public class ProductTest {
	@Test
	public void testProduct() {
		Factory factorio = new TestFactory();
        Product p = factorio.createProduct();
        p.setLabel("Couture");
        p.setDescription("Je peux vous coudre vos ourlets pour 10 boules");

        assertEquals(p.getLabel(), "Couture");
        assertEquals(p.getDescription(), "Je peux vous coudre vos ourlets pour 10 boules");
        p.setLabel("Peinture");
        p.setDescription("Revetement de facade ayyyyghttt!");
        assertEquals(p.getLabel(), "Peinture");
        assertEquals(p.getDescription(), "Revetement de facade ayyyyghttt!");
	}
}
