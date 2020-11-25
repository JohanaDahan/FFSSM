package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;



    public class Plongeur extends Personne {

    private ArrayList<Licence> lesLicences;
    private GroupeSanguin GS;
    private int niveau;
    private Club club;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.GS=GS;
    }

    public void setLesLicences(ArrayList<Licence> lesLicences) {
        this.lesLicences = lesLicences;
    }

    public void setGS(GroupeSanguin GS) {
        this.GS = GS;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public ArrayList<Licence> getLesLicences() {
        return lesLicences;
    }

    public GroupeSanguin getGS() {
        return GS;
    }

    public int getNiveau() {
        return niveau;
    }

    public Club getClub() {
        return club;
    }

    public void ajouterLicence(Licence l) {
        lesLicences.add(l);
    }

    public Licence dernièreLicence() {
        return lesLicences.get(lesLicences.size() - 1);
    }
}
	

