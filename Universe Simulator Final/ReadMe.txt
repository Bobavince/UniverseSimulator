# Universe Simulator V1.0
Simulateur d'univers : gestion des trajectoires, gravitation, et collisions d'objets massiques.
====================================
Notes diverses :
- Nous avons �viter les racines (trop couteux en processeur)
- Les coordonn�es peuvent �tre arbitraire, il suffit d'�tre coh�rent avec le rayon donn� aux objets. Les coordonn�es conseill�es sont de -100 � 1000 sur les deux axes pour effectuer des tests simples.
- La vitesse et l'acc�l�ration n'ont pas besoin d'�tre modifi� (except� si on veut cr�er des situations particuli�rement, "stables" par exemple
- Les types Terre, M�t�orit�, Etoile Naine Rouge sont repr�sent�s par des images en lieu et place de cercle color�s.
- La taille (rayon) ne peut �tre que positif. Le rayon conseill� est de 20 � 50 pour effectuer des tests simples.
- La masse peut �tre n�gative ou positive. La masse conseill�e est de 100 � 1000 pour effectuer des tests simples.
- Une javadoc est disponible dans le dossier du m�me nom. Un raccourci est pr�sent � la racine de l'archive.
- Un fichier .JAR d�j� compil� du programme est disponible dans le dossier "Compil� en JAR".
- 4 images sont recommand�s pour l'execution du programme dans les meilleurs conditions (afin d'�viter des throw d'erreurs) et sont pr�sente dans le dossier "source".
=====================================================================
LIST DES OBJECTIFS ATTEINTS: 
====================================
GENERAL : 
+ Param�tres g�n�raux en acc�s libre, modification autoris�e � l'arr�t (lors de la pause) : Gravit�, vitesse, coordonn�es, acc�l�ration, taille, masse, type, couleur
+ Affichage dynamique : mise � l'�chelle automatique
+ Ajout objet : Invite avec taille, vitesse, placement 
+ Pause et reprise
+ Le bouton Autoscale est bistable, et permet d'ajuster la vue ou non � la situation.
+ Le bouton T->T+1 permet d'avancer pas � pas dans la simulation, pour voir �voluer les param�tres du chaque objet.
+ Possibilit� de bouger dans la vue gr�ce � une fonction d'"autoscale" permettant d'adapter automatiquement la vue aux objets en pr�sence.
+ Liste pour naviguer entre les objets
+ Informations sur les objets dans leur onglet propre : coordonn�es, vitesse, acc�l�ration, masse, taille (diam�tre), type pr�d�fini, incandescence ...
====================================
MOTEUR : 
+ Constant G � -10
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
+ mettre � jour objet
====================================
VECTEUR :
+ 3 double
+ multiplication
+ addition
+ addition
+ norme
+ produit scalaire
+ equal
+ vecteur normalis�
====================================
=====================================================================
