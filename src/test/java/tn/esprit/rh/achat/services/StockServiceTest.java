package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {

    @Autowired
    IStockService ps;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Stock> listStocks = ps.retrieveAllStocks();
        Assertions.assertEquals(0, listStocks.size());
    }


}
