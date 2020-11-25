/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author johan
 */
public class TestFFSSM {

    private Plongeur p1;
    private Plongeur p2;
    private Moniteur m;
    private Club c;
    private Licence l1;
    private Licence l2;
    private Site s;
    private Plongee p;

    @BeforeEach
    public void setUp() throws Exception {
        p1 = new Plongeur("1", "Dupont", "Jean", "3 rue du Pivert", "0606060606", LocalDate.of(1980, 8, 4), 2);
        p2 = new Plongeur("3", "Dupont", "Alex", "3 rue du Pivert", "0606060607", LocalDate.of(2004, 7, 5), 1);
        m = new Moniteur("2", "Leblanc", "Yves", "3 chemin des violettes", "0612345678", LocalDate.of(1987, 5, 5), 1, 4);
        c = new Club(m, "Le Nautilus", "0651486545");
        l1 = new Licence(p1, "1", LocalDate.of(2020, 10, 10), 2, c);
        l2 = new Licence(p2, "3", LocalDate.of(20, 8, 4), 3, c);
        s = new Site("Les Trois Rochers", "trois rochers qui forment une cavernes");
        p = new Plongee(s, m, LocalDate.of(2021, 7, 5), 20, 30);
    }

    @Test
    public void testLicenceValide() {
        assertFalse(l2.estValide(LocalDate.now()));
        assertTrue(l1.estValide(LocalDate.now()));
    }

    @Test
    public void testPlongeeAjoute() {
        p.ajouteParticipant(p1);
        assertFalse(p.getPalanquée().isEmpty());
    }

    @Test
    public void testPlongeeConforme() {
        p.ajouteParticipant(p1);
        p.ajouteParticipant(p2);
        assertFalse(p.estConforme());
    }

    @Test
    public void tesPlongeurDernièreLicence() {
        p1.ajouterLicence(l1);
        assertEquals(p1.dernièreLicence(), l1);
    }
}