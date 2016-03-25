package test;

import static org.junit.Assert.*;
import org.junit.Test;

import persistence.Category;


public class CategoryTest {

	@Test
    public void testCategory() throws Exception {
	
        Category cat = new Category("Alimentaire", "Produits alimentaires disponibles");

        assertEquals(cat.getName(), "Alimentaire");
        cat.setName("Alim");
        assertEquals(cat.getName(), "Alim");

    }
}
