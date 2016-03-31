package test;

import business.Factory;
import business.facade.ServiceFacade;
import persistence.Category;
import persistence.Service;

//import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceFacadeTest {

    @Test
    public void create() throws Exception {
        ServiceFacade sf = new ServiceFacade();
        Factory f = new TestFactory();
        Category c = f.createCategory();
//        Service s =
        sf.create("shit service #" + (new java.util.Random()).nextInt(999), "we make shit better than others " + (new java.util.Random()).nextInt(99) + " times", c);

//        assertEquals(s.getLabel(), "shit service");
    }

    @Test
    public void save() throws Exception {

    }
}