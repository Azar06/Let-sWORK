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
        p.setDescription("Marteau tr�s solide, id�al pour planter des clous");
        p.setBrandName("Marque");

        assertEquals(p.getLabel(), "Marteau");
        assertEquals(p.getDescription(), "Marteau tr�s solide, id�al pour planter des clous");
        assertEquals(p.getBrandName(), "Marque");
        
        p.setLabel("Clous");
        p.setDescription("Tr�s fins");
        assertEquals(p.getLabel(), "Clous");
        assertEquals(p.getDescription(), "Tr�s fins");
	}
}
