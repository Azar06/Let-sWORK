package test;

import static org.junit.Assert.*;
import org.junit.Test;

import business.Factory;
import persistence.ProductOffer;

public class ProductOfferTest {

    @Test
    public void testProductOffer() throws Exception {
    	Factory factorio = new TestFactory();
        ProductOffer po = factorio.createProductOffer(23.5, 5);

        assertEquals(po.getAmount(), 5);
        po.addAmount(27);
        assertEquals(po.getAmount(), 32);
        po.removeAmount(7);
        assertEquals(po.getAmount(), 25);
    }
}