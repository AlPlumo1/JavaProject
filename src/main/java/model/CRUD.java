package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CRUD {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Projet_Maven";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root";

    private static final String FILES_DIRECTORY = "src/main/resources/FileToLook";
    private static final String PROCESSED_DIRECTORY = "src/main/resources/TreatedFiles";
    private static final String REJECTED_DIRECTORY = "src/main/resources/Rejected_Directory";

    public static void main(String[] args) throws IOException {
        File[] csvFiles = getCSVFiles(FILES_DIRECTORY);
        for (File file : csvFiles) {
            if (processCSVFile(file)) {
                moveFileToDirectory(file, PROCESSED_DIRECTORY);
            } else {
                moveFileToDirectory(file, REJECTED_DIRECTORY);
            }
        }
    }

    private static File[] getCSVFiles(String directory) {
        File folder = new File(directory);
        return folder.listFiles((dir, name) -> name.endsWith(".csv"));
    }

    public static boolean processCSVFile(File file) {
        Parser parser = new Parser(file.getPath());
        List<DonneesRemboursement> donneesRemboursementList = parser.parse();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {
            for (DonneesRemboursement donneesRemboursement : donneesRemboursementList) {
                if (donneesRemboursement.isValid()) {
                    insertOrUpdateRecord(connection, donneesRemboursement);
                } else {
                    System.err.println("Erreur : ligne mal formatée - " + donneesRemboursement);
                    return false; // Ligne incorrecte
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Erreur lors du traitement du fichier
        }

        return true; // Fichier traité avec succès
    }

    private static void insertOrUpdateRecord(Connection connection, DonneesRemboursement donneesRemboursement) throws SQLException {
        String query = "INSERT INTO remboursement (id_remboursement, numero_securite_sociale, nom, prenom, date_naissance, " +
                "numero_telephone, e_mail, code_soin, montant_remboursement) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE " +
                "numero_securite_sociale = VALUES(numero_securite_sociale), " +
                "nom = VALUES(nom), " +
                "prenom = VALUES(prenom), " +
                "date_naissance = VALUES(date_naissance), " +
                "numero_telephone = VALUES(numero_telephone), " +
                "e_mail = VALUES(e_mail), " +
                "code_soin = VALUES(code_soin), " +
                "montant_remboursement = VALUES(montant_remboursement)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, donneesRemboursement.getIdRemboursement());
            statement.setString(2, donneesRemboursement.getNumeroSecuriteSociale());
            statement.setString(3, donneesRemboursement.getNom());
            statement.setString(4, donneesRemboursement.getPrenom());
            statement.setDate(5, donneesRemboursement.getDateNaissance());;
            statement.setString(6, donneesRemboursement.getNumeroTelephone());
            statement.setString(7, donneesRemboursement.getEmail());
            statement.setString(8, donneesRemboursement.getCodeSoin());
            statement.setDouble(9, donneesRemboursement.getMontantRemboursement());
            statement.executeUpdate();
        }
    }

    private static void moveFileToDirectory(File file, String directory) throws IOException {
        Path source = file.toPath();
        Path destination = Path.of(directory, file.getName());
        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
