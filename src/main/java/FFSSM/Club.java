/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Club {

    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public TreeSet<Plongee> lesPlongées;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    Club(Moniteur organisateur, String club_de_plongée, String string, String _rue_drerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Club(Moniteur president, String nom, String adresse, String telephone, TreeSet<Plongee> lesPlongées) {
        this.president = president;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.lesPlongées = lesPlongées;
    }

    public TreeSet<Plongee> getLesPlongées() {
        return lesPlongées;
    }

    public void setLesPlongées(TreeSet<Plongee> lesPlongées) {
        this.lesPlongées = lesPlongées;
    }

    
    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club. Une
     * plongée est conforme si tous les plongeurs de la palanquée ont une
     * licence valide à la date de la plongée
     *
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        TreeSet<Plongee> p = new TreeSet<Plongee>();
        for (Plongee pl : lesPlongées) {
            if (pl.estConforme()) {
            } else {
                p.add(pl);
            }
        }

        return p;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     *
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        lesPlongées.add(p);
    }

    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
