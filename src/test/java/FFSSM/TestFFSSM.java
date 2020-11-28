package FFSSM;

import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johan
 */
public class TestFFSSM {
    Club club;
    Moniteur organisateur;
    Plongeur untel1,untel2;
    Plongee palanquee,palanquee2;
    LocalDate datenaissanceOrg,datenaissancePlo,datePlongee,dateDelivrancePerimee,dateDelivranceValable,debutEmbauche,finEmbauche;
    Site site;
    Licence l,l2;
    
    @BeforeEach
    public void setUp() throws Exception{
        datenaissanceOrg = LocalDate.of(1980, 1, 1);
        datenaissancePlo = LocalDate.of(1975, 2, 2);
        datePlongee = LocalDate.of(2020, 11, 25);
        dateDelivrancePerimee = LocalDate.of(2018, 1, 1);
        dateDelivranceValable = LocalDate.of(2020, 1, 1);
        debutEmbauche = LocalDate.of(2019, 01, 01);
        finEmbauche = LocalDate.of(2020, 01,01);
        site = new Site("Pacifique","Atlantique");
        organisateur = new Moniteur("1234","Bastide","Jean","1 Rue de la trez","0652478963",datenaissanceOrg,1);
        club = new Club(organisateur,"Club de plongée","0658794521","15 rue drerm");
        untel1 = new Plongeur(0,"0001","Laride","Paul","15 rue Briou","0650487896",datenaissancePlo,GroupeSanguin.APLUS);
        untel2= new Plongeur(0,"0002","Briuo","Fredo","50 rue Grize","0645789632",datenaissancePlo,GroupeSanguin.AMOINS);
        palanquee = new Plongee(site,organisateur,datePlongee, 10,2);
        palanquee2 = new Plongee(site,organisateur,datePlongee, 10,2);

        l = new Licence(untel1,"001",dateDelivrancePerimee,0,club);
        l2 = new Licence(untel1,"002",dateDelivranceValable,0,club);
    }
    
    @Test
    public void testValiditéLicence(){
        assertFalse(l.estValide(datePlongee),"La licence devrait être périmée");
        assertTrue(l2.estValide(datePlongee),"La licence ne devrait pas être périmée");        
    }
    
    @Test
    public void testPlongeesNonConformes(){
        untel1.ajouterLicence("001", dateDelivrancePerimee);
        palanquee.ajouteParticipant(untel1);
        club.organisePlongee(palanquee);
        assertTrue(club.plongeesNonConformes().contains(palanquee),"La plongée doit être non conforme car le participant a une licence périmée.");
        untel2.ajouterLicence("002", dateDelivranceValable);
        palanquee2.ajouteParticipant(untel2);
        club.organisePlongee(palanquee2);
        assertFalse(club.plongeesNonConformes().contains(palanquee2),"La plongée ne doit pas apparaître dans la collection.");
    }
    
   
    
    
    @Test
    public void testEstConforme(){
        untel1.ajouterLicence("003", dateDelivrancePerimee);
        untel2.ajouterLicence("004",dateDelivranceValable);
        palanquee.ajouteParticipant(untel2);
        assertTrue(palanquee.estConforme(),"La palanquée devrait être conforme.");
        palanquee.ajouteParticipant(untel1);
        assertFalse(palanquee.estConforme(),"La palanquée ne devrait pas être conforme.");
    }

}