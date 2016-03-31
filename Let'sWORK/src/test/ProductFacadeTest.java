package test;

import business.Factory;
import business.facade.ProductFacade;
import persistence.Category;
import persistence.Product;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductFacadeTest {

    @Test
    public void create() throws Exception {
        ProductFacade pf = new ProductFacade();
        Factory f = new TestFactory();
        Category c = f.createCategory();

        pf.create("shit product #" + (new java.util.Random()).nextInt(999), "we make shit better than others " + (new java.util.Random()).nextInt(99) + " times", "brand1", c);

//        assertEquals(s.getLabel(), "shit service");
    }

    @Test
    public void save() throws Exception {

    }
}
