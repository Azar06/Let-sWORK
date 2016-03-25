package test;

import static org.junit.Assert.*;
import org.junit.Test;

import persistence.Ressource;

public class RessourceTest {

	@Test
    public void testRessource() throws Exception {
	
        Ressource res = new Ressource("Ressource1", "Offre des produits et des Services");

        assertEquals(res.getDescription(), "Offre des produits et des Services");
        res.setDescription("Offre des produits et des services");
        assertEquals(res.getDescription(), "Offre des produits et des services");

    }
	
}
