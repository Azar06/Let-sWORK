package test;

import org.junit.Test;
import persistence.ProductSet;

import static org.junit.Assert.*;

public class ProductSetJDBCTest {

    @Test
    public void loadAll() throws Exception {
        ProductSet p = (new TestFactory()).createProductSet();

        p.loadAll();
    }
}