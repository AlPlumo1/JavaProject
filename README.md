# JavaProject
Repo au sein duquel sera publié le projet de fin d'année de Programation orientée objets

Au cours de ce projet nous devions réaliser un projet Maven nous permettant de détécter l'ajout de nouveau fichiers au sein d'un dossier.
Ces fichiers ne seront détecté que si le format correspond a un nom standard (détecté via une regex dans le code") et si ils se trouvent dans le dossier nommé "FileToLook".
On notera que le chemin d'accés au fichier peut être modifié lors de l'appel de la fonction "lookFile" de la classe "Reader".

Si le format du nom est respecté ces fichier sont parsés afin d'être ensuite injecté dans une table SQL.
Une fois injecté dans la table ils sont déplacés dans un autre dossier nommé "Treated File". 

---------------------------Base de données------------------------------

Pour la base de donnée nous avons choisi d'utiliser une base MySQL.
Ce sont des bases de données rapide a construire et qui sont relativement répandu donc leur documentation et les librairies sont nombreuses et bien documentés

Nous utilisons la version "8.0.33" du driver "mysql-connector-java". disponible au lien suivant : https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.33V

Voici a quoi ressemble l'architecture de la base qui tourne en local: 

Base : Projet_Maven
Username : root 
Password : root

Table : remboursement 
 
Voici la commande permettant de générer la table :

CREATE TABLE projet_maven.remboursement
(
    id_remboursement int,
    numero_securite_sociale int(13),
    nom varchar(255),
    prenom varchar(255),
    date_naissance datetime,
    numero_telephone varchar(10),
    e_mail varchar(255),
    code_soin int,
    montant_remboursement int
);

-----------------------------Test Unitaires----------------------------

Afin de valider le bon fonctionnement du programme nous developpons une série de Test unitaires. Ces tests seront développés via JUnit
Nous utilisons JUnit dans sa version : "4.13.2" du driver "JUnit" disponible au lien : https://mvnrepository.com/artifact/junit/junit/4.13.2

Actuellement les tests unitaires ne sont malheuresement pas fonctionnels. 

------------------------------Classes----------------------------------

Dans ce projet nous avons pour l'instant 4 classes model et 1 classe "main" : 

Les classes sont les suivantes : 
  - Reader : vérifie le dossier et lis si de nouveaux fichiers présents respecte le format
  - Parser : parse les données présentent dans le fichier
  - DonneesRemboursement : met en forme les données pour qu'elles soient traité
  - CRUD : peuple la base de données grâce aux données mise en former précédemment 
  
------------------------------Ressources----------------------------------

Dans le dossier ressources on retrouve 3 dossiers : 
  - FileToLook : le dossier scruté par la classe "Reader"
  - Processed_Directory : le dossier dans lequel seront mis les fichiers qui auront été traités 
  - Rejected_Directory : le dossier dans lequel seront mis les fichiers qui n'auront pas été traités 
