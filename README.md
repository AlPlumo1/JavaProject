# JavaProject
Repo au sein duquel sera publié le projet de fin d'année de Programation orientée objets

Au cours de ce projet nous devions réaliser un projet Maven nous permettant de détécter l'ajout de nouveau fichiers au sein d'un dossier.
Ces fichiers ne seront détecté que si le format correspond a un nom standard (détecté via une regex dans le code") et si ils se trouvent dans le dossier nommé "FileToLook".
On notera que le chemin d'accés au fichier peut être modifié lors de l'appel de la fonction "lookFile" de la classe "Reader".

Si le format du nom est respecté ces fichier sont parsés afin d'être ensuite injecté dans une table SQL.
Une fois injecté dans la table ils sont déplacés dans un autre dossier nommé "Treated File". 

------------------------------------------------------------Base de données-----------------------------------------------------------

Pour la base de donnée nous avons choisi d'utiliser une base MySQL.
Ce sont des bases de données rapide a construire et qui sont relativement répandu donc leur documentation et les librairies sont nombreuses et bien documentés

Nous utilisons la version "8.0.33" du driver "mysql-connector-java". disponible au lien suivant : https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.33V

Voici a quoi ressemble l'architecture de la base : 


-----------------------------------------------------------Test Unitaires-----------------------------------------------------------

Afin de valider le bon fonctionnement du programme nous developpons une série de Test unitaires. Ces tests seront développés via JUnit
Nous utilisons JUnit dans sa version : "4.13.2" du driver "JUnit" disponible au lien : https://mvnrepository.com/artifact/junit/junit/4.13.2




