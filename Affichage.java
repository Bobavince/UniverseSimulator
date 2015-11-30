import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Affichage extends JFrame {
	
	//---- ELEMENTS NON GRAPHIQUES ----
	ListeObjet listeDesParticules = new ListeObjet();
	Moteur moteurPhysique = new Moteur(1); //1 est le Coef de gravité

	//---- ELEMENTS NECESSAIRES ----
	// AJOUT/RETIRER BOUTONS
	private JButton boutonAjout = new JButton("Ajouter Particule");
	private JButton boutonRetirer = new JButton("Retirer Particule");
	// LISTE PARTICULE ELEMENTS
	private JLabel labelListe = new JLabel("Liste particules");
	private JComboBox<Particule> listeObjets = new JComboBox<Particule>();
	// COORDONNES ELEMENTS
	private JLabel labelCoord = new JLabel("Coordonnées");
	private JLabel labelX = new JLabel(" x ");
	private JLabel labelY = new JLabel(" y ");
	//private JLabel labelZ = new JLabel(" z ");
	private JSpinner coordX = new JSpinner();
	private JSpinner coordY = new JSpinner();
	//private JSpinner coordZ = new JSpinner();
	// VITESSES ELEMENTS
	private JLabel labelVitesse = new JLabel("Vitesse");
	private JLabel labelVx = new JLabel(" Vx ");
	private JLabel labelVy = new JLabel(" Vy ");
	//private JLabel labelVz = new JLabel(" Vz ");
	private JSpinner vitesX = new JSpinner();
	private JSpinner vitesY = new JSpinner();
	//private JSpinner vitesZ = new JSpinner();
    //ACCELERATION ELEMENT
	private JLabel labelAcceleration = new JLabel("Accélération");
	private JLabel labelAx = new JLabel(" Ax ");
	private JLabel labelAy = new JLabel(" Ay ");
	//private JLabel labelAz = new JLabel(" Az ");
	private JSpinner accelX = new JSpinner();
	private JSpinner accelY = new JSpinner();
	//private JSpinner accelZ = new JSpinner();
	//MASSE COULEUR RAYON
	private JLabel labelMasse = new JLabel(" Masse ");
	private JLabel labelCouleur = new JLabel(" Couleur ");
	private JLabel labelRayon = new JLabel(" Rayon ");
	private JSpinner spinnerMasse = new JSpinner();
	private JSpinner spinnerRayon = new JSpinner();
	private JButton boutonCouleur = new  JButton("Modifier couleur");
	
	// NEXT BOUTON
	private JButton boutonNext = new JButton("t -> t+1");
	// FORME DES JSPINNER EN MODE "DOUBLE"
	//A MODIFIER // SpinnerNumberModel modelJSpinnerDouble = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
	
	//---- ELEMENTS EVOLUES ----
	
	private JLabel labelConsole = new JLabel("Console");
	private JTextArea areaConsole = new JTextArea();
	
	private JLabel labelCstGravitation = new JLabel("Constante Gravitation");
	private JSpinner cstGravitation = new JSpinner();

	private JLabel labelVitesseSimulation = new JLabel("Vitesse simulation");
	private JSpinner vitesseSimulation = new JSpinner();
	
	private JButton boutonPause = new JButton("PAUSE");
	
	//TOUS LE JPANEL
	JPanel conteneurPrincipal;
	PanelDessin conteneurNordPrincipal;
	JPanel conteneurSudPrincipal;
	JPanel conteneurSudOuest;
	JPanel conteneurSudEst;
	
	public Affichage() {
		setSize(1080,600); //Dimension initiales
		setMinimumSize(new Dimension(1240, 600)); // dimensions minimales /!\ 870 est la longueur minimale pour que les boutons soient affichés correctement !

		// ---- ELEMENTS GENERAUX ----
		//CONTENEUR PRINCIPAL DE LA FENETRE (pas forcément nécessaire ... peut être)
		conteneurPrincipal = new JPanel();

		//DEUX PRINCIPAUX CONTENEURS
		conteneurNordPrincipal = new PanelDessin(this);
		conteneurSudPrincipal = new JPanel();

		//DEUX PETITS CONTENEURS
		conteneurSudOuest = new JPanel();
		conteneurSudEst = new JPanel();
		
		//STRUCTURE PRINCIPALE AVEC 2 STRUCTURES SECONDAIRES
		conteneurPrincipal.setLayout(new BorderLayout());
		conteneurPrincipal.add(conteneurNordPrincipal, BorderLayout.CENTER);
		conteneurPrincipal.add(conteneurSudPrincipal, BorderLayout.SOUTH);
		
		//STRUCTURE SECONDAIRE SUD AVEC 2 STRUCTURES TERTIAIRES
		conteneurSudPrincipal.setLayout(new BorderLayout());
		conteneurSudPrincipal.add(conteneurSudOuest, BorderLayout.WEST);
		conteneurSudPrincipal.add(conteneurSudEst, BorderLayout.EAST);
		
		//On crée un conteneur pour un affichage pour les boutons ajouter/retirer
		JPanel conteneurAjoutRetirer = new JPanel();
		conteneurAjoutRetirer.setLayout(new GridLayout(1,2,5,5));
		conteneurAjoutRetirer.add(boutonAjout);
		conteneurAjoutRetirer.add(boutonRetirer);
		
		//On crée un conteneur pour un affichage à l'utilisateur
		JPanel conteneurConsole = new JPanel();
		conteneurConsole.setLayout(new GridLayout(1,2,5,5));
		conteneurConsole.add(labelConsole);
		conteneurConsole.add(areaConsole);
		
		//On crée un conteneur pour la gravitation
		JPanel conteneurGravitation = new JPanel();
		conteneurGravitation.setLayout(new GridLayout(1,2,5,5));
		conteneurGravitation.add(labelCstGravitation);
		conteneurGravitation.add(cstGravitation);
		
		//On crée un conteneur pour la vitesse de Simulation
		JPanel conteneurVitesseSimulation = new JPanel();
		conteneurVitesseSimulation.setLayout(new GridLayout(1,2,5,5));
		conteneurVitesseSimulation.add(labelVitesseSimulation);
		conteneurVitesseSimulation.add(vitesseSimulation);
		
		//On crée un conteneur pour la Pause et Next
		JPanel conteneurPauseNext = new JPanel();
		conteneurPauseNext.setLayout(new GridLayout(1,2,5,5));
		//conteneurPauseNext.add(boutonPause); // A AJOUTER QUAND LA FONCTION SERA DISPONIBLE
		conteneurPauseNext.add(boutonNext);
		
		//On centres les JLabel
		labelConsole.setHorizontalAlignment(JLabel.CENTER);
		labelCstGravitation.setHorizontalAlignment(JLabel.CENTER);
		labelVitesseSimulation.setHorizontalAlignment(JLabel.CENTER);
		
		//GESTON LOGO
		ImageIcon image = new ImageIcon("UNIVERSE2.png");
		JLabel imagelabel = new JLabel(image);
		
		//DEFINIT FORME QUART BAS GAUCHE + AJOUTS ELEMENTS
		conteneurSudOuest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
		conteneurSudOuest.setLayout(new GridLayout(0,1,5,5));
		conteneurSudOuest.add(conteneurAjoutRetirer);
		conteneurSudOuest.add(imagelabel);
			//--- POUR L'INSTANT INUTILE, DECOMMENTEZ SI IMPLEMENTE ----
			//conteneurSudOuest.add(conteneurConsole);
			//conteneurSudOuest.add(conteneurGravitation);
			//conteneurSudOuest.add(conteneurVitesseSimulation);
		conteneurSudOuest.add(conteneurPauseNext);
		//---- FIN BLOC SUD OUEST ----
		
		//---- DEBUT BLOC SUD EST ----
		//On crée un conteneur pour la liste de particule
		JPanel conteneurListe = new JPanel();
		conteneurListe.setLayout(new GridLayout(1,2,5,5));
		conteneurListe.add(labelListe);
		conteneurListe.add(listeObjets);
		
		//On centre tous les JLabel
		labelListe.setHorizontalAlignment(JLabel.CENTER);
		
		//On crée un conteneur pour les coordonnées
		JPanel conteneurCoord = new JPanel();
		conteneurCoord.setLayout(new GridLayout(1,7,5,5));
		conteneurCoord.add(labelCoord);
		conteneurCoord.add(labelX);
		conteneurCoord.add(coordX);
		conteneurCoord.add(labelY);
		conteneurCoord.add(coordY);
		//conteneurCoord.add(labelZ);
		//conteneurCoord.add(coordZ);
        
		//On centre tous les JLabel
		labelCoord.setHorizontalAlignment(JLabel.CENTER);
		labelX.setHorizontalAlignment(JLabel.CENTER);
		labelY.setHorizontalAlignment(JLabel.CENTER);
		//labelZ.setHorizontalAlignment(JLabel.CENTER);

		//On crée un conteneur pour les vitesse
		JPanel conteneurVitesse = new JPanel();
		conteneurVitesse.setLayout(new GridLayout(1,7,5,5));
		conteneurVitesse.add(labelVitesse);
		conteneurVitesse.add(labelVx);
		conteneurVitesse.add(vitesX);
		conteneurVitesse.add(labelVy);
		conteneurVitesse.add(vitesY);
		//conteneurVitesse.add(labelVz);
		//conteneurVitesse.add(vitesZ);
		
		//On centre tous les JLabel
		labelVitesse.setHorizontalAlignment(JLabel.CENTER);
		labelVx.setHorizontalAlignment(JLabel.CENTER);
		labelVy.setHorizontalAlignment(JLabel.CENTER);
		//labelVz.setHorizontalAlignment(JLabel.CENTER);

		//On crée un conteneur pour les accélérations
		JPanel conteneurAcceleration = new JPanel();
		conteneurAcceleration.setLayout(new GridLayout(1,7,5,5));
		conteneurAcceleration.add(labelAcceleration);
		conteneurAcceleration.add(labelAx);
		conteneurAcceleration.add(accelX);
		conteneurAcceleration.add(labelAy);
		conteneurAcceleration.add(accelY);
		//conteneurAcceleration.add(labelAz);
		//conteneurAcceleration.add(accelZ);
		
		//On centre tous les JLabel
		labelAcceleration.setHorizontalAlignment(JLabel.CENTER);
		labelAx.setHorizontalAlignment(JLabel.CENTER);
		labelAy.setHorizontalAlignment(JLabel.CENTER);
		//labelAz.setHorizontalAlignment(JLabel.CENTER);
		
		//On crée un conteneur pour les accélérations
		JPanel conteneurMasseRayonCouleur = new JPanel();
		conteneurMasseRayonCouleur.setLayout(new GridLayout(1,6,5,5));
		conteneurMasseRayonCouleur.add(labelMasse);
		conteneurMasseRayonCouleur.add(spinnerMasse);
		conteneurMasseRayonCouleur.add(labelRayon);
		conteneurMasseRayonCouleur.add(spinnerRayon);
		conteneurMasseRayonCouleur.add(labelCouleur);
		conteneurMasseRayonCouleur.add(boutonCouleur);
				
		//On centre tous les JLabel
		labelMasse.setHorizontalAlignment(JLabel.CENTER);
		labelCouleur.setHorizontalAlignment(JLabel.CENTER);
		labelRayon.setHorizontalAlignment(JLabel.CENTER);
		
		//On met les boutons dans les interfaces : interface bas droite
		JPanel conteneurParticule = new JPanel();
		conteneurParticule.setLayout(new GridLayout(4,1,5,5));
		conteneurParticule.add(conteneurCoord);
		conteneurParticule.add(conteneurVitesse);
		conteneurParticule.add(conteneurAcceleration);
		conteneurParticule.add(conteneurMasseRayonCouleur);
		
		//On rajoute des bordures pour que ce soit aéré.
		conteneurSudEst.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		conteneurListe.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		
		//On met tout dans le conteneur SUD EST.
		conteneurSudEst.setLayout(new BorderLayout());
		conteneurSudEst.add(conteneurListe, BorderLayout.NORTH);
		conteneurSudEst.add(conteneurParticule, BorderLayout.CENTER);
		
		//---- FIN BLOC SUD EST ----
		
		// ---- MODIFICATIONS DIVERSES ----
		//MODIFICATION DES JSPINNER EN DOUBLE. Problème : fait que tous les Jspinner se modifie de la même manière. Il faudrait donc crérer autant de model que de JSpinner.
		/* modelJSpinnerDouble.setStepSize(0.1);
		
		coordX.setModel(modelJSpinnerDouble);
		coordY.setModel(modelJSpinnerDouble);
		coordZ.setModel(modelJSpinnerDouble);
		vitesX.setModel(modelJSpinnerDouble);
		vitesY.setModel(modelJSpinnerDouble);
		vitesZ.setModel(modelJSpinnerDouble);
		accelX.setModel(modelJSpinnerDouble);
		accelY.setModel(modelJSpinnerDouble);
		accelZ.setModel(modelJSpinnerDouble);
		cstGravitation.setModel(modelJSpinnerDouble);
		vitesseSimulation.setModel(modelJSpinnerDouble);*/
		
		// ---- ECOUTEURS ---- NOTE : DECOMENTEZ UNE FOIS IMPLEMENTE ! =)
		
		// AJOUT/RETIRER ECOUTEUR
		//EcouteurBoutonAjout EboutonAjout = new EcouteurBoutonAjout(this);
		//EcouteurBoutonRetirer EboutonRetirer = new EcouteurBoutonRetirer(this);
		// LISTE OBJET ECOUTEUR
		//EcouteurListeObjet ElisteObjets = new EcouteurListeObjet(this);
		// COORDONNES ECOUTEUR
		//EcouteurCoordX EcoordX = new EcouteurCoordX(this);
		//EcouteurCoordY EcoordY = new EcouteurCoordY(this);
		//EcouteurCoordZ EcoordZ = new EcouteurCoordZ(this);
		// VITESSES ECOUTEUR
		//EcouteurVitesX EvitesX = new EcouteurVitesX(this);
		//EcouteurVitesY EvitesY = new EcouteurVitesY(this);
		//EcouteurVitesZ EvitesZ = new EcouteurVitesZ(this);
	    //ACCELERATION ECOUTEUR
		//EcouteurAccelX EaccelX = new EcouteurAccelX(this);
		//EcouteurAccelY EaccelY = new EcouteurAccelY(this);
		//EcouteurAccelZ EaccelZ = new EcouteurAccelZ(this);
		//MASSE RAYON COULEUR ECOUTEURS
		//EcouteurMasse Emasse = new EcouteurMasse(this);
		//EcouteurRayon Erayon = new EcouteurRayon(this);
		//EcouteurCouleur EboutonCouleur = new EcouteurCouleur(this);  // J'ai une idée pour simplifier la gestion des couleurs : http://www.fobec.com/java/979/afficher-boite-dialogue-selection-une-couleur.html
		//boutonCouleur.addActionListener(EboutonCouleur); // POUR LA GESTION DES COULEURS, ME CONTACTER =D 
		// NEXT BOUTON ECOUTEUR
		EcouteurBoutonNext EboutonNext = new EcouteurBoutonNext(this);
		boutonNext.addActionListener(EboutonNext);
		
		// ---- FINALISATION ----
		//On attribue le conteneur principal à la fenêtre
		this.setContentPane(conteneurPrincipal);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermer le programme avec la croix
		this.setLocationRelativeTo(null); //Centre la fenêtre à l'écran
		this.setTitle("Universe Simulator"); //Entête de la fenêtre
		setVisible(true); //Afficher la fenêtre
	}

	public ListeObjet getListeObjets(){
		return listeDesParticules;
	}
	
	public PanelDessin getZoneDessin(){
		return conteneurNordPrincipal;
	}
	
	public Moteur getMoteur(){
		return moteurPhysique;
	}
	
	public Particule getJComboItem(){
		return (Particule) listeObjets.getSelectedItem();
	}

	public void setCoordX(double coordX) {
		this.coordX.setValue(coordX);
	}

	public void setCoordY(double coordY) {
		this.coordY.setValue(coordY);
	}

	public void setVitesX(double vitesX) {
		this.vitesX.setValue(vitesX);
	}

	public void setVitesY(double vitesY) {
		this.vitesY.setValue(vitesY);
	}

	public void setAccelX(double accelX) {
		this.accelX.setValue(accelX);
	}

	public void setAccelY(double accelY) {
		this.accelY.setValue(accelY);
	}
	
	public void setMasse(double masse) {
		this.spinnerMasse.setValue(masse);
	}
	
	public void setRayon(double rayon) {
		this.spinnerRayon.setValue(rayon);
	}
	
}
