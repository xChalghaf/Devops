package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.services.IOperateurService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceTest {

    @Autowired
    IOperateurService ps;

    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Operateur> listOperateurs = ps.retrieveAllOperateurs();
        Assertions.assertEquals(0, listOperateurs.size());
    }


}
