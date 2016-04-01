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
        p.setLabel("Marteau");
        p.setDescription("Marteau tres solide, id�al pour planter des clous");
        p.setBrandName("Marque");

        assertEquals(p.getLabel(), "Marteau");
        assertEquals(p.getDescription(), "Marteau tres solide, id�al pour planter des clous");
        assertEquals(p.getBrandName(), "Marque");
        
        p.setLabel("Clous");
        p.setDescription("Tres fins");
        assertEquals(p.getLabel(), "Clous");
        assertEquals(p.getDescription(), "Tres fins");
	}
}
