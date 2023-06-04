package model;

class DonneesRemboursement {
    private String numeroSecuriteSociale;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String numeroTelephone;
    private String email;
    private String idRemboursement;
    private String codeSoin;
    private double montantRemboursement;

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
}