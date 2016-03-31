package test;

import org.junit.Test;
import persistence.ServiceSet;

import static org.junit.Assert.*;

public class ServiceSetJDBCTest {

    @Test
    public void loadAll() throws Exception {
        ServiceSet s = (new TestFactory()).createServiceSet();

        s.loadAll();
    }
}