# Universe Simulator V1.0
Simulateur d'univers : gestion des trajectoires, gravitation, et collisions d'objets massiques.
====================================
Notes diverses :
- Nous avons éviter les racines (trop couteux en processeur)
- Les coordonnées peuvent être arbitraire, il suffit d'être cohérent avec le rayon donné aux objets. Les coordonnées conseillées sont de -100 à 1000 sur les deux axes pour effectuer des tests simples.
- La vitesse et l'accélération n'ont pas besoin d'être modifié (excepté si on veut créer des situations particulièrement, "stables" par exemple
- Les types Terre, Météorité, Etoile Naine Rouge sont représentés par des images en lieu et place de cercle colorés.
- La taille (rayon) ne peut être que positif. Le rayon conseillé est de 20 à 50 pour effectuer des tests simples.
- La masse peut être négative ou positive. La masse conseillée est de 100 à 1000 pour effectuer des tests simples.
- Une javadoc est disponible dans le dossier du même nom. Un raccourci est présent à la racine de l'archive.
- Un fichier .JAR déjà compilé du programme est disponible dans le dossier "Compilé en JAR".
- 4 images sont recommandés pour l'execution du programme dans les meilleurs conditions (afin d'éviter des throw d'erreurs) et sont présente dans le dossier "source".
=====================================================================
LIST DES OBJECTIFS ATTEINTS: 
====================================
GENERAL : 
+ Paramètres généraux en accès libre, modification autorisée à l'arrêt (lors de la pause) : Gravité, vitesse, coordonnées, accélération, taille, masse, type, couleur
+ Affichage dynamique : mise à l'échelle automatique
+ Ajout objet : Invite avec taille, vitesse, placement 
+ Pause et reprise
+ Le bouton Autoscale est bistable, et permet d'ajuster la vue ou non à la situation.
+ Le bouton T->T+1 permet d'avancer pas à pas dans la simulation, pour voir évoluer les paramètres du chaque objet.
+ Possibilité de bouger dans la vue grâce à une fonction d'"autoscale" permettant d'adapter automatiquement la vue aux objets en présence.
+ Liste pour naviguer entre les objets
+ Informations sur les objets dans leur onglet propre : coordonnées, vitesse, accélération, masse, taille (diamètre), type prédéfini, incandescence ...
====================================
MOTEUR : 
+ Constant G à -10
+ Interaction entre 2 objets
+ Collision entre 2 objets
+ Execution d'un tour
====================================
AFFICHAGE : 
+ Afficher Fenetre
====================================
LISTE OBJET :
+ Liste des particules
+ Accesseur liste
+ mettre à jour objet
====================================
VECTEUR :
+ 3 double
+ multiplication
+ addition
+ addition
+ norme
+ produit scalaire
+ equal
+ vecteur normalisé
====================================
=====================================================================
