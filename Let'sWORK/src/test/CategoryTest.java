package test;

import static org.junit.Assert.*;
import org.junit.Test;

import business.Factory;
import persistence.Category;


public class CategoryTest {

	@Test
    public void testCategory() throws Exception {
	
		Factory factorio = new TestFactory();
        Category cat = factorio.createCategory();
        cat.setName("Alimentaire");
        cat.setDescription("Produits alimentaires disponibles");

        assertEquals(cat.getName(), "Alimentaire");
        cat.setName("Alim");
        assertEquals(cat.getName(), "Alim");

    }
}
