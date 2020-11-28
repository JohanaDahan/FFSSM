  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;

/**
 *
 * @author johan
 */
public class Main {	
    public static void main(String[] args) {
    Club club;
    Moniteur organisateur;
    Plongeur untel1,untel2;
    Plongee palanquee,palanquee2;
    LocalDate datenaissanceOrg,datenaissancePlo,datePlongee,dateDelivrancePerimee,dateDelivranceValable,debutEmbauche,finEmbauche;
    Site site;
    Licence l,l2;
    
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
	
        organisateur.nouvelleEmbauche(club, debutEmbauche);
        organisateur.employeurActuel();
	}
    
}
