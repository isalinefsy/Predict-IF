/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ifoissey
 */
public class TestUtilisateur {
    long id;
    String nom;
    String prenom;
    String mail;

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public TestUtilisateur(long id, String nom, String prenom, String mail) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "{" + "id :" + id + ", nom :" + nom + ", prenom :" + prenom + ", mail :" + mail + '}';
    }
    
}

