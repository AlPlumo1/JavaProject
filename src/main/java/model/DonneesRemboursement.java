package model;

import java.sql.Date;

public class DonneesRemboursement {
    private String numeroSecuriteSociale;
    private String nom;
    private String prenom;
    private java.sql.Date dateNaissance;
    private String numeroTelephone;
    private String email;
    private String idRemboursement;
    private String codeSoin;
    private double montantRemboursement;

    public boolean isValid() {
        if (numeroSecuriteSociale == null || numeroSecuriteSociale.isEmpty()) {
            return false; // Le numéro de sécurité sociale est obligatoire
        }

        if (nom == null || nom.isEmpty()) {
            return false; // Le nom est obligatoire
        }

        if (prenom == null || prenom.isEmpty()) {
            return false; // Le prénom est obligatoire
        }

        if (dateNaissance == null) {
            return false; // La date de naissance est obligatoire
        }

        if (codeSoin == null || codeSoin.isEmpty()) {
            return false; // Le code de soin est obligatoire
        }

        // Vérification des formats spécifiques
        if (numeroSecuriteSociale.length() != 13) {
            return false; // Le numéro de sécurité sociale doit avoir 13 caractères
        }

        // Ajoutez d'autres conditions de validation spécifiques selon vos besoins

        return true; // Toutes les validations ont réussi
    }

    // Constructeur, getters et setters

    @Override
    public String toString() {
        return "model.DonneesRemboursement{" +
                "numeroSecuriteSociale='" + numeroSecuriteSociale + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", email='" + email + '\'' +
                ", idRemboursement='" + idRemboursement + '\'' +
                ", codeSoin='" + codeSoin + '\'' +
                ", montantRemboursement=" + montantRemboursement +
                '}';
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = Date.valueOf(dateNaissance);
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdRemboursement() {
        return idRemboursement;
    }

    public void setIdRemboursement(String idRemboursement) {
        this.idRemboursement = idRemboursement;
    }

    public String getCodeSoin() {
        return codeSoin;
    }

    public void setCodeSoin(String codeSoin) {
        this.codeSoin = codeSoin;
    }

    public double getMontantRemboursement() {
        return montantRemboursement;
    }

    public void setMontantRemboursement(double montantRemboursement) {
        this.montantRemboursement = montantRemboursement;
    }


}