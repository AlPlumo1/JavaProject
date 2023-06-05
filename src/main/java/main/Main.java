package main;
import java.io.File;
import java.util.List;
import model.*;
public class Main {
    public static void main(String[] args) {
        String folderPath = "src/main/resources/FileToLook";

        File[] files = Reader.lookFile(folderPath);
        System.out.println(files);


        // Parcourir les fichiers CSV trouvés
        for (File file : files) {

            Parser parser = new Parser(folderPath);
            List<DonneesRemboursement> donneesRemboursementList = parser.parse();

            // Peupler la base de données avec les entrées
            CRUD peuplement = new CRUD();
            boolean success = CRUD.processCSVFile(file);
        }
    }

}


