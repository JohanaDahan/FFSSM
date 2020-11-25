package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;



    public class Plongeur extends Personne {

    private ArrayList<Licence> lesLicences;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
    }

    public void ajouterLicence(Licence l) {
        lesLicences.add(l);
    }

    public Licence dernièreLicence() {
        return lesLicences.get(lesLicences.size() - 1);
    }
}
	

