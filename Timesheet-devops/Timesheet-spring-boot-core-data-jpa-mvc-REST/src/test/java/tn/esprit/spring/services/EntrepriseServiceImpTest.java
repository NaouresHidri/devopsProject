package tn.esprit.spring.services;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseServiceImpTest {

    @Autowired
    IEntrepriseService es;

    Integer idObj;
    Integer idEntreprise;
    Integer idDepartment;

    private static final Logger log = LogManager.getLogger(EntrepriseServiceImpTest.class);

    @Test
    public void testAjouterEntreprise() {
        log.debug("method ajouterEntreprise");
        try {
            // test insert with id value
            // id value is sequence, auto incremented
            log.debug("create entreprise instance");
            Entreprise entreprise = new Entreprise("Entreprise_Devolution", "Raison_DevOps");
            log.debug("call ajouterEntreprise() with created instance");
            idObj = es.ajouterEntreprise(entreprise);
            assertNotNull(idObj);
        } catch (Exception e) {
            log.error("The method ajouterEntreprise fails :" + e);

        }
    }

    @Test
    public void testAjouterDepartement() {
        log.debug("methode ajouter Departement");
        try {
            // test insert with id value
            // id value is sequence, auto incremented
            log.debug("create Department instance");
            Departement dp = new Departement("testDepartmentName");
            log.debug("call ajouterDepartement() with created instance");
            idObj = es.ajouterDepartement(dp);
            assertNotNull(idObj);
        } catch (Exception e) {
            log.error("The method ajouterDepartement fails :" + e);

        }
    }

    @Test
    public void testAffecterDepartementAEntreprise() {
        log.debug("method AffecterDepartementAEntreprise");
        try {
            log.debug("create Entreprise instance");
            Entreprise entreprise = new Entreprise("Entreprise_test", "Raison_test");
            log.debug("call ajouterDepartement() with created instance");
            idEntreprise = es.ajouterEntreprise(entreprise);

            log.debug("create Department instance");
            Departement dp = new Departement("testDpName");
            log.debug("call ajouterDepartement() with created instance");
            idDepartment = es.ajouterDepartement(dp);

            es.affecterDepartementAEntreprise(1, 1);
        } catch (Exception e) {
            log.error("The method ajouterDepartement fails:" + e);

        }
    }

}
