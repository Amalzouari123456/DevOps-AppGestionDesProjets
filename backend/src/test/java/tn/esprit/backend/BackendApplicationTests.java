package tn.esprit.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

    // TEST VOLONTAIREMENT FAUX : sert à vérifier l'envoi de l'email d'échec.
    // A SUPPRIMER après le test.
    @Test
    void testEchecVolontaire() {
        assertEquals(1, 2);
    }

}
