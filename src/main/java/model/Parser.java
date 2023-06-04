package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Parser {

    private String filePath;
    public Parser(String filePath) {
       this.filePath = filePath;
    }

    public List<DonneesRemboursement> parse() {
        List<DonneesRemboursement> donneesRemboursementList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 9) {
                    String numeroSecuriteSociale = fields[0].trim();
                    String nom = fields[1].trim();
                    String prenom = fields[2].trim();
                    String dateNaissance = fields[3].trim();
                    String numeroTelephone = fields[4].trim();
                    String email = fields[5].trim();
                    String idRemboursement = fields[6].trim();
                    String codeSoin = fields[7].trim();
                    double montantRemboursement = Double.parseDouble(fields[8].trim());

                    DonneesRemboursement donneesRemboursement = new DonneesRemboursement();
                    donneesRemboursementList.add(donneesRemboursement);
                } else {
                    System.out.println("Erreur : ligne mal formatée - " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return donneesRemboursementList;
    }
}

