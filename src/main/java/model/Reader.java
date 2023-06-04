package model;

import java.io.File;
import java.io.FilenameFilter;
public class Reader {

    public static File lookFile(String folderPath ) { //On passe en paramètre de la fonction le chemin à scruter

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
                return file;
            }
        } else {
            System.out.println("Aucun fichier trouvé dans le dossier spécifié.");
        }
        return null;
    }

}
