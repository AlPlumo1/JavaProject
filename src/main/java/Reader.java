import java.io.File;
import java.io.FilenameFilter;
public class Reader {

    public static void lookFile(String[] args) {
        String folderPath = "src/resources/FileToLook"; // Remplacez par le chemin absolu du dossier à scruter

        File folder = new File(folderPath);

        // Création du regex pour detecter le format du nom"
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches("[A-Za-z]+_\\d{14}\\.csv");
            }
        };

        File[] files = folder.listFiles(filter);

        // Parcours des fichiers trouvés
        if (files != null) {
            for (File file : files) {
                System.out.println("Fichier trouvé : " + file.getName());
                return;
            }
        } else {
            System.out.println("Aucun fichier trouvé dans le dossier spécifié.");
        }
    }
}
