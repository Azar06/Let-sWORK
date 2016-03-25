package persistence;

import static org.junit.Assert.*;

public class ProductOfferTest {

    @org.junit.Test
    public void testProductOffer() throws Exception {
        ProductOffer po = new ProductOffer(23.5, 5);

        assertEquals(po.getAmount(), 5);
        po.addAmount(27);
        assertEquals(po.getAmount(), 32);
        po.removeAmount(7);
        assertEquals(po.getAmount(), 25);
    }

}